package ugc
import Data._

object Data {
  val paperInit = 2
  val numPapers = 7
  val confInit = paperInit + (numPapers * 10)
  val numConfs = 5
  val bookInit = confInit + (numConfs * 9)
  val numBooks = 4
  val bookChapterInit = bookInit + (numBooks * 8)
  val numBookChapters = 4
  val summerInit = bookChapterInit + (numBookChapters * 11)
  val numSummer = 7
  val grantInit = summerInit + (numSummer * 4)
  val numGrants = 4
  val awardsPos = grantInit + (numGrants * 6)
  val activitiesSize = 4
  val activiesInit = awardsPos + 3  
  val fullSize = activiesInit + (2 * activitiesSize) // because of old activities
  def pad(v: Vector[String]) = v ++ Vector.fill(fullSize - v.size)("")

  lazy val data = os.read
    .lines(os.resource / "ugc2020.tsv")
    .toVector
    .tail
    .map(_.split("\t").toVector.tail)
    .map(pad)

  lazy val summerStudents = data.flatMap(
    l =>
      SummerStudent.getAll(l).map { stu =>
        stu.text(l(0))
      }
  )

  lazy val summerTeX =
    s"""
\\subsection{Summer Students}

\\begin{enumerate}
${summerStudents.map(s => "\\item " + s).mkString("\n")}
\\end{enumerate}
"""
  lazy val facultyData: Vector[FacultyData] =
    data.map(l => FacultyData.get(l)).sortBy(_.name)

  lazy val grantsItems = facultyData.flatMap(f => f.grantTeX)

  lazy val grants =
    s"""
\\section{Resource Generation}

\\begin{enumerate}
${grantsItems.mkString("\n")}
\\end{enumerate}
"""

  lazy val reports = facultyData
    .map(d => s"\\subsection{${d.name}}\n\n${d.researchHighlights}")
    .mkString("\n\n\n")

  lazy val awards = facultyData.flatMap(f => f.awards.awardOpt(f.name))

  lazy val fellows = facultyData.flatMap(f => f.awards.fellowOpt(f.name))

  lazy val editors = facultyData.flatMap(f => f.awards.edOpt(f.name))

  lazy val draftSections =
    s"""
$summerTeX

$grants

\\subsection{Awards}

\\begin{enumerate}
${awards.mkString("\n")}
\\end{enumerate}

\\subsection{Fellowships of Academies}

\\begin{enumerate}
${fellows.mkString("\n")}
\\end{enumerate}

\\subsection{Editorial boards}
\\begin{enumerate}
${editors.mkString("\n")}
\\end{enumerate}
"""

  lazy val papers = facultyData
    .flatMap(f => f.papers)
    .filter(
      p => Set("Published", "Accepted for publication").contains(p.status)
    )
    .map(_.tex)

  lazy val preprints = facultyData
    .flatMap(f => f.papers)
    .filter(
      p => Set("Preprint", "Submitted").contains(p.status)
    )
    .map(_.tex)

  lazy val confPapers = facultyData.flatMap(f => f.confs.map(_.tex))

  lazy val books = facultyData.flatMap(f => f.books.map(_.tex))

  lazy val draftPubs =
    s"""
\\subsection{Papers in Journals}

\\begin{enumerate}
${papers.mkString("\n")}
\\end{enumerate}

\\subsection{Papers in Conference proceedings}

\\begin{enumerate}
${confPapers.mkString("\n")}
\\end{enumerate}

\\subsection{Books and book chapters}

\\begin{enumerate}
${books.mkString("\n")}
\\end{enumerate}

\\subsection{Preprints}

\\begin{enumerate}
${preprints.mkString("\n")}
\\end{enumerate}

% from web page

\\subsection{Publications (all kinds) from web page}

\\begin{enumerate}
${Publications.pubItems.mkString("\n")}
\\end{enumerate}
"""

  def writeReport() = os.write.over(os.pwd / "data" / "reports.tex", reports)

  def writeSections() =
    os.write.over(os.pwd / "data" / "draft-sections.tex", draftSections)

  def writePublications() =
    os.write.over(os.pwd / "data" / "draft-publications.tex", draftPubs)

  def writeAll() = {
    writeReport()
    writePublications()
    writeSections()
  }
}

case class FacultyData(
    name: String,
    researchHighlights: String,
    papers: Vector[Paper],
    confs: Vector[ConfPaper],
    books: Vector[Book],
    bookChapters: Vector[BookChapter],
    summer: Vector[SummerStudent],
    grants: Vector[Grant],
    awards: Award,
    otherOld: Vector[String],
    otherActivities: Vector[String]
) {
  lazy val grantTeX =
    grants.map(g => g.tex(name))
}

object FacultyData {
  def get(data: Vector[String]) =
    FacultyData(
      data(0),
      data(1),
      Paper.getAll(data),
      ConfPaper.getAll(data),
      Book.getAll(data),
      BookChapter.getAll(data),
      SummerStudent.getAll(data),
      Grant.getAll(data),
      Award.get(data),
      data.drop(activiesInit).take(activitiesSize),
      data.drop(activiesInit + activitiesSize)
    )
}

