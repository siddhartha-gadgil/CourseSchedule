package courses

import net.jcazevedo.moultingyaml._
import net.jcazevedo.moultingyaml.DefaultYamlProtocol._
import ujson.Js


object CourseData{
  val semName = "jan2025"

  lazy val source: String = os.read(os.pwd / "server" / "resources" / "courses.yaml")

  lazy val yamlAst: YamlValue = source.parseYaml

  lazy val m: Map[String, YamlValue] = yamlAst.convertTo[Map[String, YamlValue]]

  lazy val sem: Map[String, YamlValue] = m(semName).convertTo[Map[String, YamlValue]]

  def stringMap(y: YamlValue): Vector[Map[String, String]] = y.convertTo[Vector[Map[String, YamlValue]]]map(_.collect{
    case (key, YamlString(value)) => key-> value
  })

  lazy val core1: Vector[Course] = stringMap(sem("core1")).map(Course.fromMap)

  lazy val coreUG: Vector[Course] = sem.get("core-ug").map(y =>stringMap(y).map(Course.fromMap)).getOrElse(Vector())

  lazy val coreIntPhD: Vector[Course] = sem.get("core-intphd").map(y =>stringMap(y).map(Course.fromMap)).getOrElse(Vector())

  lazy val core2: Vector[Course] = sem.get("core2").map(y =>stringMap(y).map(Course.fromMap)).getOrElse(Vector())

  lazy val courseMap: Vector[Map[String, String]] = sem.values.flatMap(stringMap).toVector

  lazy val courses: Vector[Course] = courseMap.map(Course.fromMap).filter(_.code.startsWith("MA")).sortBy(_.code)

  def get(c: String) = courses.find(_.code == c)

  lazy val json = ujson.Arr(courses.map(_.json)  : _*)

  lazy val jsonCore1 = ujson.Arr(core1.map(_.json)  : _*)

  lazy val jsonCoreUG = ujson.Arr(coreUG.map(_.json)  : _*)

  lazy val jsonCoreIntPhD = ujson.Arr(coreIntPhD.map(_.json)  : _*)

  lazy val jsonCore2 = ujson.Arr(core2.map(_.json)  : _*)

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

  lazy val electives: Vector[Course] = courses.filterNot((core1 ++ coreUG ++ coreIntPhD).contains(_))

  lazy val electivesForForm: String = (electives).map{(c: Course) => s"${c.code} ${c.name} (${c.instructor})"}.mkString("\n","\n", "\n")

}
