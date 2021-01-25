package courses

import net.jcazevedo.moultingyaml._
import net.jcazevedo.moultingyaml.DefaultYamlProtocol._
import ujson.Js


object CourseData{
  val semName = "jan2021"

  lazy val source: String = os.read(os.resource / "courses.yaml")

  lazy val yamlAst: YamlValue = source.parseYaml

  lazy val m: Map[String, YamlValue] = yamlAst.convertTo[Map[String, YamlValue]]

  lazy val sem: Map[String, YamlValue] = m(semName).convertTo[Map[String, YamlValue]]

  def stringMap(y: YamlValue): Vector[Map[String, String]] = y.convertTo[Vector[Map[String, YamlValue]]]map(_.collect{
    case (key, YamlString(value)) => key-> value
  })

  lazy val core1: Vector[Course] = stringMap(sem("core1")).map(Course.fromMap)

  lazy val core2: Vector[Course] = sem.get("core2").map(y =>stringMap(y).map(Course.fromMap)).getOrElse(Vector())

  lazy val courseMap: Vector[Map[String, String]] = sem.values.flatMap(stringMap).toVector

  lazy val courses: Vector[Course] = courseMap.map(Course.fromMap).filter(_.code.startsWith("MA")).sortBy(_.code)

  def get(c: String) = courses.find(_.code == c)

  lazy val json = ujson.Arr(courses.map(_.json)  : _*)

  def pairs[A](s: Set[A]) : Vector[(A, A)] =
    (for {
      i <- s
      j <- s
      if i != j
    } yield (i, j)).toVector

  lazy val corePairs: Vector[(Course, Course)] = pairs(core1.toSet) ++ pairs(core2.toSet)

  lazy val sameInstructor: Vector[(Course, Course)] =
    for {
      i <- courses
      j <- courses
      if i.instructor == j.instructor && i != j
    } yield (i, j)

  def save() = {
    os.write.over(
      os.pwd / "data" / semName / "courses.json",
      ujson.write(ujson.Arr(courses.map(_.json): _*), 2),
      createFolders = true
    )
  }

}
