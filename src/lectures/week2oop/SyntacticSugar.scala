package lectures.week2oop

import scala.language.postfixOps

object SyntacticSugar extends App {
  class Person(val name: String, occupation: String) {
    def worksAs(jobName: String): Boolean = jobName == occupation
    def speaksEnglish: Boolean = true

    //операторы в Scala на самом деле являются методами и к ним можно обратиться через точку.
    println(1 + 2) // обычное обращение
    println(1.+(2)) // обращение через точку

    // операторы можно использовать в качестве имени метода:
    def &(person: Person): String = s"${this.name} and ${person.name} are colleagues"

    def unary_! : String = s"$name is not real"

    def apply(): String = s"$name works as a $occupation"
  }

  /**
   * Infix notation
   */
  val bob = new Person("Bob", "Developer")

  println(bob.worksAs("Developer"))
// так как worksAs принимает на вход всего один аргумент, то вызов этого метода мы можем переписать в инфиксной нотации:
  println(bob worksAs "Developer")

  val alice = new Person("Alice", "Data Engineer")

  println(bob.&(alice)) // точечная нотация
  println(bob & alice) // инфиксная нотация

  /**
   * Postfix notation
   *
   * на практике инфиксная и постфиксная нотации применяются довольно редко И предпочтение отдается точечной нотации,
   * чтобы не вводить в заблуждение коллег.
   * Кроме того, в версиях Scala, начиная с 2.13, постепенно уходят от постфиксных нотаций,
   * что требует дополнительного импортирования import scala.language.postfixOps
   */
//Постфиксная нотация аналогична инфиксной, просто используется для методов без параметров.
  println(bob.speaksEnglish) // точечная нотация
  println(bob speaksEnglish) // постфиксная нотация

  /**
   * Prefix notation
   */

  val x = -1
  //Префикс unary_ подходит только для + - ~
  val y = 1.unary_-

  println(!bob) // префиксная нотация
  println(bob.unary_!) // точечная нотация
  println(bob unary_!) // постфиксная нотация

  /**
   * Метод apply() можно не дописывать
   */

  println(bob.apply())
  println(bob()) // используется наболее часто

}
