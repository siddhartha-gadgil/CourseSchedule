package courses

import scala.util.Try
import scala.collection.mutable.{Map => mMap}

import scalatags.Text.all._

import scala.xml.Elem

import CourseData.semName

object Server extends cask.MainRoutes {
  var forbiddenClashes
      : Vector[(Course, Course)] = CourseData.corePairs ++ CourseData.sameInstructor

  def userForbidden: Vector[(Course, Course)] =
    forbiddenClashes.filter(!CourseData.corePairs.contains(_))

  var preferences: mMap[Course, Vector[(Int, Timing)]] = mMap()

  def prefJs: ujson.Value =
    ujson.Arr(
      preferences.toVector.map {
        case (c, t) =>
          ujson.Obj(
            "course" -> c.json,
            "timings" -> Timing.timingsToJson(t)
          )
      }: _*
    )

  def prefView: String = {
    lazy val items =
      preferences.toVector.sortBy(_._1.code).map {
        case (c, t) =>
          val rows =
            t.sortBy(_._1).map { case (n, tim) => tr(td(n), td(tim.show)) }
          li(
            ul(`class` := "list-unstyled")(
              li(strong("Code: "), c.code),
              li(strong("Title: "), c.name),
              li(strong("Instructor: "), c.instructor),
              li(
                table(`class` := "table table-striped")(
                  thead(td(strong("Rank")), td(strong("Timing"))),
                  tbody(rows: _*)
                )
              )
            )
          )
      }
    ol(items: _*).render
  }

  def prefSet: Set[Preference] =
    (for {
      (course, vec) <- preferences
    } yield Preference(course, vec.toSet)).toSet

  def avoid(c1: Course, c2: Course): Boolean =
    forbiddenClashes.contains(c1 -> c2)

  def scheduler: Scheduler = Scheduler(prefSet, avoid)

  def forbid(s: Iterable[(Course, Course)]): Unit = {
    forbiddenClashes = (forbiddenClashes ++ s).distinct
    // pprint.log(forbiddenClashes)
  }

  override def port: Int = Try(sys.env("COURSE_PORT").toInt).getOrElse(8080)
  override def host: String =
    Try(sys.env("IP")).getOrElse("localhost")

  pprint.log(port)
  pprint.log(host)
  // println(sys.env.get("PORT"))

  def forbidJs: ujson.Arr =
    Course.pairsToJson(forbiddenClashes)
  @cask.get("/preferences.html")
  def hello() =
    cask.Response(
      Home.indexHTML,
      headers = Seq("Content-Type" -> "text/html")
    )

  @cask.get("/css/:file")
  def css(file: String) = {
    val path = os.resource / "css" / file
    cask.Response(
      os.read(path),
      headers = Seq("Content-Type" -> "text/css")
    )
  }

  @cask.get("/js/:file")
  def js(file: String) = {
    val path = os.resource  / file
    cask.Response(
      os.read(path),
      headers = Seq("Content-Type" -> "application/javascript")
    )
  }

  @cask.staticResources("/public")
  def staticResourceRoutes() = "."

  @cask.get("/course-list")
  def courseList(): String =
    ujson.write(CourseData.json)

  @cask.get("/core1-course-list")
  def courseListCore1(): String =
    ujson.write(CourseData.jsonCore1)

  @cask.get("/core2-course-list")
  def courseListCore2(): String =
    ujson.write(CourseData.jsonCore2)

  @cask.staticFiles("/data-files")
  def staticFileRoutes() = "data"

  @cask.get("/data.html")
  def dataView() =
    cask.Response(
      Home.page(s"""
        |<h2> Preferences data </h2>
        |   $prefView
      """.stripMargin),
      headers = Seq("Content-Type" -> "text/html")
    )

  val dat: os.Path = os.pwd / "data" / semName

  def loadPrefs(): Unit = {
    val jsV = ujson
      .read(Try(os.read(dat / "preferences.json")).getOrElse[String]("[]"))
      .arr
      .toVector
    jsV.foreach { js =>
      val course: Course = Course.fromJson(js.obj("course"))
      val timings: Vector[(Int, Timing)] =
        Timing.timingsFromJson(js.obj("timings"))
      preferences += course -> timings
    }
  }

  def loadClashes(): Unit = {
    val d: String = Try(os.read(dat / "forbidden-clashes.json")).getOrElse("[]")
    val js = ujson.read(
      d
    )
    val cl = Course.pairsFromJson(js)
    forbiddenClashes ++= cl
  }

  loadPrefs()

  loadClashes()

  // pprint.log(preferences)

