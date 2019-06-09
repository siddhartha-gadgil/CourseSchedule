package courses

import courses.Schedule.empty

import ujson.Js

case class Schedule(sch: Map[Course, Timing]) {
  val clashes: Set[(Course, Course)] =
    (for {
      (c1, t1) <- sch.toVector
      (c2, t2) <- sch.toVector
      if t1 == t2 && c1.code < c2.code
    } yield (c1, c2)).toSet

  def +(c: Course, t: Timing) = Schedule(sch + (c -> t))

  val sorted: Vector[(Course, Timing)] = sch.toVector.sortBy(_._1.code)

  val json: Js.Arr = {
    val jsV = sorted.map {
      case (c, t) => Js.Obj("course" -> c.json, "timing" -> t.json)
    }
    Js.Arr(jsV: _*)
  }
}

object Schedule {
  def empty: Schedule = Schedule(Map())

  def fromJson(js: Js.Value): Schedule = {
    val m =
      js.arr.toVector.map(
          jsV =>
            Course.fromJson(jsV.obj("course")) -> Timing.fromJson(
              jsV.obj("timing")))
        .toMap
    Schedule(m)
  }

}

case class Scheduler(prefs: Set[Preference],
                     avoid: (Course, Course) => Boolean) {
  def coursePref(c: Course): Option[Preference] = prefs.find(_.course == c)

  def rankOpt(c: Course, t: Timing): Option[Int] =
    coursePref(c).flatMap(_.prefOpt(t))

  def ranks(sc: Schedule): Map[Course, Int] =
    for {
      (c, t) <- sc.sch
      r <- rankOpt(c, t)
    } yield c -> r

  def byRank(sc: Schedule): Map[Int, Vector[Course]] =
    ranks(sc).toVector.groupBy(_._2).mapValues(cv => cv.map(_._1))

  def rankWeights(sc: Schedule): Map[Int, Int] = byRank(sc).mapValues(_.size)

  val supp: Set[Course] = prefs.map(_.course)

  val size: Int = supp.size

  def nextLex(w: Int, n: Int): (Int, Int) =
    if (n < size) (w, n + 1) else (w + 1, 1)

  def getAll(worst: Int,
             numWorst: Int,
             courses: Vector[Course] = supp.toVector): Set[Schedule] =
    courses match {
      case Vector() => Set(empty)
      case x +: ys =>
        prefs
          .find(_.course == x)
          .map { pref =>
            val top: Set[Schedule] =
              if (numWorst > 0)
                for {
                  timing <- pref.at(worst)
                  sch <- getAll(worst, numWorst - 1, ys)

                } yield sch + (x, timing)
              else Set()
            val inner =
              for {
                timing <- pref.bounded(worst - 1)
                sch <- getAll(worst, numWorst, ys)

              } yield sch + (x, timing)

            (top union inner).filter(sch =>
              !sch.clashes.exists({ case (c1, c2) => avoid(c1, c2) }))
          }
          .getOrElse(getAll(worst, numWorst, ys))
    }

  def getBest(worst: Int, numWorst: Int): (Set[Schedule], Int, Int) = {
    println(s"Trying worst choice $worst, occuring $numWorst times")
    val top = getAll(worst, numWorst)
    if (top.nonEmpty) (top, worst, numWorst)
    else {
      val (w, n) = nextLex(worst, numWorst)

      getBest(w, n)
    }
  }

  lazy val (bestChoices: Set[Schedule], worst: Int, numWorst) = getBest(1, size)

  lazy val minClashes: Int = bestChoices.map(_.clashes.size).min

  lazy val bestClashes: Set[Schedule] =
    bestChoices.filter(_.clashes.size == minClashes)

}

case class Preference(course: Course, timings: Set[(Int, Timing)]) {
  def prefOpt(t: Timing): Option[Int] = timings.find(_._2 == t).map(_._1)

  def bounded(n: Int): Set[Timing] = timings.filter(_._1 <= n).map(_._2)

  def at(n: Int): Set[Timing] = timings.filter(_._1 == n).map(_._2)
}
