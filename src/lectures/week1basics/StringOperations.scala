package lectures.week1basics

object StringOperations extends App {

  var aString: String = "Hello, world!"

  println(aString.length) // выводит 13
  println(aString.charAt(1)) // выводит e
  println(aString.substring(0, 2)) // выводит He
  println(aString.split(" ").toList) // выводит List(Hello,, world!)
  println(aString.startsWith("He")) // выводит true
  println(aString.replace("!", ".")) // выводит Hello, world.
  println(aString.toLowerCase) // выводит hello, world!
  println(aString.toUpperCase) // выводит HELLO, WORLD!
  println("abcd".reverse) // выводит dcba
  println("abcd".take(2)) // выводит ab

  aString = "Scala course"
  println("___________________________________________________________-")

  println(aString.charAt(11))

  //println(aString.take(-1))

// println(aString.substring(12, 13))

  //println(aString.charAt(12))

  println(aString.substring(11, 12))

  //println(aString.take(12))

  println(aString.take(5).toUpperCase)

  println(aString.toUpperCase.substring(0, 5))
  println(aString.substring(0, 5).toUpperCase)

  println(aString.replace("a", "").take(3).reverse)

  val aNumber = "42".toInt
  println(aNumber) // выводит 42
  println(aNumber.getClass) // выводит int
  aString = 42.toString

  println('1' +: "42" :+ '3') // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++ "bc" :++ "d") // abcd

  /*
  добавление в начало подразумевает наличие двоеточия после  плюса. Соответственно, добавление в конец - перед плюсом
  +: или :+ подразумевает, что присоединять будем одиночные элементы (работаем с типом char)
  ++ или :++ указывает, что присоединять будем несколько элементов (используем элементы типа String), следовательно здесь уже понадобятся двойные кавычки
  внимание на типы, с которыми работаем: в нашем случае присоединения всегда происходит к элементам типа String (в примере это "42" и "bc")
   */
  println('3' +: "4")

  val link = "https://stepik.org"
  println(s"The link is \t $link")
  println(raw"The link is \t $link")
}
