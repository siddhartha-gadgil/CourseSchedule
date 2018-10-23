package courses

import ujson.Js
import ujson.Js.Value

sealed trait Timing extends Product with Serializable{
  val days : String

  val times: String

  lazy val show: String = s"$days $times"

  def json = Js.Obj(
    "days" -> days,
    "times" -> times
  )
}

object Timing{
  case class MWF(times: String) extends Timing{
    val days = "Mon, Wed, Fri"
  }

  case class TuTh(times: String) extends Timing{
    val days = "Tue, Thu"
  }

  def fromJson(js: Js.Value) =
    js.obj("days").str match {
      case "Mon, Wed, Fri" => MWF(js.obj("times").str)
      case "Tue, Thu" => TuTh(js.obj("times").str)
    }

  def timingsFromJson(jsv: Js.Value): Vector[(Int, Timing)] =
    jsv.arr.toVector.map {
      js =>
        js.obj("choice").num.toInt -> Timing.fromJson(js.obj("timing"))
    }

  def timingsToJson(timings: Iterable[(Int, Timing)]): Value =
    Js.Arr(
      timings.toVector.sortBy(_._1).map {
        case (i, t) =>
          Js.Obj(
            "choice" -> Js.Num(i),
            "timing" -> t.json
          )
      }: _*
    )

  val all: Vector[Timing] =Vector(
    MWF("8:00 - 9:00"),
    MWF("9:00 - 10:00"),
    MWF("10:00 - 11:00"),
    MWF("11:00 - 12:00"),
    MWF("1:00 - 2:00"),
    MWF("2:00 - 3:00"),
    TuTh("8:30 - 10:00"),
    TuTh("10:00 - 11:30"),
    TuTh("11:30 - 1:00"),
    TuTh("2:00 - 3:30"),
    TuTh("3:30 - 5: 00"),
  )

}