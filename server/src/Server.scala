package courses

import ujson.Js
import ujson.Js.Value

import scala.util.Try
import scala.collection.mutable.{Map => mMap}
import ammonite.ops._

import scalatags.Text.all._

import scala.xml.Elem

object Server extends cask.MainRoutes {
  var forbiddenClashes: Vector[(Course, Course)] = CourseData.corePairs

  def userForbidden: Vector[(Course, Course)] =
    forbiddenClashes.filter(!CourseData.corePairs.contains(_))

  var preferences: mMap[Course, Vector[(Int, Timing)]] = mMap()

  def prefJs: Value =
    Js.Arr(
      preferences.toVector.map {
        case (c, t) =>
          Js.Obj(
            "course" -> c.json,
            "timings" -> Timing.timingsToJson(t)
          )
      }: _*
    )

 def prefView : String = {
   lazy val items =
     preferences.toVector.sortBy(_._1.code).map {
       case (c, t) =>
         val rows = t.sortBy(_._1).map{case (n, tim) => tr(td(n), td(tim.show))}
         li(ul(`class` := "list-unstyled")(
           li(strong("Code: "), c.code),
           li(strong("Title: "), c.name),
           li(strong("Instructor: "), c.instructor),
           li(table(`class` := "table table-striped")(
             thead(td(strong("Rank")), td(strong("Timing"))),
             tbody(rows : _*)))
         ))
     }
     ol(items :_ *).render
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

  override def port: Int = Try(sys.env("COURSES_PORT").toInt).getOrElse(8080)
  override def host: String =
    Try(sys.env("IP")).getOrElse("localhost")

  def forbidJs =
    Course.pairsToJson(forbiddenClashes)
  @cask.get("/preferences.html")
  def hello(): String = Home.indexHTML

  @cask.staticResources("/public")
  def staticResourceRoutes() = "."

  @cask.get("/course-list")
  def courseList(): String =
    ujson.write(CourseData.json)


 @cask.get("/data.html")
 def dataView() : String =
   Home.page(
     s"""
        |<h2> Preferences data </h2>
        |   $prefView
      """.stripMargin)

  val dat: Path = pwd / "data"

  def loadPrefs(): Unit = {
    val jsV = ujson.read(read(dat / "preferences.json")).arr.toVector
    jsV.foreach { js =>
      val course: Course = Course.fromJson(js.obj("course"))
      val timings: Vector[(Int, Timing)] =
        Timing.timingsFromJson(js.obj("timings"))
      preferences += course -> timings
    }
  }

  def loadClashes(): Unit = {
    val js = ujson.read(read(dat / "forbidden-clashes.json"))
    val cl = Course.pairsFromJson(js)
    forbiddenClashes ++= cl
  }

  loadPrefs()

  loadClashes()

  // pprint.log(preferences)

  @cask.post("/save-preferences")
  def prefSave(request: cask.Request) = {
    val d = new String(request.readAllBytes())
    val js = ujson.read(d)
    // pprint.log(js)
    val pairs: Vector[(Course, Course)] =
      Course.pairsFromJson(js.obj("forbidden"))
    forbid(pairs)
    val course = Course.fromJson(js.obj("course"))
    val timings: Vector[(Int, Timing)] =
      Timing.timingsFromJson(js.obj("timings"))

    preferences += course -> timings

    // pprint.log(preferences)

    write.over(
      dat / "preferences.json",
      ujson.write(prefJs, 2)
    )

    val prefVec = prefJs +: ujson
      .read(read(dat / "preferences-arr.json"))
      .arr
      .toVector

    write.over(dat / "preferences-arr.json",
               ujson.write(Js.Arr(prefVec: _*), 2))

    write.over(
      dat / "forbidden-clashes.json",
      ujson.write(Course.pairsToJson(userForbidden), 2)
    )

    val forbidVec: Vector[Value] = Course.pairsToJson(userForbidden) +: ujson
      .read(read(dat / "forbidden-clashes-arr.json"))
      .arr
      .toVector

    write.over(
      dat / "forbidden-clashes-arr.json",
      ujson.write(Js.Arr(forbidVec: _*), 2)
    )

    ujson.write(js)
  }

  @cask.get("/forbidden-clashes")
  def forbidden(): String = {

    ujson.write(Course.pairsToJson(forbiddenClashes))
  }

  initialize()

}

object Home {
  val instructions: Elem =
    <div>
      <h2>Guidelines</h2>
      <ol>
        <li>Give at least 3 preferences.</li>
        <li>You are welcome to give more than 3 preferences.
          You can also rank your preferences (as positive integers) with,
          for example several 1st preferences (so that, for k=1, 2, 3, there are at least k courses with rank at most k).</li>
        <li>All are in the <em>new</em> standard slots: one hour lectures beginning on the hour on MWF or 90 minute ones on Tue-Thu.</li>
        <li>At least one preference is for 3 (hour long) lectures (on MWF, starting on the hour).</li>
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
       |   <!--Import Google Icon Font-->	       |
       |      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
       |
       |             <!--Import materialize.css-->
       |             <link type="text/css" rel="stylesheet" href="/public/css/materialize.min.css"  media="screen,projection"/>
       |             <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       |       |     <link rel="stylesheet" href="public/css/extras.css">
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
       |  <script type="text/javascript" src="/public/js/materialize.min.js"></script>
       |
       |    <script type="text/javascript" src="/public/out.js">
       |
       |    </script>
       |    <script> ChooserJS.load() </script>
       |  </body>
       |</html>
     """.stripMargin

}
