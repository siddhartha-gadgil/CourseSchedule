package courses

import ujson.Js

case class Course(name: String, code: String, instructor: String){
  def json =
    Js.Obj(
      "name" -> name,
      "code" -> code,
      "instructor" -> instructor
    )
}

object Course{
  def fromMap(m: Map[String, String]) = Course(m("name"), m("code"),m("instructor"))

  def fromJson(js: Js.Value) =
    Course(
      js.obj("name").str,
      js.obj("code").str,
      js.obj("instructor").str
    )
}
