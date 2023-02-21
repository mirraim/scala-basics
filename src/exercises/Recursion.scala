package exercises

import scala.annotation.tailrec

object Recursion {
  def main(args: Array[String]): Unit ={
    println(degreeOfTwo(0))
    printSum(multiply(10, 1, 5))
  }

  def degreeOfTwo(degree: Int): BigInt = {
    @tailrec
    def loop(i: Int, acc: BigInt = 1): BigInt = {
      if (i < 1) acc
      else loop(i - 1, acc * 2)
    }

    loop(degree)
  }

  def multiply(x: Int, y: Int, n: Int): Int = {
    def loop(i: Int, acc: Int = x): Int = {
      if (i < 1) acc
      else loop(i - 1, acc + y)
    }
    loop(n)
  }

  def printSum(x: Int): Unit = {
    def loop(i: Int): Unit = {
      print(x)
      print(" ")
      if (i <= 1) print("is the result")
      else loop(i - 1)
    }
    loop(x.toString.length)
  }
}
