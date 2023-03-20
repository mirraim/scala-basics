package lectures.week2oop

object GenericRestrictions extends App {
  trait Thing
  class Vehicle extends Thing
  class Car extends Vehicle
  class Ambulance extends Car
  class Taxi extends Car
  class Jeep extends Car
  class Bicycle extends Vehicle
  class Tricycle extends Bicycle
  class Parking[T](val vehicle: T)


  /**
   * B качестве типа T допускается использовать либо непосредственно сам тип Vehicle,
   * либо его подтипы, те Car, Ambulance, Taxi, Jeep, Bicycle, Tricycle
   */
  class VechileParking[T <: Vehicle](val vehicle: T)

  /**
   * в качестве Т мы ожидаем либо сам тип Vehicle, либо его супертипы те Thing
   */
  class SuperVechileParking[T >: Vehicle](val vehicle: T)

  /**
   * Для конкретного типа следует одновременно наложить на тип и верхнее, и нижнее ограничение:
   */
  class BicycleParking[T >: Bicycle <: Vehicle](val vehicle: T)

  class Fruit
  class Apple extends Fruit

  class Banana extends Fruit

  /**
   * Инвариантность диктует, что List[Apple] и List[Fruit] - это совершенно разные вещи, не связанные никакими родственными связями.
   * Тип, указанный в скобках без каких-либо дополнительных знаков, свидетельствует об инвариантности:
   */
  class InvariantList[A]
  val fruitList: InvariantList[Fruit] = new InvariantList[Fruit]

  /**
   * Ковариантность подразумевает, что раз Apple наследуется от Fruit, то и List[Apple] можно  рассматривать как потомка List[Fruit].
   * Для обозначения ковариантного списка - не забудьте добавить плюс перед типом:
   */
  class CovariantList[+A] {
    def add[B >: A](element: B): Unit = ???
  }

  val covariantList: CovariantList[Fruit] = new CovariantList[Apple]
  covariantList.add(new Banana)

  /**
   * Контрвариантность предполагает знак минус рядом с типом:
   */
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Apple] = new ContravariantList[Fruit]
}
