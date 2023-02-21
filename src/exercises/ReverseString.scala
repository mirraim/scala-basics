package exercises

object ReverseString {
  def main(args: Array[String]): Unit = {
    println(reverse("I like     Scala"))
  }

  def reverse(string: String): String = {
    val words: Array[String] = string.split(" ")
    def loop(i: Int = words.length - 1, acc: String = ""): String = {
      if (i < 0) acc
      else {
        val word: String = words(i)
        if (word.isBlank) loop(i - 1, acc)
        else loop(i - 1, acc + word + " ")
      }
    }
    loop().trim
  }
}
