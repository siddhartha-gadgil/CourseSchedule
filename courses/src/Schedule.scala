package courses

case class Schedule(sch: Map[Course, Timing]){
  val clashes: Map[Course, Course] =
    for {
      (c1, t1) <- sch
      (c2, t2) <- sch
      if t1 == t2 && c1.code < c2.code
    } yield (c1, c2)
}

case class Preference(course: Course, timings: Set[(Int, Timing)]){
  def prefOpt(t: Timing): Option[Int] = timings.find(_._2 == t).map(_._1)

  def bounded(n: Int): Set[Timing] = timings.filter(_._1 <= n).map(_._2)
}