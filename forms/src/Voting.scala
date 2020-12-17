package forms

case class Voting(allVotes: Vector[(String, Vector[String])]) {
  def voteOption(votes: Vector[String], eligible: Vector[String]) =
    votes.filter(eligible.contains(_)).headOption
  def currentVotes(eligible: Vector[String]): Vector[(String, Vector[String])] =
    allVotes
      .flatMap {
        case (name, votes) =>
          voteOption(votes, eligible).map { v =>
            name -> v
          }
      }
      .groupMap(_._2)(_._1)
      .toVector
      .sortBy(_._2.size)
      .reverse

  def nextStep(eligible: Vector[String]): Vector[String] = {
    val votes = currentVotes(eligible)
    println("Current standing:")
    votes.zipWithIndex.foreach {
      case ((x, ys), n) =>
        println(s"${n + 1}. $x : ${ys.size} (${ys.mkString(", ")})")
    }
    println()

    val minVotes = votes.map(_._2.size).min
    votes.takeWhile(_._2.size > minVotes).map(_._1)
  }

  @annotation.tailrec
  final def recWinners(eligible: Vector[String]): Vector[String] = {
    val survivors = nextStep(eligible)
    if (survivors.nonEmpty) recWinners(survivors) else eligible
  }

  lazy val winners: Vector[String] = recWinners(
    allVotes.flatMap(_._2.headOption)
  )
}

object Voting {
  val dataMF2020 = os.read
    .lines(os.resource / "martin-foster-2020.tsv")
    .toVector
    .tail
    .map(_.split("\t").toVector.tail.map(_.trim))
    .map(v => v.head -> v.tail)

  val mf2020 = Voting(dataMF2020)
}
