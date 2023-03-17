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
}
