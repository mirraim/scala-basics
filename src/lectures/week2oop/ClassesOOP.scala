package lectures.week2oop

object ClassesOOP extends App {

  val student = new Student(0, "Bob")
  println(student.name)

  // параметр класса еще не член класса, доступ к которому можно получить через точку.
  // Чтобы этот доступ сделать возможным - необходимо добавить ключевое слово val или var, прописав его перед параметром.
  // Тогда мы получим поле класса, к которому можно при необходимости обратиться.
  class Student(id: Int, val name: String) {

    //конструкторы
    def this(name: String) = this(0, name)
    def this() = this(0, "default")
  }

  class Employee(val name: String, var salary: Double) {
    def this() = this("John", 0.0)
  }

  val employee = new Employee()
  println(s"${employee.name}'s salary is ${employee.salary}")
}