  @cask.post("/save-preferences")
  def prefSave(request: cask.Request): String = {
    val d = new String(request.readAllBytes())
    val js = ujson.read(d)
//     pprint.log(js)
    val pairs: Vector[(Course, Course)] =
      Course.pairsFromJson(js.obj("forbidden"))
    forbid(pairs)
    val course = Course.fromJson(js.obj("course"))
    val timings: Vector[(Int, Timing)] =
      Timing.timingsFromJson(js.obj("timings"))

    preferences += course -> timings

//     pprint.log(preferences)

    os.write.over(
      dat / "preferences.json",
      ujson.write(prefJs, 2),
      createFolders = true
    )

    val prefVec = prefJs +: ujson
      .read(
        Try(os.read(dat / "preferences-arr.json")).getOrElse[String]("[]")
      )
      .arr
      .toVector

    os.write.over(
      dat / "preferences-arr.json",
      ujson.write(ujson.Arr(prefVec: _*), 2),
      createFolders = true
    )

    os.write.over(
      dat / "forbidden-clashes.json",
      ujson.write(Course.pairsToJson(userForbidden), 2),
      createFolders = true
    )

    val forbidVec
        : Vector[ujson.Value] = Course.pairsToJson(userForbidden) +: ujson
      .read(
        Try(os.read(dat / "forbidden-clashes-arr.json")).getOrElse[String]("[]")
      )
      .arr
      .toVector

    os.write.over(
      dat / "forbidden-clashes-arr.json",
      ujson.write(ujson.Arr(forbidVec: _*), 2),
      createFolders = true
    )

//    pprint.log(ujson.write(js))

    ujson.write(js)
  }

  @cask.get("/forbidden-clashes")
  def forbidden(): String = {

    ujson.write(Course.pairsToJson(forbiddenClashes))
  }

  initialize()

}

object SavedData {
  val dat: os.Path = os.pwd / "data" / semName
  

  lazy val prefs = {
    val jsV = ujson
      .read(Try(os.read(dat / "preferences.json")).getOrElse[String]("[]"))
      .arr
      .toVector
    jsV.map { js =>
      val course: Course = Course.fromJson(js.obj("course"))
      val timings: Vector[(Int, Timing)] =
        Timing.timingsFromJson(js.obj("timings"))
      (course -> timings)
    }
  }

  lazy val forbiddenClashes = {
    val d: String = Try(os.read(dat / "forbidden-clashes.json")).getOrElse("[]")
    val js = ujson.read(
      d
    )
    Course.pairsFromJson(js)
  }

  def avoid(c1: Course, c2: Course): Boolean =
    forbiddenClashes.contains(c1 -> c2) || forbiddenClashes.contains(c2 -> c1)

  lazy val prefSet: Set[Preference] =
    (for {
      (course, vec) <- prefs
    } yield Preference(course, vec.toSet)).toSet

  lazy val scheduler: Scheduler = Scheduler(prefSet, avoid)

}

object Home {
  val instructions: Elem =
    <div>
      <h2>Guidelines</h2>
      <ol>
        <li>Give at least 3 preferences (you will have to give more if you are teaching a core course).</li>
        <li>You are welcome to give more than 3 preferences.
          You can also rank your preferences (as positive integers) with,
          for example several 1st preferences (so that, for k=1, 2, 3, there are at least k courses with rank at most k).</li>
        <li>All are in the <em>new</em> standard slots: one hour lectures beginning on the hour on MWF or 90 minute ones on Tue-Thu.</li>
        <li>At least one preference with rank at most 3 should be for 3 (hour long) lectures (on MWF, starting on the hour).</li>
        <li>If you are teaching a core course you must give at least two preferences ranked 1 or 2 that are on MWF. </li>
      </ol>
      <p>I realize that most of us prefer two 90 minute lectures, but this has to be balanced with trying to minimize
      schedule clashes of courses students would like to take concurrently (and instances of  colleagues being
      pressured to hold lectures at strange times to accommodate students).</p>
      <p>Thanks in advance to those who give better than the minimum number of choices,
        and those who volunteer to teach thrice a week (i.e, give this as a first/second preference).    </p>
    </div>

  val indexHTML: String =
    page(
      s"""
        |<h1 class="text-center"> Course Timing Preferences </h1>
        |<p> Please note that those teaching <em>core courses</em> need to give
        | at least two choices ranked 2 or above on MWF. Those teaching electives need to give at least
        | one choice ranked 3 or above on MWF.
        |     <div id="message"></div>
        |      <div id="chooser"></div>
        |      $instructions
      """.stripMargin
    )

  def page(content: String): String =
    s"""
       |<!DOCTYPE html>
       |<html>
       |  <head>
       |    <meta charset="utf-8">
       |    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
       |    <title>Course Scheduling</title>
       |
       |    <link rel="icon" href="public/IIScLogo.jpg">
       |
       |     <link rel="stylesheet" href="css/bootstrap.min.css">
       |     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       |     <link rel="stylesheet" href="css/extras.css">
       |
       |      <!--Let browser know website is optimized for mobile-->
       |      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
       |  </head>
       |  <body>
       |
       |    <div class="container">
       |    <p></p>
       |      $content
       |
       |<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
       |<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
       |<script src="js/bootstrap.min.js"></script>
       |
       |
       |    <script type="text/javascript" src="js/out.js">
       |
       |    </script>
       |    <script> ChooserJS.load() </script>
       |  </body>
       |</html>
     """.stripMargin

}
