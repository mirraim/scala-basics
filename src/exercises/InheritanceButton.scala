package exercises

object InheritanceButton extends App {

  class Button(label: String = "default") {
    def click(): String = {
      s"button -$label- has been clicked"
    }
  }

  class RoundedButton(label: String) extends Button(label) {
    override def click(): String = s"rounded ${super.click()}"
  }

  println((new RoundedButton("save")).click())
}
