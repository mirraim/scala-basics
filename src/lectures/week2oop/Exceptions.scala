package lectures.week2oop

object Exceptions extends App {
  def intOrNothing(hasException: Boolean): Int =
    if(hasException) throw new RuntimeException("Exception is here")
    else 200

  try {
    intOrNothing(true)
  } catch {
    case e: RuntimeException => println("RTE is here")
  } finally {
    println("I will be there no matter whatz")
  }

  class MyException extends Exception

  val exception = new MyException
  throw exception

  /**
   * Все в Scala является выражением. val в exceptionVal будет иметь тип Nothing
   * Nothing означает, что ничего нет - пустоту.
   * А пустоту, если подумать, можно заполнить чем угодно.
   * Поэтому вполне можно в качестве типа переменной указать Int, а можно и String - да что угодно.
   */
  val exceptionVal = throw new NullPointerException
  val exceptionVali: Int = throw new NullPointerException
  val exceptionVals: String = throw new NullPointerException

  /**
   * То potentialException в этот раз будет иметь тип Any
   * Это объясняется тем, что необходимо угодить и тому, что будет возвращено в блоке try, и тому, что вернется в catch (finally не учитывается).
   * Т.е. в нашем примере необходимо использовать универсальный тип, который позволил бы переменной хранить в себе как значения типа Int, так и Unit.
   * И этим типом как раз будет AnyVal (можно запомнить как "готов к любому значению").
   */
  val potentialException = try {
    intOrNothing(false)
  } catch {
    case e: RuntimeException => println("RTE is here")
  } finally {
    println("I will be there no matter what")
  }
}
