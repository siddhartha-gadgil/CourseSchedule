package courses

case class Course(name: String, code: String, instructor: String)

object Course{
  def fromMap(m: Map[String, String]) = Course(m("name"), m("code"),m("instructor"))
}
