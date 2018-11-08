import mill._, scalalib._, scalajslib._, define.Task
import ammonite.ops._



object courses extends Module{
  object jvm extends ScalaModule{
    def scalaVersion = "2.12.6"
    def millSourcePath = super.millSourcePath / up

    def ivyDeps = Agg(ivy"com.lihaoyi::upickle::0.6.6")
  }

  object js extends ScalaJSModule {
    def scalaVersion = "2.12.6"
    def scalaJSVersion = "0.6.25"
    def millSourcePath = super.millSourcePath / up

    def platformSegment = "js"

    def ivyDeps = Agg(ivy"com.lihaoyi::upickle::0.6.6")
  }
}

object server extends ScalaModule{
  def scalaVersion = "2.12.6"

  def moduleDeps = Seq(courses.jvm)


  def ivyDeps = Agg(
    ivy"com.lihaoyi::cask:0.1.9",
    ivy"com.lihaoyi:::ammonite:1.4.2",
    ivy"net.jcazevedo::moultingyaml:0.4.0",
    ivy"com.lihaoyi::upickle::0.6.6",
    ivy"com.lihaoyi::scalatags::0.6.7",
    ivy"com.lihaoyi::pprint::0.5.3"
  )

  def resources = T.sources {
    def base : Seq[Path] = super.resources().map(_.path)
    def jsout = client.fastOpt().path / up
    (base ++ Seq(jsout)).map(PathRef(_))
  }

  def mainClass = Some("courses.Server")
}

object client extends ScalaJSModule {
  def scalaVersion = "2.12.6"
  def scalaJSVersion = "0.6.25"

  def platformSegment = "js"

  import coursier.maven.MavenRepository

  def repositories = super.repositories ++ Seq(
    MavenRepository("https://oss.sonatype.org/content/repositories/releases")
  )

  def ivyDeps = Agg(
    ivy"org.scala-js::scalajs-dom::0.9.4",
    ivy"com.lihaoyi::scalatags::0.6.7",
    ivy"com.lihaoyi::upickle::0.6.6"
  )

  def moduleDeps = Seq(courses.js)

}
