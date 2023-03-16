package exercises

/**
 * Ваша задача - использовав знание анонимных классов, дополнить код так, чтобы сработал вызов:

notification.sendNotification
В результате должна появиться строка, уведомляющая о том, какой eventName был использован: trigger eventName event.

Таким образом, для случая, когда в качестве eventName задано mousedown, должна появиться строка: trigger mousedown event
 */
object EventListener extends App {
  abstract class Event {
    def trigger(eventName: String): Unit
  }

  class Listener(val eventName: String, var event: Event) {
    def register(evt: Event) {
      event = evt
    }

    def sendNotification() {
      event.trigger(eventName)
    }
  }

  val notification: Listener = new Listener("mousedown", null)

  // Здесь используется анонимный класс extends Event
  notification.register((eventName: String) => println(s"trigger $eventName event"))

  notification.sendNotification();

}
