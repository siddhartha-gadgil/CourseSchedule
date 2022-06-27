package forms

/**
  * Class for choosing the winner for voting with ranked choice
  *
  * @param allVotes votes in ranked order
  */
case class Voting(
    allVotes: Vector[(String, Vector[String])],
    verbose: Boolean
) {

  /**
    * choose top vote, if any, among candidates who are still eligible
    *
    * @param votes the votes in rank
    * @param eligible candidates who are still eligible
    * @return vote as string, if any
    */
  def voteOption(votes: Vector[String], eligible: Vector[String]): Option[String] =
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
  def nextStep(eligible: Vector[String], round: Int): Vector[String] = {
    val votes = currentVotes(eligible)
    println(s"Round $round:")
    votes.zipWithIndex.foreach {
      case ((x, ys), n) =>
        val details = if (verbose) s" (${ys.mkString(", ")})" else ""
        println(s"${n + 1}. $x : ${ys.size}$details")
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
  final def recWinners(eligible: Vector[String], round: Int): Vector[String] = {
    val survivors = nextStep(eligible, round)
    if (survivors.nonEmpty) recWinners(survivors, round + 1) else eligible
  }

  /**
    * Winners
    *
    * @return Vector of winners
    */
  lazy val winners: Vector[String] = recWinners(
    allVotes.flatMap(_._2.headOption),
    1
  )
}

object Voting {
  def voterClass(filename: String, verbose: Boolean): Voting =
    Voting(
      os.read
        .lines(os.resource / filename)
        .toVector
        .tail
        .map(_.split("\t").toVector.tail.map(_.trim))
        .map(v => v.head -> v.tail),
      verbose
    )

  def mf2020(verbose: Boolean = true): Voting =
    voterClass("martin-foster-2020.tsv", verbose)

  def mf2021(verbose: Boolean = true): Voting =
    voterClass("martin-foster-2021.tsv", verbose)
}
