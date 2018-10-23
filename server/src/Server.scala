package courses

import ujson.Js
import ujson.Js.Value

import scala.util.Try
import scala.collection.mutable.{Map => mMap}

import ammonite.ops._


object Server extends cask.MainRoutes{
  var forbiddenClashes: Vector[(Course, Course)] = CourseData.corePairs

  def userForbidden: Vector[(Course, Course)] = forbiddenClashes.filter(!CourseData.corePairs.contains(_))

  var preferences : mMap[Course, Vector[(Int, Timing)]] = mMap()

  def prefJs: Value =
    Js.Arr(
      preferences.toVector.map{
        case (c, t) =>
          Js.Obj(
            "course" -> c.json,
            "timings" -> Timing.timingsToJson(t)
          )
      }  : _*
    )

  def prefSet: Set[Preference] =
    (for {
      (course, vec) <- preferences
    } yield Preference(course, vec.toSet)).toSet

  def avoid(c1: Course, c2: Course): Boolean = forbiddenClashes.contains(c1 -> c2)

  def forbid(s: Iterable[(Course, Course)]): Unit = {
    forbiddenClashes = (forbiddenClashes ++ s).distinct
    pprint.log(forbiddenClashes)
  }

  override def port: Int = Try(sys.env("COURSES_PORT").toInt).getOrElse(8080)
  override def host: String = Try(sys.env("COURSES_HOST")).getOrElse("localhost")

  def forbidJs =
    Course.pairsToJson(forbiddenClashes)


  @cask.get("/preferences.html")
  def hello(): String = Home.indexHTML

  @cask.staticResources("/public")
  def staticResourceRoutes() = "."

  @cask.get("/course-list"  )
  def courseList() : String =
    ujson.write(CourseData.json)

  val dat = pwd / "data"

  def loadPrefs() : Unit =
  {
    val jsV = ujson.read(read(dat / "preferences.json")).arr.toVector
    jsV.foreach{
      js =>
        val course: Course = Course.fromJson(js.obj("course"))
        val timings: Vector[(Int, Timing)] = Timing.timingsFromJson(js.obj("timings"))
        preferences += course -> timings
    }
  }

  def loadClashes() : Unit = {
    val js = ujson.read(read(dat / "forbidden-clashes.json"))
    val cl = Course.pairsFromJson(js)
    forbiddenClashes ++= cl
  }

  loadPrefs()

  loadClashes() 

  pprint.log(preferences)

  @cask.post("/save-preferences")
  def prefSave(request: cask.Request)  =        {
    val d = new String(request.readAllBytes())
    val js = ujson.read(d)
    pprint.log(js)
    val pairs: Vector[(Course, Course)] =
      Course.pairsFromJson(js.obj("forbidden"))
    forbid(pairs)
    val course = Course.fromJson(js.obj("course"))
    val timings: Vector[(Int, Timing)] = Timing.timingsFromJson(js.obj("timings"))

    preferences += course -> timings

    pprint.log(preferences)

    write.over (
      dat / "preferences.json",
      ujson.write(prefJs, 2)
    )

    write.over(
      dat / "forbidden-clashes.json",
      ujson.write(Course.pairsToJson(userForbidden), 2)
    )

    ujson.write(js)
  }

  @cask.get("/forbidden-clashes")
  def forbidden() : String  = {

    ujson.write(Course.pairsToJson(forbiddenClashes))
  }

  initialize()

}


object Home{
  val indexHTML: String =
    page(
      """
        |<h1 class="text-center"> Course Timing Preferences </h1>
        |      <div id="chooser"></div>
      """.stripMargin
    )

    def page(content: String) =
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
       |     <link rel="stylesheet" href="public/css/bootstrap.min.css">
       |     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       |     <link rel="stylesheet" href="public/css/extras.css">
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
       |<script src="public/js/bootstrap.min.js"></script>
       |
       |
       |    <script type="text/javascript" src="/public/out.js">
       |
       |    </script>
       |    <script> ChooserJS.load() </script>
       |  </body>
       |</html>
     """.stripMargin


}
