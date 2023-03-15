package lectures.week2oop

/**
 * Компаньоны
 * Если в одном и том же файле и под одним и тем же именем объявить объект и класс, то в таком случае их можно смело назвать компаньонами.
 * Объект имеет доступ ко всем полям и методам своего класса-компаньона (в том числе и private).
 */
object ObjectsOOP {
  class MyString(val str: String) {
    private var extra = "extra data"

    override def toString: String = str + " " + extra;

  }

  object MyString {
    def apply(base: String, extras: String): MyString = {
      val s = new MyString(base)
      s.extra = extras
      s
    }

    def apply(base: String) = new MyString(base)
  }

  /**
   * Два ключевых момента, оба связаны с синтаксическим сахаром:
   *
   * apply можно не прописывать, а сразу после имени объекта в скобках указывать параметры apply метода
   * переименовав getString в toString, мы избавили себя от необходимости вообще прописывать имя метода для его вызова
   */
  println(MyString("hello", "world"))
  println(MyString("welcome"))

  /**
   * У объекта, как мы выяснили ранее, отсутствуют передаваемые параметры.
   *
   * Но если все же надо как-то имплементировать усложненный интерфейс для создания объекта,
   * а конструктор класса менять не айс, то выкрутиться поможет фабричный метод.
   *
   * @param num
   */
  class Number(val num: Int)

  object Number {
    val Pi = 3.14

    def apply(x: Number, y: Number): Number = new Number(x.num + y.num)
  }

  val numA = new Number(1)
  val numB = new Number(2)

  val numC = Number(numA, numB) // применяем apply

  println(numA.num) // 1
  println(numB.num) // 2
  println(numC.num) // 3

}
