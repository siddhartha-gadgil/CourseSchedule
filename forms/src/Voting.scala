package forms

/**
  * Class for choosing the winner for voting with ranked choice
  *
  * @param allVotes votes in ranked order
  */
case class Voting(allVotes: Vector[(String, Vector[String])]) {

  /**
    * choose top vote, if any, among candidates who are still eligible
    *
    * @param votes the votes in rank
    * @param eligible candidates who are still eligible
    * @return vote as string, if any
    */
  def voteOption(votes: Vector[String], eligible: Vector[String]) =
    votes.filter(eligible.contains(_)).headOption

  /**
    * all top votes for eligible candidates
    *
    * @param eligible the eligible candidates
    * @return Vector of candidates and those who vote for them after transfers, ordered by number of votes (leader first)
    */
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

  /**
    * Step for transferring votes, outputs results as side effect
    *
    * @param eligible eligible candidates
    * @return surviving eligible candidates after purge
    */
  def nextStep(eligible: Vector[String]): Vector[String] = {
    val votes = currentVotes(eligible)
    println("Current standing:")
    votes.zipWithIndex.foreach {
      case ((x, ys), n) =>
        println(s"${n + 1}. $x : ${ys.size} (${ys.mkString(", ")})")
    }
    println()

    val minVotes = votes.map(_._2.size).min //minimum number of votes among eligible candidates
    votes.takeWhile(_._2.size > minVotes).map(_._1)
  }

  /**
    * recursively compute winners
    *
    * @param eligible eligible candidates
    * @return Vector of winners
    */
  @annotation.tailrec
  final def recWinners(eligible: Vector[String]): Vector[String] = {
    val survivors = nextStep(eligible)
    if (survivors.nonEmpty) recWinners(survivors) else eligible
  }

  /**
    * Winners
    *
    * @return Vector of winners
    */
  lazy val winners: Vector[String] = recWinners(
    allVotes.flatMap(_._2.headOption)
  )
}

object Voting {
  def voterClass(filename: String) =
    Voting(
      os.read
        .lines(os.resource / filename)
        .toVector
        .tail
        .map(_.split("\t").toVector.tail.map(_.trim))
        .map(v => v.head -> v.tail)
    )

  val mf2020 = voterClass("martin-foster-2020.tsv")
}
