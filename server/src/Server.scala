package courses


object Server extends cask.MainRoutes{

  @cask.get("/preference.html")
  def hello(): String = Home.indexHTML

  @cask.staticResources("/public")
  def staticResourceRoutes() = "."


  initialize()

}


object Home{
  val indexHTML: String =
    s"""
       |<!DOCTYPE html>
       |<html>
       |  <head>
       |    <meta charset="utf-8">
       |    <title>Course Scheduling</title>
       |    <!--Import Google Icon Font-->
       |      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
       |      <!--Import materialize.css-->
       |      <link type="text/css" rel="stylesheet" href="/public/css/materialize.min.css"  media="screen,projection"/>
       |
       |      <!--Let browser know website is optimized for mobile-->
       |      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
       |  </head>
       |  <body>
       |
       |    <div class="container">
       |      <h2> Course Timing Preferences </h2>
       |      <div id="chooser"></div>
       |    </div>
       |
       |
       |
       |
       |    <script type="text/javascript" src="/public/js/materialize.min.js"></script>
       |    <script type="text/javascript" src="/public/out.js">
       |
       |    </script>
       |    <script> ChooserJS.load() </script>
       |  </body>
       |</html>
     """.stripMargin


}