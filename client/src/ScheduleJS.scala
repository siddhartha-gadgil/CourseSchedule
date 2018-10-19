package courses

import scala.scalajs.js.annotation._
import org.scalajs.dom

import org.scalajs.dom.raw._
import scala.scalajs.js


@JSExportTopLevel("ChooserJS")
object ChooserJS {
  @JSExport
  def load() : Unit = {
    def chooser: Element = dom.document.querySelector("#chooser")

    val child: Element = dom.document
      .createElement("div")

    child.textContent =
      s"Linking Scala-js from chooser; using ${Course("this", "a", "b")}"
    chooser.appendChild(child)
  }


}
