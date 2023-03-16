package lectures.week2oop

object Inheritance extends App {
  class Person(name: String, age:Int) {
    val gender = "n/a"
    def greet: String = s"Hello"

    def this() = this("Unknown", 0)
  }

  /**
   *Для переопределения метода или переменной используем ключевое слово override.
   * Причем поля, в отличие от методов, могут быть переопределены в конструкторе класса:
   */
  class Student(name: String, age: Int, override val gender: String) extends Person(name, age) {
    //Когда хотим воспользоваться имплементацией метода или значением переменной из родительского класса,
    // b в то же время прикрутить к этому что-то свое. Для этого всего-лишь надо применить ключевое слово super.
    override def greet: String = s"${super.greet}, $name"
      println(greet)
  }

  class Baby() extends Person {
    println(greet)
  }


  new Student("Ann", 19, "women")
  println((new Baby).gender)


  /**
   * sealed довольно полезная штука, когда надо гарантировать существование подклассов, определяемых только в текущем файле.
   * Если попытаться привести практический пример, представьте, вы описываете дни недели.
   * Использование sealed гарантирует, что существовать будут только те дни, что конкретизированы в текущем файле,
   * и нигде вдруг случайно не всплывет доселе невиданный восьмой день недели.
   *
   * То, что вы будете знать, какие дни вам доступны - создает благоприятные условия для применения шаблонов, если они потребуются.
   */
  sealed abstract class DayOfTheWeek(val name: String, val isWeekend: Boolean)

  case object Monday extends DayOfTheWeek("Monday", false)

  case object Tuesday extends DayOfTheWeek("Tuesday", false)

  case object Wednesday extends DayOfTheWeek("Wednesday", false)

  case object Thursday extends DayOfTheWeek("Thursday", false)

  case object Friday extends DayOfTheWeek("Friday", false)

  case object Saturday extends DayOfTheWeek("Saturday", true)

  case object Sunday extends DayOfTheWeek("Sunday", true)
}
