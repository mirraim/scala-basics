package lectures.week3fp

import scala.annotation.tailrec

object FunctionsFP extends App {
// Эквиваленты:
  private var product = new ((Int, Int) => Int) {
    override def apply(x: Int, y: Int): Int = x * y
  }

  product = (x: Int, y: Int) => x * y

  val product1: (Int, Int) => Int = (x, y) => x * y

  val product2: (Int, Int) => Int =  _ * _

  // при обращении к лямбда-функциям обязательно использовать скобки - иначе получите саму функцию,  а не результат ее выполнения

  private val noParams = () => true
  println(noParams()) // true
  println(noParams) // lectures.week3fp.Functions$$$Lambda$24/0x00000001000c3840@2de8284b


  private val strlen = (s: String) => s.length

  println(strlen("Hello"))


  /**
   * High Order Functions
   * Под функциями высшего порядка понимают такие функции, которые на вход получают другую функцию или же, как результат, возвращают функцию.
   * при работе с функциями высшего порядка (когда передаем функцию в качестве аргумента) лучше использовать val,
   * так как это дает лучшую производительность.   *
   * Улучшение производительности связано с тем, что val нацелено на работу с неизменяемыми переменными,
   * значит, инициализация происходит всего один раз.
   *
   * функция, определенная внутри класса с помощью def называется методом этого класса.
   * с помощью def можно определить и метод и функцию (когда определение находится внутри другой функции или внутри объекта).
   *   * Но в основном - с помощью def определяем методы, с помощью val - функции (функциональные литералы).
   * После компиляции def транслируется в Java метод. Даже если определение находится внутри другого def метода,
   * внутри функции или объекта - компилятор всегда преобразует его в обычный Java метод,
   * благодаря чему доступны перегрузки, параметры типа (дженерики) и тд.
   * val функция транслируется в функциональное значение (т.е. объект, созданный с помощью new Function1 {def apply(a).... } )
   */

  @tailrec
  def nTimes(f: Int => Int, x: Int, n: Int): Int = {
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)
  }

  private val increment = (x: Int) => x + 1

  println(nTimes(increment, 0, 3))

  /**
   * Currying Functions
   * под каррированной функцией подразумевают функцию, которая на вход принимает несколько аргументов
   * (причем - можно сказать, что аргументы разбиты на группы).
   * А в теле этой функции происходит серия вызовов функций, каждая из которых принимает единственный аргумент
   * обращаясь к алгебрe, расписать весь процесс можно примерно так:
   * f1 = f(x)
   * f2 = f1(y)
   * result = f2(z)
   * Иначе говоря:
   * result = f(x)(y)(z)
   *
   * def имяФункции(аргумент1, агрумент2) = (аргумент3) => операция
   * curryingNTimes(f,n) = x => f( f(f...f(x) ) )
   */

  def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
    else (x: Int) => curryingNTimes(f, n - 1)(f(x))
  }
  println(curryingNTimes(increment, 3)(0))

  def createURL(baseURL: String) = (path: String) => s"https://${baseURL}/${path}"
  val stepikURL = createURL("stepik.org")
  val googleURL = createURL("mail.google.com")
  stepikURL("login")
  stepikURL("contact")
  googleURL("login")

  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val res = someFunc(1)
println("_________________________________")
  println(res.toString())
  println(res(4))
  println(someFunc(3)(4))
}
