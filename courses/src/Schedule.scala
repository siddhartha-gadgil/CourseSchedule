package courses

import courses.Schedule.empty

case class Schedule(sch: Map[Course, Timing]) {
  val clashes: Set[(Course, Course)] =
    (for {
      (c1, t1) <- sch
      (c2, t2) <- sch
      if t1 == t2 && c1.code < c2.code
    } yield (c1, c2)).toSet

  def +(c: Course, t: Timing) = Schedule(sch + (c -> t))
}

case class Scheduler(prefs: Set[Preference],

                     avoid: (Course, Course) => Boolean) {
  val supp: Set[Course] = prefs.map(_.course)

  val size: Int = supp.size

  def nextLex(w: Int, n: Int): (Int, Int) =
    if (n < size) (w, n + 1) else (w + 1, 1)

  def getAll(worst: Int, numWorst: Int,  courses: Vector[Course] = supp.toVector): Set[Schedule] =
    courses match {
      case Vector() => Set(empty)
      case x +: ys =>
        prefs
          .find(_.course == x)
          .map { pref =>
            val top: Set[Schedule] =
              if (numWorst > 1)
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

}

object Schedule {
  def empty: Schedule = Schedule(Map())

}

case class Preference(course: Course, timings: Set[(Int, Timing)]) {
  def prefOpt(t: Timing): Option[Int] = timings.find(_._2 == t).map(_._1)

  def bounded(n: Int): Set[Timing] = timings.filter(_._1 <= n).map(_._2)

  def at(n: Int): Set[Timing] = timings.filter(_._1 == n).map(_._2)
}
