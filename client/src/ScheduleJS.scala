package courses

import scala.scalajs.js.annotation._
import org.scalajs.dom

import scala.concurrent.ExecutionContext.Implicits.global
import org.scalajs.dom.raw._



import scala.scalajs.js
import js.Dynamic.{global => g}
import ujson.Js
import scalatags.JsDom.all._
import org.scalajs.dom.ext._
import org.scalajs.dom.html.{Button, Div, OList, Select, Span, UList}
import scalatags.JsDom
import ujson.Js.Value

import scala.collection.immutable
import scala.collection.mutable.{Set => mSet}

@JSExportTopLevel("ChooserJS")
object ChooserJS {
  def getCourses(js: Js.Value): Vector[Course] =
    js.arr.toVector.map(Course.fromJson)

  var coursesOpt: Option[Vector[Course]] = None

  def courses: Vector[Course] = coursesOpt.getOrElse(Vector.empty[Course])

  var courseOpt: Option[Course] = None

  val forbiddenClashes: mSet[(Course, Course)] = mSet()

  def forbidJs: Js.Arr =
    Course.pairsToJson(forbiddenClashes)

  val timingDiv: Div = div(`class` := "col-md-7")().render

  val chosenDiv: Div = div(`class` := "col-md-5")().render

  val submitButton: Button =
    button(`type` := "button", `class` := "btn btn-primary")("Submit").render

  val nosubmitButton: Button =
    button(`type` := "button", `class` := "btn btn-default disabled")("Submit").render

  val timings: mSet[(Int, Timing)] = mSet()

  def avoid(c: Course): Vector[Course] =
    forbiddenClashes.filter(_._1 == c).map(_._2).toVector.sortBy(_.code)

  def timingsJson: Value =
    Timing.timingsToJson(timings)

  def submitJson =
    Js.Obj(
      "course" -> courseOpt.get.json,
      "timings" -> timingsJson,
      "forbidden" -> forbidJs
    )

  submitButton.onclick = (_) =>
    Ajax.post("/save-preferences", ujson.write(submitJson)).foreach{xhr =>
      courseOpt = None
      timings.clear()
      update()
      Option(dom.document.querySelector("#message")).foreach{
        message =>
          message.appendChild(h1(`class` := "text-success")("Thanks for your submission!").render)
      }
      Option(dom.document.querySelector("#chooser")).foreach{
        chooser =>
          chooser.innerHTML = ""
      }

    }

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
      update()
    }
    div(`class` := "form-group")(label(`for` := "courseSelect")("Course:"), sl).render

  }

  nosubmitButton.onclick = (_) =>
    dom.window.alert(
      if (courseOpt.isEmpty) "Please choose course"
      else
        "Please give at least three choices; at least one of the first three choices should be for 3 one hour lectures")

  def forbidInput(c1: Course): JsDom.TypedTag[Div] = {
    val btn =
      button(`class` := "btn btn-warning pull-right")("avoid clash").render
    val opts =
      for {
        l <- coursesOpt.toVector
        c <- l
        if !avoid(c1).contains(c)
      } yield option(value := c.code)(s"${c.code} ${c.name} (${c.instructor})")

    val sl =
      select(id := "courseSelect", `class` := "form-control")(
        option(value := "", selected, disabled)("Choose course") +:
          opts: _*
      ).render

    def code: String = sl.value

    def cOpt: Option[Course] =
      for {
        l <- coursesOpt
        c <- l.find(_.code == code)
      } yield c

    btn.onclick = (_) => {
      cOpt.map { c2 =>
        forbiddenClashes ++= Seq(c1 -> c2, c2 -> c1)
        update()
      }
    }

    div(sl, p("Please click the button below after choosing course."), btn)
  }

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

  def enoughChoices: Boolean = {
    (1 to 3)
      .map { (j) =>
        timings.count(_._1 <= j) >= j
      }
      .reduce(_ && _) &&
    timings.exists { case (n, t) => n <= 3 && t.days == "Mon, Wed, Fri" }
  }

  def chosenList: Div = {
    val maxChoice = if (timings.nonEmpty) timings.map(_._1).max else 0
    val rows =
      (1 to maxChoice).map { (n) =>
        val cols = timings
          .filter(_._1 == n)
          .map(_._2)
          .map((s) => li(s.show, " ", removeButton(n, s)))
          .toVector
        li(ul(cols: _*))
      }

    val code: String = courseOpt.map(_.code).getOrElse("")

    val instructor = courseOpt.map(_.instructor).getOrElse("")

    val name = courseOpt.map(_.name).getOrElse("")

    div(
      h4(`class` := "text-center")("Your choices"),
      ol(rows: _*),
      p(
        if (enoughChoices)
          "Please check selected course below befor submitting. More choices are always welcome!"
        else
          "Please give at least three choices; at least one of the first three choices should be for 3 one hour lectures"),
      h3(`class` := "text-center")(strong("Course")),
      ul(`class` := "list-unstyled")(
        li(strong("Code: "), code),
        li(strong("Title: "), name),
        li(strong("Instructor: "), instructor)
      ),
      courseOpt.map(c1 =>
        div(
          h4("Avoiding clashes with courses:"),
          ul(
            avoid(c1).map((c) => li(s"${c.code} ${c.name}")): _*
          ),
          div(`class` := "row")(
            h6("Additional clashes to avoid (if any)"),
            courseOpt.map(c1 => forbidInput(c1)).getOrElse(div()))
        )
      ).getOrElse(div()),
//
//      h4("Avoiding clashes with courses:"),
//      ul(
//        courseOpt
//          .map((c) => avoid(c))
//          .getOrElse(Vector())
//          .map((c) => li(s"${c.code} ${c.name}")): _*
//      ),
//      div(`class` := "row")(
//        h6("Additional clashes to avoid (if any)"),
//        courseOpt.map(c1 => forbidInput(c1)).getOrElse(div())),
      if (enoughChoices && courseOpt.nonEmpty) div(submitButton)
      else div(nosubmitButton)
    ).render
  }

  def update(): Unit = {
    timingDiv.innerHTML = ""
    timingDiv.appendChild(timingTable.render)

    chosenDiv.innerHTML = ""
    chosenDiv.appendChild(chosenList)
  }

  @JSExport
  def load(): Unit = {

    Option(dom.document.querySelector("#chooser")).foreach { (chooser) =>
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
        val elems = dom.document.querySelectorAll("select");
        g.instances = g.M.FormSelect.init(elems, g.options);
      }

      Ajax.get("forbidden-clashes").foreach { xhr =>
        val coursePairsJs = ujson.read(xhr.responseText).arr.toVector
        val pairs: Vector[(Course, Course)] =
          Course.pairsFromJson(coursePairsJs)
        forbiddenClashes ++= pairs

      }
    }
  }

}
