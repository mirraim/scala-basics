package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App {
// так делать можно, но не надо. В функциональном программировании лучше работать с неизменяемыми переменными
  var i = 0
  while (i < 3) {
    println("hello")
    i += 1
  }

  //Вместо циклов используем рекурсию
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s"Имеем число $n, для которого считаем факториал ${n-1}")
      val res = n * factorial(n - 1)
      println(s"Вычислили факториал $n")

      res
    }
  }

  factorial(3)

  //Для того, чтобы избежать переполнения стэка, используют хвостовую рекурсию
  //Отличительной особенностью функции с хвостовой рекурсией является то,
  // что последней операцией идет вызов этой самой функции. И теперь промежуточные вычисления накапливаются в аккумуляторе.
  //Такое применение вспомогательной функции, написанной в стиле хвостовой рекурссии позволяет обойтись
  // без использования дополнительного стека для хранения промежуточных результатов.
  def factorialWithTailRecursion(n: Int): Int = {
    @tailrec // аннотация, чтобы быть увереным, что метод является хвостовой рекурсией. Если нет, то метод просто не запустится
    def loop(x: Int, accumulator: Int = 1): Int = {
      if (x <= 1) accumulator
      else loop(x - 1, x * accumulator)
    }

    loop(n)
  }
  println(factorialWithTailRecursion(3))

  def repeatWord(word: String, n: Int): String = {
    @tailrec
    def loop(i: Int, acc: String = word): String = {
      if (i <= 1) acc
      else loop(i - 1, s"$word $acc")
    }

    loop(n)
  }
  println(repeatWord("N", 6))
}
