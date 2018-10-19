package courses

import scala.scalajs.js.annotation._
import org.scalajs.dom
import scala.concurrent.ExecutionContext.Implicits.global

import org.scalajs.dom.raw._
import scala.scalajs.js
import ujson.Js

import org.scalajs.dom.ext._

@JSExportTopLevel("ChooserJS")
object ChooserJS {
  def getCourses(js: Js.Value) =
    js.arr.toVector.map(Course.fromJson)

  @JSExport
  def load() : Unit = {
    def chooser: Element = dom.document.querySelector("#chooser")

    val child: Element = dom.document
      .createElement("div")

    child.textContent =
      s"Linking Scala-js from chooser; using ${Course("this", "a", "b")}"
    chooser.appendChild(child)

    Ajax.get("course-list").foreach{
      (xhr) =>
        val js = getCourses(ujson.read(xhr.responseText))
        val resp = dom.document
          .createElement("div")
        resp.textContent = js.toString
        chooser.appendChild(resp)
    }
  }


}
