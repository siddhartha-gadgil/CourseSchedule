package ugc
import os.remove.all

object Publications {
  import org.jbibtex._
  import scala.collection.JavaConverters._

  import java.io._
  val parser = new BibTeXParser()
  def reader = new java.io.FileReader("data/publications.bib")

  def db = parser.parse(reader)

  lazy val mp = db.getEntries.asScala.toMap.values
    .map(_.getFields.asScala.toMap.map {
      case (k, v) => k.getValue.toLowerCase -> v.toUserString
    })
    .toVector
    .filter(m => Set("2018", "2019").contains(m("year")))

  import net.jcazevedo.moultingyaml._
  import net.jcazevedo.moultingyaml.DefaultYamlProtocol._
  lazy val txt = os.read(os.pwd / "data" / "extrapubs.yaml").replace("\t", " ")
  lazy val yamlAst = txt.parseYaml
  lazy val data =
    yamlAst.convertTo[Vector[Map[String, YamlValue]]]

  def getString(y: YamlValue): String = y match {
    case YamlNumber(value)    => value.toString()
    case YamlString(value)    => value
    case YamlBoolean(boolean) => boolean.toString()
    case _                    => ""
  }

  lazy val allPubs: Vector[Map[String, String]] = (mp ++
    (data
      .map(m => m.mapValues(getString(_)).toMap
      ))
      .filter(m => Set("2019", "2020").contains(m("year"))))
    .sortBy(m => m("author"))

  def tex(m: Map[String, String]) = {
    val author = m("author")
    val title = m("title")
    val journal = m.get("journal").orElse(m.get("booktitle")).getOrElse("")
    val pages = m.getOrElse("pages", "")
    val volume = m.getOrElse("volume", "")
    val year = m("year")
    val doiOpt = m.get("doi").map(_.replace("_", "\\_"))
    val urlOpt = m.get("url")
    val doiText = doiOpt.map(s =>s", DOI $s").getOrElse("")
    val urlText = urlOpt.map(s => s", \\url{$s}").getOrElse("")
    s"\\item $author, {\\em $title}, $journal {\\bf $volume} ($year), $pages$doiText$urlText."
  }

  lazy val pubItems = allPubs.map(tex)

}
