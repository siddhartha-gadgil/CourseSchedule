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

  val core1: Vector[Course] = sem("core1").convertTo[Vector[Map[String, String]]].map(Course.fromMap)

  val courseMap: Vector[Map[String, String]] = sem.values.flatMap(_.convertTo[Vector[Map[String, String]]]).toVector

  val courses: Vector[Course] = courseMap.map(Course.fromMap).filter(_.code.startsWith("MA")).sortBy(_.code)

  lazy val json = Js.Arr(courses.map(_.json)  : _*)

  def pairs[A](s: Set[A]) : Vector[(A, A)] =
    (for {
      i <- s
      j <- s
    } yield (i, j)).toVector

  val corePairs: Vector[(Course, Course)] = pairs(core1.toSet)

  write.over(
    pwd / "data" / "courses.json",
    ujson.write(Js.Arr(courses.map(_.json) : _*), 2)
  )

}
