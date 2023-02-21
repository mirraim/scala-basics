package lectures.week1basics

object Functions extends App {

  def aPerson(name: String, surname: String): String = {
    s"$name $surname"
  }

  println(aPerson("John", "Smith"))

  def aParameterlessFunction(): Unit = println("Function with no parameters")

  aParameterlessFunction()
  aParameterlessFunction

  //В Scala мы можем задавать дефолтные значения для параметров,
  // что позволит нам лишний раз не указывать параметры при вызове функции
  // Дефолтные параметры должны быть в конце
  def aFunctionWithDefaultParameter(x: Int, y: String = "Default Parameter"): String = {
    s"x = $x and y = $y"
  }

  println(aFunctionWithDefaultParameter(1)) // выводит x = 1 and y = Default Parameter

  //вызов по значению - подразумевает вычисление значения переданного выражения перед вызовом функции.
  //Оба вывода будут одинаковыми, потому что параметр вычисляется ДО вызова функции
  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  //Вызов по имени - подразумевает вычисление значения выражения в момент его вызова в функции
  //Выводы будут разными, потому что вычисление параметра происходит в момент его использования
  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  //можно определять функцию внутри функции
  def aBossFunction(): String = {
    def aHelperFunction(): String = "I'm here to help"

    aHelperFunction()
  }
}
