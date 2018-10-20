package courses


object Server extends cask.MainRoutes{

  @cask.get("/preference.html")
  def hello(): String = Home.indexHTML

  @cask.staticResources("/public")
  def staticResourceRoutes() = "."

  @cask.get("/course-list"  )
  def courseList() : String =
    ujson.write(CourseData.json)

  initialize()

}


object Home{
  val indexHTML: String =
    s"""
       |<!DOCTYPE html>
       |<html>
       |  <head>
       |    <meta charset="utf-8">
       |    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
       |    <title>Course Scheduling</title>
       |
       |     <link rel="stylesheet" href="public/css/bootstrap.min.css">
       |
       |      <!--Let browser know website is optimized for mobile-->
       |      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
       |  </head>
       |  <body>
       |
       |    <div class="container">
       |    <p></p>
       |      <h1 class="text-center"> Course Timing Preferences </h1>
       |      <div id="chooser"></div>
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
