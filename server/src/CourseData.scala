package courses

import ammonite.ops._
import net.jcazevedo.moultingyaml._
import net.jcazevedo.moultingyaml.DefaultYamlProtocol._
import ujson.Js

object CourseData{
  val source: String = read(resource / "courses.yaml")

  val yamlAst: YamlValue = source.parseYaml

  val m: Map[String, YamlValue] = yamlAst.convertTo[Map[String, YamlValue]]

  val sem: Map[String, YamlValue] = m("jan2019").convertTo[Map[String, YamlValue]]


  val courseMap: Vector[Map[String, String]] = sem.values.flatMap(_.convertTo[Vector[Map[String, String]]]).toVector

  val courses: Vector[Course] = courseMap.map(Course.fromMap)

  lazy val json = Js.Arr(courses.map(_.json)  : _*)
}
