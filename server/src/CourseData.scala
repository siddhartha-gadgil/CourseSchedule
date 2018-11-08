package courses

import ammonite.ops._
import net.jcazevedo.moultingyaml._
import net.jcazevedo.moultingyaml.DefaultYamlProtocol._
import ujson.Js

object CourseData{
  lazy val source: String = read(resource / "courses.yaml")

  lazy val yamlAst: YamlValue = source.parseYaml

  lazy val m: Map[String, YamlValue] = yamlAst.convertTo[Map[String, YamlValue]]

  lazy val sem: Map[String, YamlValue] = m("jan2019").convertTo[Map[String, YamlValue]]

  lazy val core1: Vector[Course] = sem("core1").convertTo[Vector[Map[String, String]]].map(Course.fromMap)

  lazy val courseMap: Vector[Map[String, String]] = sem.values.flatMap(_.convertTo[Vector[Map[String, String]]]).toVector

  lazy val courses: Vector[Course] = courseMap.map(Course.fromMap).filter(_.code.startsWith("MA")).sortBy(_.code)

  lazy val json = Js.Arr(courses.map(_.json)  : _*)

  def pairs[A](s: Set[A]) : Vector[(A, A)] =
    (for {
      i <- s
      j <- s
    } yield (i, j)).toVector

  lazy val corePairs: Vector[(Course, Course)] = pairs(core1.toSet)

  write.over(
    pwd / "data" / "courses.json",
    ujson.write(Js.Arr(courses.map(_.json) : _*), 2)
  )

}
