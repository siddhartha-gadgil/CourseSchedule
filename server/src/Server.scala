package courses

import ujson.Js

import scala.util.Try

import scala.collection.mutable.{Map => mMap}


object Server extends cask.MainRoutes{
  var forbiddenClashes: Vector[(Course, Course)] = CourseData.corePairs

  var preferences : mMap[Course, Vector[(Int, Timing)]] = mMap()

  def forbid(s: Iterable[(Course, Course)]) = {
    forbiddenClashes = (forbiddenClashes ++ s).distinct
    pprint.log(forbiddenClashes)
  }

  override def port = Try(sys.env("COURSES_PORT").toInt).getOrElse(8080)
  override def host = Try(sys.env("COURSES_HOST")).getOrElse("localhost")

  def forbidJs =    {
    val pairs: Seq[Js.Obj] =
      for {
        (i, j) <- forbiddenClashes
      }  yield Js.Obj(
        "first" -> i.json,
        "second" -> j.json
      )
    Js.Arr(pairs : _*)
  }

//  pprint.log(forbidJs)

//  pprint.log(forbiddenClashes)

  @cask.get("/preferences.html")
  def hello(): String = Home.indexHTML

  @cask.staticResources("/public")
  def staticResourceRoutes() = "."

  @cask.get("/course-list"  )
  def courseList() : String =
    ujson.write(CourseData.json)

  @cask.post("/save-preferences")
  def prefSave(request: cask.Request)  =        {
    val d = new String(request.readAllBytes())
    val js = ujson.read(d)
    pprint.log(js)
    val pairs: Vector[(Course, Course)] = js.obj("forbidden").arr.toVector.map { (js) =>
      (Course.fromJson(js.obj("first")), Course.fromJson(js.obj("second")))
    }
    forbid(pairs)
    val course = Course.fromJson(js.obj("course"))
    val timings: Vector[(Int, Timing)] = js.obj("timings").arr.toVector.map {
      js => js.obj("choice").num.toInt -> Timing.fromJson(js.obj("timing"))
    }

    preferences += course -> timings

    pprint.log(preferences)

    ujson.write(js)
  }

  @cask.get("/forbidden-clashes")
  def forbidden() : String  = {
    val pairs: Seq[Js.Obj] =
      for {
        (i, j) <- forbiddenClashes
      }  yield Js.Obj(
        "first" -> i.json,
        "second" -> j.json
      )
    ujson.write(Js.Arr(pairs : _*))
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
