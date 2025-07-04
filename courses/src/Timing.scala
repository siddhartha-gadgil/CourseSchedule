package courses


sealed trait Timing extends Product with Serializable{
  val days : String

  val times: String

  lazy val isMWF: Boolean = days == "Mon, Wed, Fri"

  lazy val isTuTh: Boolean = days == "Tue, Thu"

  lazy val show: String = s"$days $times"

  def json = ujson.Obj(
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

  def fromJson(js: ujson.Value) =
    js.obj("days").str match {
      case "Mon, Wed, Fri" => MWF(js.obj("times").str)
      case "Tue, Thu" => TuTh(js.obj("times").str)
    }

  def timingsFromJson(jsv: ujson.Value): Vector[(Int, Timing)] =
    jsv.arr.toVector.map {
      js =>
        js.obj("choice").num.toInt -> Timing.fromJson(js.obj("timing"))
    }

  def timingsToJson(timings: Iterable[(Int, Timing)]): ujson.Value =
    ujson.Arr(
      timings.toVector.sortBy(_._1).map {
        case (i, t) =>
          ujson.Obj(
            "choice" -> ujson.Num(i),
            "timing" -> t.json
          )
      }: _*
    )

  val all: Vector[Timing] =Vector(
    MWF("8:00 - 9:00"),
    MWF("9:00 - 10:00"),
    MWF("10:00 - 11:00"),
    MWF("11:00 - 12:00"),
    MWF("12:00 - 1:00"),
    MWF("2:00 - 3:00"),
    MWF("3:00 - 4:00"),
    TuTh("8:30 - 10:00"),
    TuTh("10:00 - 11:30"),
    TuTh("11:30 - 1:00"),
    TuTh("2:00 - 3:30"),
    TuTh("3:30 - 5: 00"),
  )

  val humanities: Vector[Timing] = Vector(
    MWF("11:00 - 12:00"),
    MWF("12:00 - 1:00"),
  )

}