case class Paper(
    author: String,
    title: String,
    status: String,
    journal: String,
    volume: String,
    year: String,
    pages: String,
    doi: String,
    url: String
) {
  val tail = status match {
    case "Preprint"                 => "preprint."
    case "Submitted"                => "submitted for publication."
    case "Accepted for publication" => s"to appear in $journal."
    case "Published"                => s"{\\em $journal} {\\bf $volume} ($year), $pages."
    case _                          => ""
  }

  val tex = s"\\item $author, $title, $tail"
}

object Paper {
  def get(data: Vector[String], index: Int) = {
    val start = paperInit + (index * 10)
    Paper(
      data(start),
      data(start + 1),
      data(start + 2),
      data(start + 3),
      data(start + 4),
      data(start + 5),
      data(start + 6),
      data(start + 7),
      data(start + 8)
    )
  }

  def getAll(data: Vector[String]) =
    (0 until numPapers)
      .map(index => get(data, index))
      .toVector
      .takeWhile(_.author.nonEmpty)
}

case class ConfPaper(
    author: String,
    title: String,
    volumeTitle: String,
    volumeEditors: String,
    conf: String,
    publisher: String,
    year: String,
    pages: String
) {
  val tex = s"\\item $author, $title {\\em $conf} ($year)."
}

object ConfPaper {
  def get(data: Vector[String], index: Int) = {
    val start = confInit + (index * 5)
    ConfPaper(
      data(start),
      data(start + 1),
      data(start + 2),
      data(start + 3),
      data(start + 4),
      data(start + 5),
      data(start + 6),
      data(start + 7)
    )
  }

  def getAll(data: Vector[String]) =
    (0 until numConfs)
      .map(index => get(data, index))
      .toVector
      .takeWhile(_.author.nonEmpty)
}

case class Book(
    author: String,
    title: String,
    isEditor: Boolean,
    series: String,
    volume: String,
    publisher: String,
    year: String
) {
  val tex =
    s"\\item $author, $title in {\\em $publisher}{\bf $volume} ($year)."
}

object Book {
  def get(data: Vector[String], index: Int) = {
    val start = bookInit + (index * 8)
    Book(
      data(start),
      data(start + 1),
      data(start + 2).trim == "Editor(s)",
      data(start + 3),
      data(start + 4),
      data(start + 5),
      data(start + 6)
    )
  }

  def getAll(data: Vector[String]) =
    (0 until numBooks)
      .map(index => get(data, index))
      .toVector
      .takeWhile(_.author.nonEmpty)
}

case class BookChapter(
    author: String,
    title: String,
    bookAuthor: String,
    isEditor: Boolean,
    bookTitle: String,
    series: String,
    volume: String,
    publisher: String,
    year: String,
    pages: String
)

object BookChapter {
  def get(data: Vector[String], index: Int) = {
    val start = bookChapterInit + (index * 11)
    BookChapter(
      data(start),
      data(start + 1),
      data(start + 2),
      data(start + 3).trim == "Editor(s)",
      data(start + 4),
      data(start + 5),
      data(start + 6),
      data(start + 7),
      data(start + 8),
      data(start + 9)
    )
  }

  def getAll(data: Vector[String]) =
    (0 until numBookChapters)
      .map(index => get(data, index))
      .toVector
      .takeWhile(_.author.nonEmpty)
}


case class SummerStudent(
    name: String,
    program: String,
    period: String
) {
  val time = if (period.nonEmpty) s"during $period" else "in summer of 2018"
  def text(faculty: String) =
    s"$name did his/her ${program} summer project under the guidance of $faculty $time"
}

object SummerStudent {
  def get(data: Vector[String], index: Int) = {
    val start = summerInit + (index * 4)
    SummerStudent(
      data(start),
      data(start + 1),
      data(start + 2)
    )
  }

  def getAll(data: Vector[String]) =
    (0 until numSummer)
      .map(index => get(data, index))
      .toVector
      .takeWhile(_.name.nonEmpty)
}

case class Grant(
    role: String,
    agency: String,
    title: String,
    period: String,
    amount: String
) {
  def tex(name: String) =
    s"""
\\item {\\bf $name\\,:} $role in a $agency project
\\begin{description}
  \\item[Project Title\\,:] $title
  \\item[Duration\\,:] $period
  \\item[Grant\\,:] $amount
\\end{description}
"""
}

object Grant {
  def get(data: Vector[String], index: Int) = {
    val start = grantInit + (index * 6)
    Grant(
      data(start),
      data(start + 1),
      data(start + 2),
      data(start + 3),
      data(start + 4)
    )
  }

  def getAll(data: Vector[String]) =
    (0 until numGrants)
      .map(index => get(data, index))
      .toVector
      .takeWhile(_.role.nonEmpty)
}

case class Award(
    awards: String,
    fellow: String,
    ed: String
) {
  def awardOpt(name: String) =
    if (awards.nonEmpty) Some(s"\\item $name was awarded $awards") else None

  def fellowOpt(name: String) =
    if (fellow.nonEmpty) Some(s"\\item $name was elected a $fellow") else None

  def edOpt(name: String) =
    if (ed.nonEmpty) Some(s"\\item $name, $ed") else None

}

object Award {
  def get(data: Vector[String]) = {
    val start = awardsPos
    Award(
      data(start),
      data(start + 1),
      data(start + 2)
    )
  }

}
