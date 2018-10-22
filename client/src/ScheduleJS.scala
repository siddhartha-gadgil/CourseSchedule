package courses

import scala.scalajs.js.annotation._
import org.scalajs.dom

import scala.concurrent.ExecutionContext.Implicits.global
import org.scalajs.dom.raw._

import scala.scalajs.js
import ujson.Js
import scalatags.JsDom.all._
import org.scalajs.dom.ext._
import org.scalajs.dom.html.{Button, Div, OList, Select, UList}
import scalatags.JsDom

import scala.collection.immutable
import scala.collection.mutable.{Set => mSet}

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
        option(value := "", selected, disabled)("Choose course") +:
          opts: _*
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
    div(`class` := "form-group")(label(`for` := "courseSelect")("Course:"), sl).render

  }

  val timingDiv: Div = div(`class` := "col-md-7")().render

  val chosenDiv = div(`class` := "col-md-5")().render

  val submitButton =
    button(`type` := "button", `class` := "btn btn-primary")("Submit").render

  val nosubmitButton =
    button(`type` := "button", `class` := "btn btn-default disabled")("Submit").render

  nosubmitButton.onclick = (_) =>
    dom.window.alert(
      if (courseOpt.isEmpty) "Please choose course" else
      "Please give at least three choices, at least one of which is 3 one hour slots")

  val timings: mSet[(Int, Timing)] = mSet()

  def focusChoice: Int =
    (1 to 7).filter(n => !timings.map(_._1).contains(n)).min

  def timingButton(level: Int, timing: Timing): Button = {
    val btn =
      if (level == focusChoice)
        button(`class` := "btn btn-primary")(s"#$level").render
      else button(`class` := "btn btn-default")(s"#$level").render

    btn.onclick = _ => {
      timings += level -> timing
      update()
    }

    btn
  }

  def removeButton(level: Int, timing: Timing): Button = {
    val btn =
      button(`class` := "btn btn-secondary btn-sm")(
        span(`class` := "fa fa-remove")).render

    btn.onclick = _ => {
      timings -= level -> timing
      update()
    }

    btn
  }

  def timingTable = {
    val rows =
      for {
        t <- Timing.all
        buttons = td(
          ul(`class` := "list-inline")(
            (1 to 6).map { n =>
              li(`class` := "list-inline-item")(timingButton(n, t)).render
            }
          )
        )
      } yield
        tr(
          td(t.show).render,
          buttons
        )

    table(`class` := "table table-striped")(
      thead(
        tr(
          th("Timing"),
          th("Choice")
        )
      ),
      tbody(
        rows: _*
      )
    )
  }

  def enoughChoices = {
    (1 to 3)
      .map { (j) =>
        timings.count(_._1 <= j) >= j
      }
      .reduce(_ && _) &&
    timings.exists { case (n, t) => n <= 3 && t.days == "Mon, Wed, Fri" }
  }

  def chosenList = {
    val maxChoice = if (timings.nonEmpty) timings.map(_._1).max else 1
    val rows =
      (1 to maxChoice).map { (n) =>
        val cols = timings
          .filter(_._1 == n)
          .map(_._2)
          .map((s) => li(s.show, " ", removeButton(n, s)))
          .toVector
        li(ul(cols: _*))
      }

    div(
      h4(`class` := "text-center")("Your choices"),
      ol(rows: _*),
      p(
        if (enoughChoices) "More choices are welcome!"
        else
          "Please give at least three choices, at least one of which is 3 one hour slots"),
      if (enoughChoices && courseOpt.nonEmpty) div(submitButton) else div(nosubmitButton)
    ).render
  }

  def update() = {
    timingDiv.innerHTML = ""
    timingDiv.appendChild(timingTable.render)

    chosenDiv.innerHTML = ""
    chosenDiv.appendChild(chosenList)
  }
  @JSExport
  def load(): Unit = {

    def chooser: Element = dom.document.querySelector("#chooser")

    val selectCourseDiv = div().render

    val mainDiv =
      div(
        selectCourseDiv,
        h4("Preferred timings:"),
        div(`class` := "row")(timingDiv, chosenDiv)
      ).render

    chooser.appendChild(mainDiv)

    update()

    Ajax.get("course-list").foreach { xhr =>
      val courses = getCourses(ujson.read(xhr.responseText))
      coursesOpt = Some(courses)
      selectCourseDiv.appendChild(courseChoose)
    }
  }

}
