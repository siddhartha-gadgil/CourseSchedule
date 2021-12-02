import courses._
import BestChoice._

best
best.size

bestSW
bestSW.size
bestSW.map(_.clashes.size)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
commonClashes.size
val minClashSize = bestSW.map(_.clashes.size).min
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
minClashes.size
// minClashes(0).diff(minClashes(1))
val chosen = minClashes(0)
chosen.sch.size

chosen.tsv
chosen.clashes.mkString("\n")
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
StudentChoices
  .weakClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
chosen.sorted.groupMap(_._2)(_._1)
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)
