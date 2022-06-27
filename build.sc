import mill._, scalalib._, scalajslib._
import os._

object courses extends Module{
  object jvm extends ScalaModule{
    def scalaVersion = "2.13.8"
    def millSourcePath = super.millSourcePath / up

    def ivyDeps = Agg(ivy"com.lihaoyi::upickle::1.6.0")
  }

  object js extends ScalaJSModule {
    def scalaVersion = "2.13.8"
    def scalaJSVersion = "1.10.1"
    def millSourcePath = super.millSourcePath / up

    def platformSegment = "js"

    def ivyDeps = Agg(ivy"com.lihaoyi::upickle::1.6.0")
  }
}

object ugc extends ScalaModule{
  def scalaVersion = "2.13.8"

  def moduleDeps = Seq(courses.jvm)


  def ivyDeps = Agg(
    ivy"com.lihaoyi::os-lib:0.8.0",
    ivy"org.jbibtex:jbibtex:1.0.18",
    ivy"net.jcazevedo::moultingyaml:0.4.2"
  )
}

object forms extends ScalaModule{
  def scalaVersion = "2.13.8"

  def moduleDeps = Seq(courses.jvm)


  def ivyDeps = Agg(
    ivy"com.lihaoyi::os-lib:0.8.0"
  )
}

object server extends ScalaModule{
  def scalaVersion = "2.13.8"

  def moduleDeps = Seq(courses.jvm)


  def ivyDeps = Agg(
    ivy"com.lihaoyi::cask:0.7.8",
    ivy"com.lihaoyi::os-lib:0.7.2",
    ivy"net.jcazevedo::moultingyaml:0.4.2",
    ivy"com.lihaoyi::upickle::1.6.0",
    ivy"com.lihaoyi::scalatags::0.11.1",
    ivy"com.lihaoyi::pprint::0.6.0",
    ivy"org.scala-lang.modules::scala-xml:1.3.0"
  )

  def resources = T.sources {
    def base : Seq[Path] = super.resources().map(_.path)
    def jsout = client.fastOpt().path / up
    (base ++ Seq(jsout)).map(PathRef(_))
  }

  def mainClass = Some("courses.Server")
}

object client extends ScalaJSModule {
  def scalaVersion = "2.13.8"
  def scalaJSVersion = "1.10.1"

  def platformSegment = "js"

  import coursier.maven.MavenRepository

  def repositories = super.repositories ++ Seq(
    MavenRepository("https://oss.sonatype.org/content/repositories/releases")
  )

  def ivyDeps = Agg(
    ivy"org.scala-js::scalajs-dom::2.2.0",
    ivy"com.lihaoyi::scalatags::0.11.1",
    ivy"com.lihaoyi::upickle::1.6.0"
  )

  def moduleDeps = Seq(courses.js)

}

