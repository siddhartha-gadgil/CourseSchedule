package courses

import ujson.Js

case class Course(name: String, code: String, instructor: String){
  def json =
    ujson.Obj(
      "name" -> name,
      "code" -> code,
      "instructor" -> instructor
    )
}

object Course{
  def fromMap(m: Map[String, String]) = Course(m("name"), m("code"),m("instructor"))

  def fromJson(js: ujson.Value) =
    Course(
      js.obj("name").str,
      js.obj("code").str,
      js.obj("instructor").str
    )

  def pairsToJson(p: Iterable[(Course, Course)]): ujson.Arr = {
    val pairs: Seq[ujson.Obj] =
      for {
        (i, j) <- p.toVector
      }  yield ujson.Obj(
        "first" -> i.json,
        "second" -> j.json
      )
    ujson.Arr(pairs : _*)
  }

  def pairsFromJson(js: ujson.Value): Vector[(Course, Course)] = {
    js.arr.toVector.map { js =>
      (Course.fromJson(js.obj("first")), Course.fromJson(js.obj("second")))
    }
  }
  
}
