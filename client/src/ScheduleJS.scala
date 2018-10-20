package courses

import scala.scalajs.js.annotation._
import org.scalajs.dom

import scala.concurrent.ExecutionContext.Implicits.global
import org.scalajs.dom.raw._

import scala.scalajs.js
import ujson.Js
import scalatags.JsDom.all._
import org.scalajs.dom.ext._
import org.scalajs.dom.html.{Div, Select}

@JSExportTopLevel("ChooserJS")
object ChooserJS {
  def getCourses(js: Js.Value): Vector[Course] =
    js.arr.toVector.map(Course.fromJson)

  var coursesOpt: Option[Vector[Course]] = None

  var courseOpt: Option[Course] = None

  def courseChoose: Div = {
    val opts =
      for {
        l <- coursesOpt.toVector
        c <- l
      } yield option(value := c.code)(s"${c.code} ${c.name} (${c.instructor})")

    val sl =
      select(id := "courseSelect", `class` := "form-control")(
        (option(value := "", selected, disabled)("Choose course") +:
          opts): _*
      ).render

    sl.oninput = (_) => {
      val code = sl.value
      val c =
        for {
          l <- coursesOpt
          c <- l.find(_.code == code)
        } yield c
      courseOpt = c
    }
    div(`class` := "form-group")(
      label(`for` := "courseSelect")("Course:"),
      sl).render
  }

  @JSExport
  def load(): Unit = {

    import org.scalajs.dom.html.Select

    def chooser: Element = dom.document.querySelector("#chooser")

    val selectCourse = div().render

    val mainDiv =
      div(
        selectCourse,
        h4("Preferred timings:")
      ).render

    chooser.appendChild(mainDiv)

    Ajax.get("course-list").foreach { xhr =>
      val courses = getCourses(ujson.read(xhr.responseText))
      coursesOpt = Some(courses)
      selectCourse.appendChild(courseChoose)
      mainDiv.appendChild(div("Received").render)
    }
  }

}
