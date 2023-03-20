package lectures.week2oop

object CaseClasses extends App {
  /**
   * Одной из основных идей функционального программирования является то, что мы стараемся разделить структуры данных и операции над ними.
   * Т.е. все функции обычно сбрасываются в трейты и объекты, но никак не в обычные классы (их вообще желательно избегать,
   * если того позволяет бизнес-логика вашего приложения, прибегая к case классам).
   * Однако существует набор методов, которые всегда придутся кстати для любого класса.
   * Именно доступ к таким методам и дают классы образцы, избавляя вас от необходимости имплементировать эти методы вручную.
   */

  case class Person(name: String, occupation: String)

  val bob = Person("Bob", "Developer")
  println(bob.name)

  // toString переопределен автоматически, выводит все поля
  println(bob)

  val bobsDouble = Person("Bob", "Developer")

  // Обычно при обсуждении метода equals( == ) принято говорить о reference level equality и content level equality.
  // Одним из свойств case class’ов является обязательное наличие списка параметров (пусть даже пустого),
  // что объясняет существование прописанного специально для них метода equals, представляющего content level equality
  // и позволяющего производить сравнение по структуре, а не по ссылкам.
  //
  //Поэтому, если создать двойника Боба(bobsDouble), а затем сравнить двойника с оригиналом,
  // то в случае case класса - получим true, хотя обычный класс выдаст false.
  println(bob == bobsDouble)
  println(bob.equals(bobsDouble))

  /**
   * copy позволяет как полностью скопировать экземпляр класса, так и скопировать с измененными аргументами конструктора.
   */

  val anotherBob = bob.copy()
  println(bob) // Person(Bob,Developer)
  println(anotherBob) // Person(Bob,Developer)

  val bobsTwin = bob.copy(name = "John")
  println(bobsTwin) // Person(John,Developer)

  val alice = Person("Alice", "Engineer") // метод apply в действии

  case class Course(title: String, instructor: String)

  object Course {
    def apply(instructor: String): Course = Course("AdvancedScala", instructor)
  }

  val scalaCourse = Course("Scala", "Bob")


  val course = scalaCourse.copy()

  //val course1 = new Course("Scala")

  val course2 = Course("Alice")

  val course3 = new Course("Scala", "Bob")

  val course4 = Course("Scala", "Bob")

  val course5 = scalaCourse.copy("AdvancedScala")

}
