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
  val postDocSize = grantInit + 9 + 1 // joining-leaving and awards
  def pad(v: Vector[String], full: Int = fullSize) =
    v ++ Vector.fill(full - v.size)("")
  def preComma(s: String) = if (s.trim() == "") "" else s", $s"

  lazy val data = os.read
    .lines(os.resource / "ugc2020.tsv")
    .toVector
    .tail
    .map(_.split("\t").toVector.tail.map(_.trim))
    .map(pad(_))

  lazy val visitorData = os.read
    .lines(os.resource / "ugc2020.tsv")
    .toVector
    .tail
    .map(_.split("\t").toVector.tail.map(_.trim))
    .map(pad(_, 5))

  lazy val summerStudents = data.flatMap(
    l =>
      SummerStudent.getAll(l).map { stu =>
        stu.text(l(0))
      }
  )

  lazy val postDocRaw = os.read
    .lines(os.resource / "ugc2020-postdocs.tsv")
    .toVector
    .tail
    .map(_.split("\t").toVector.tail.map(_.trim))
    .map(pad(_, postDocSize))

  lazy val postDocTriple
      : Vector[(Vector[String], Vector[String], Vector[String])] =
    postDocRaw.map(
      v =>
        (
          v.take(2) ++ v.drop(11).dropRight(2),
          v.drop(2).take(9),
          v.takeRight(2)
        )
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

  lazy val postDocData: Vector[PostDocData] =
    postDocTriple.map {
      case (data, fel, aws) => PostDocData.get(data, fel, aws)
    }

  lazy val grantsItems = facultyData.flatMap(f => f.grantTeX)

  lazy val grants =
    s"""
\\section{Resource Generation}

\\begin{enumerate}
${grantsItems.mkString("\n").replace("&", "\\&")}
\\end{enumerate}
"""

  lazy val reports = facultyData
    .map(d => s"\\subsection{${d.name}}\n\n${d.researchHighlights}")
    .mkString("\n\n\n") ++ postDocData
    .map(d => s"\\subsection{${d.name}}\n\n${d.researchHighlights}")
    .mkString("\n\n\n")

  lazy val awards = facultyData.flatMap(f => f.awards.awardOpt(f.name)) ++ (postDocData.flatMap(f => f.awardOpt(f.name)))

  lazy val fellows = facultyData.flatMap(f => f.awards.fellowOpt(f.name)) ++ postDocData
    .flatMap(f => f.fellowOpt(f.name))

  lazy val editors = facultyData.flatMap(f => f.awards.edOpt(f.name))

  lazy val otherOld = facultyData.flatMap(
    f => f.otherOld.map(act => s"\\item ${f.name} was $act")
  )

  lazy val other = facultyData.flatMap(
    f => f.otherActivities.map(act => s"\\item ${f.name} was $act")
  )

  def enumString(v: Vector[String]) =
    if (v.isEmpty) ""
    else s"""|\\begin{enumerate}
             |${v.mkString("\n")}
             |\\end{enumerate}
             |""".stripMargin

  lazy val draftSections =
    s"""
$summerTeX

$grants

\\subsection{Awards}

${enumString(awards)}

\\subsection{Fellowships of Academies}

${enumString(fellows)}

\\subsection{Editorial boards}
${enumString(editors)}

\\subsection{Other Activities: 2018-19}
${enumString(otherOld)}

\\subsection{Other Activities: 2019-20}
${enumString(other)}
"""

  lazy val papers = facultyData
    .flatMap(f => f.papers)
    .filter(
      p => Set("Published", "Accepted for publication").contains(p.status)
    )
    .map(_.tex) ++ (postDocData
    .flatMap(f => f.papers)
    .filter(
      p => Set("Published", "Accepted for publication").contains(p.status)
    )
    .map(_.tex))

  lazy val preprints = facultyData
    .flatMap(f => f.papers)
    .filter(
      p => Set("Preprint", "Submitted").contains(p.status)
    )
    .map(_.tex) ++ (postDocData
    .flatMap(f => f.papers)
    .filter(
      p => Set("Preprint", "Submitted").contains(p.status)
    )
    .map(_.tex))

  lazy val confPapers = facultyData.flatMap(f => f.confs.map(_.tex)) ++ postDocData
    .flatMap(f => f.confs.map(_.tex))

  lazy val books = facultyData.flatMap(f => f.books.map(_.tex)) ++ postDocData
    .flatMap(f => f.books.map(_.tex))

  lazy val bookChapters = facultyData.flatMap(f => f.bookChapters.map(_.tex)) ++ postDocData
    .flatMap(f => f.bookChapters.map(_.tex))

  lazy val visitors = visitorData.map(Visitor.get(_).tex)

  lazy val draftPubs =
    s"""
\\subsection{Papers in Journals}

\\begin{enumerate}
${papers.mkString("\n")}
\\end{enumerate}

\\subsection{Papers in Conference proceedings}

${enumString(confPapers)}

\\subsection{Books}

${enumString(books)}

\\subsection{Book Chapters}

${enumString(bookChapters)}

\\subsection{Preprints}

\\begin{enumerate}
${preprints.mkString("\n")}
\\end{enumerate}

% from web page

\\subsection{Publications (all kinds) from web page}

\\begin{enumerate}
${Publications.pubItems.mkString("\n")}
\\end{enumerate}

\\subsection{List of Visitors to the Department}

${enumString(visitors)}
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
      data.drop(activiesInit).take(activitiesSize).takeWhile(_.trim() != ""),
      data.drop(activiesInit + activitiesSize).takeWhile(_.trim() != "")
    )
}

case class Fellowship(
    fellowship: String,
    start: String,
    resign: String
)

object Fellowship {
  def getAll(v: Vector[String]) =
    v.grouped(3)
      .map { w =>
        Fellowship(w(0), w(1), w(2))
      }
      .toVector
}

case class Visitor(
  name: String,
  affiliation: String,
  from: String,
  till: String
){
  val tex = s"\\item Dr.$name, $affiliation, $from--$till"
}

object Visitor{
  def get(v: Vector[String]) = Visitor(v(0), v(1), v(3), v(4))
}

case class PostDocData(
    name: String,
    researchHighlights: String,
    papers: Vector[Paper],
    confs: Vector[ConfPaper],
    books: Vector[Book],
    bookChapters: Vector[BookChapter],
    fellowships: Vector[Fellowship],
    awards: String,
    assoc: String
){
  def awardOpt(name: String) =
    if (awards.trim != "") Some(s"\\item $name was awarded $awards") else None

  def fellowOpt(name: String) =
    if (assoc.trim() != "") Some(s"\\item $name was elected a $assoc") else None
}

object PostDocData {
  def get(
      data: Vector[String],
      fellowships: Vector[String],
      aws: Vector[String]
  ) =
    PostDocData(
      data(0),
      data(1),
      Paper.getAll(data),
      ConfPaper.getAll(data),
      Book.getAll(data),
      BookChapter.getAll(data),
      Fellowship.getAll(fellowships),
      aws(0),
      aws(1)
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
  val doiText =
    if (doi.trim() == "") "" else s", DOI ${doi.replace("_", "\\_")}"
  val urlText = if (url.trim() == "") "" else s", \\url{$url}"
  val tail = status match {
    case "Preprint"                 => "preprint"
    case "Submitted"                => "submitted for publication"
    case "Accepted for publication" => s"to appear in \\emph{$journal}"
    case "Published"                => s"\\emph{$journal} {\\bf $volume} ($year)${preComma(pages)}"
    case _                          => ""
  }

  val tex = s"\\item $author: $title, $tail$doiText$urlText."
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
  val tex =
    s"\\item $author: $title in {\\em $volumeTitle} $volumeEditors (ed.) ${preComma(
      conf
    )} ${preComma(publisher)} ($year)${preComma(pages)}."
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
  val authorString = if (isEditor) s"$author (ed.)" else author
  val tex =
    s"\\item $authorString: $title${preComma(series)} $volume ${preComma(publisher)} ($year)."
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
){
  val bookAuthorString = if (isEditor) s"$bookAuthor (ed.)" else bookAuthor
  val tex =
    s"\\item $author: $title in {\\em $bookTitle} $bookAuthorString${preComma(
      series
    )}${preComma(publisher)} ($year)${preComma(pages)}."
}

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
