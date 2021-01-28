package courses

import StudentChoices._
import scala.util.Try

object StudentChoices {
  val groupMap: Map[String, Set[Course]] =
    Map(
      "Undergraduate 3rd year" -> CourseData.core1.toSet
        .filterNot(c => Set("MA 229", "MA 241").contains(c.code)),
      "Int. Ph. D second year" -> CourseData.core2.toSet
    )
  def groupCourses(gp: String): Set[Course] = groupMap.getOrElse(gp, Set())

  def getCourse(s: String) = CourseData.get(s.trim.take(6))

  def fromVec(v: Vector[String]) =
    StudentChoices(
      v(1),
      v(2),
      Try(v(3).split(",").toSet.map(getCourse).flatten).getOrElse(Set()),
      Try(v(4).split(",").toSet.map(getCourse).flatten).getOrElse(Set())
    )

  lazy val dataLines = os.read
    .lines(SavedData.dat / "students.tsv")
    .map(_.split("\t").toVector)
    .toVector
    .drop(1)

  lazy val all = dataLines.map(fromVec(_))

  def strongClashes(
      sch: Schedule
  ): Map[(Course, Course), Vector[StudentChoices]] =
    sch.clashes.map {
      case (c1, c2) => (c1, c2) -> all.filter(_.strongClash(c1, c2))
    }.toMap

  def numStrongClashes(sch: Schedule) = strongClashes(sch).mapValues(_.size)

  def totalStrongClashes(sch: Schedule) = numStrongClashes(sch).values.sum

  def weakClashes(sch: Schedule) =
    sch.clashes.map {
      case (c1, c2) => (c1, c2) -> all.filter(_.weakClash(c1, c2))
    }.toMap

  def numWeakClashes(sch: Schedule) = weakClashes(sch).mapValues(_.size)

  def totalWeakClashes(sch: Schedule) = numWeakClashes(sch).values.sum

  def clashScores(sched: Scheduler) =
    sched.bestChoices
      .map(
        s => s -> (totalStrongClashes(s), totalWeakClashes(s), s.clashes.size)
      )
      .toMap

}

case class StudentChoices(
    name: String,
    group: String,
    willTake: Set[Course],
    mayTake: Set[Course]
) {
  val strongTake = willTake.union(groupCourses(group))
  val weakTake = strongTake.union(mayTake)

  def strongClash(c1: Course, c2: Course) =
    strongTake.contains(c1) && strongTake.contains(c2)

  def weakClash(c1: Course, c2: Course) =
    weakTake.contains(c1) && weakTake.contains(c2)
}

object BestChoice {
  lazy val sch = SavedData.scheduler
  lazy val best = sch.bestChoices
  lazy val minStrong = best.map(totalStrongClashes).min
  lazy val bestStrong = best.filter(s => totalStrongClashes(s) == minStrong)
  lazy val minWeak = bestStrong.map(totalWeakClashes).min
  lazy val bestSW = bestStrong.filter(s => totalWeakClashes(s) == minWeak)
  lazy val chosen = {
    if (bestSW.size > 1)
      println(s"Warning, chosen head of ${bestSW.size} elements")
    bestSW.head
  }
  lazy val unhappy =
    strongClashes(chosen)
      .map {
        case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
      }
      .filter(_._2.nonEmpty)
}
