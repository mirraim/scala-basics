package exercises.oop

import scala.annotation.tailrec

object LogSystem extends App {
  class Logger(val msgNum: Int = 0) {
    def info(): Logger = {
      println("INFO New Message")
      new Logger(msgNum + 1)
    }

    def info(count: Int): Logger = {
      if (count <= 0) this
      else info().info(count - 1)
    }

    def print(): Unit = println(msgNum)
  }

  /**
   * last - возвращает последнее поступившее сообщение (иначе говоря - head списка)
   * previous - возвращает все ранее поступившие собщения(это будет tail или хвост списка), за исключением самого последнего (т.е. за исключением head)
   * isEmpty - проверяет, если ли в нашем списке сообщения
   * all - предоставляет нам содержимое нашего списка в виде строки
   * add(msg) - добавляет сообщение в список
   */
  abstract class LogList[+A] {
    def last: A
    def previous: LogList[A]
    def isEmpty: Boolean
    def all: String
    def add[B >: A](msg: B): LogList[B]

  }


  /**
   * all, описанный в Log, требует написания рекурсивной функции,
   * результатом которой будет строка, содержащая все поступившие в систему сообщения (сообщения разделены пробелом,
   * но начинаться с пробела итоговая строка не должна)
   */
  class Log[+A](head: A, tail: LogList[A]) extends LogList[A] {
    override def last: A = head
    override def previous: LogList[A] = tail

    override def isEmpty: Boolean = head == null
    override def all: String = {
      @tailrec
      def loop(logList: LogList[A] = this, acc: String = ""): String = {
        if (logList.isEmpty) acc.trim
        else loop(logList.previous, acc + s"${logList.last} ")
      }
      loop()
    }
    override def add[B >: A](msg: B): LogList[B] = new Log(msg, this)
  }

  /**
   * Empty не содержит в себе элементов, поэтому для previous и last бросает исключение NoSuchElementException
   * all, описанный в Empty возвращает пустую строку
   */
  object Empty extends LogList[Nothing] {
    override def last: Nothing = throw new NoSuchElementException()

    override def previous: Nothing = throw new NoSuchElementException()
    override def isEmpty: Boolean = true
    override def all: String = ""
    override def add[A](msg: A): LogList[A] = new Log(msg, Empty)
  }

  val log = new Log("m1", new Log("m2", new Log("m3", Empty)))

  println(log.all)
}
