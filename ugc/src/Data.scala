package ugc
import Data._

object Data{
    val paperInit = 2
    val numPapers = 7
    val confInit = paperInit + (numPapers * 8)
    val numConfs = 5
    val bookInit = confInit + (numConfs * 5)
    val numBooks = 4
    val summerInit = bookInit + (numBooks * 8)
    val numSummer = 6
    val grantInit = summerInit + (numSummer * 4)
    val numGrants = 4
    val awardsPos = grantInit + (numGrants * 6)
    val fullSize = awardsPos + 3
    def pad(v: Vector[String]) = v ++ Vector.fill(fullSize - v.size)("")

    lazy val data = os.read.lines(os.resource / "ugc2019.tsv").toVector.tail.map(_.split("\t").toVector.tail).map(pad)

    lazy val papers = data.map(l => Paper.getAll(l))

    lazy val summerStudents = data.map(l => SummerStudent.getAll(l))

    lazy val facultyData = data.map(l => FacultyData.get(l)).sortBy(_.name)

    lazy val reports = facultyData.map(d =>
    s"\\subsection{${d.name}}\n\n${d.research}").mkString("\n\n\n")

    def writeReport() = os.write.over(os.pwd / "data" / "reports.tex", reports)
}

case class FacultyData(
    name: String,
    research: String,
    papers: Vector[Paper],
    confs: Vector[ConfPaper],
    books: Vector[Book],
    summer: Vector[SummerStudent],
    grants: Vector[Grant],
    awards: Award
)

object FacultyData{
    def get(data: Vector[String]) = 
        FacultyData(
            data(0),
            data(1),
            Paper.getAll(data),
            ConfPaper.getAll(data),
            Book.getAll(data),
            SummerStudent.getAll(data),
            Grant.getAll(data),
            Award.get(data)
        )
}

case class Paper(
    author: String,
    title: String,
    status: String,
    journal: String,
    volume: String,
    year: String,
    pages: String
)

object Paper{
    def get(data: Vector[String], index: Int) = {
        val start = paperInit + (index * 8)
        Paper(
            data(start),
            data(start + 1),
            data(start + 2),
            data(start + 3),
            data(start + 4),
            data(start + 5),
            data(start + 6),
        )
    }

    def getAll(data: Vector[String]) = 
        (0 until numPapers).map(index => get(data, index)).toVector.takeWhile(_.author.nonEmpty)
}

case class ConfPaper(
    author: String,
    title: String,
    conf : String,
    year: String,
)

object ConfPaper{
    def get(data: Vector[String], index: Int) = {
        val start = confInit + (index * 5)
        ConfPaper(
            data(start),
            data(start + 1),
            data(start + 2),
            data(start + 3)
        )
    }

    def getAll(data: Vector[String]) = 
        (0 until numConfs).map(index => get(data, index)).toVector.takeWhile(_.author.nonEmpty)
}

case class Book(
    author: String,
    title: String,
    role: String,
    publisher: String,
    volume: String,
    year: String,
    pages: String
)

object Book{
    def get(data: Vector[String], index: Int) = {
        val start = bookInit + (index * 8)
        Book(
            data(start),
            data(start + 1),
            data(start + 2),
            data(start + 3),
            data(start + 4),
            data(start + 5),
            data(start + 6),
        )
    }

    def getAll(data: Vector[String]) = 
        (0 until numBooks).map(index => get(data, index)).toVector.takeWhile(_.author.nonEmpty)
}


case class SummerStudent(
    name: String,
    program: String,
    period: String
)

object SummerStudent{
    def get(data: Vector[String], index: Int) = {
        val start = summerInit + (index * 4)
        SummerStudent(
            data(start),
            data(start + 1),
            data(start + 2)
        )
    }

    def getAll(data: Vector[String]) = 
        (0 until numSummer).map(index => get(data, index)).toVector.takeWhile(_.name.nonEmpty)
}


case class Grant(
    role: String,
    agency: String,
    title: String,
    period: String,
    amount: String
)

object Grant{
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
        (0 until numGrants).map(index => get(data, index)).toVector.takeWhile(_.role.nonEmpty)
}

case class Award(
    awards: String,
    fellow: String,
    ed: String
)

object Award{
    def get(data: Vector[String]) = {
        val start = awardsPos
        Award(
            data(start),
            data(start + 1),
            data(start + 2)
        )
    }

}
