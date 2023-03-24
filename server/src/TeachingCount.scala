package courses

import net.jcazevedo.moultingyaml._
import net.jcazevedo.moultingyaml.DefaultYamlProtocol._
import ujson.Js
import CourseData._

object TeachingCount {
  val all: Map[String, Map[String, Vector[Map[String, String]]]] =
    m.mapValues(_.convertTo[Map[String, YamlValue]])
      .mapValues(m => m.mapValues(stringMap).toMap)
      .toMap

  val allCourses = all.values.flatMap(_.values).flatten.toVector

  def weightedPairs(c: Map[String, String]) =
    (
      c("instructor"),
      if (Set("UM 101", "UM 102", "UM 201").contains(c("code"))) 2 else 1
    )

  val instructors = allCourses.map(weightedPairs).toVector

  val instructorNumbers = instructors.groupMapReduce(_._1)(_._2)(_ + _).toVector.sortBy(_._2) 

}
