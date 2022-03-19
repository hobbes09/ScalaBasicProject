// General classes

class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}

val greeter = new Greeter("Hello, ", "!")
greeter.greet("Scala developer") // Hello, Scala developer!

//========================

// Case classes

case class Point(x: Int, y: Int)

val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)

if (point == anotherPoint) {
  println(s"$point and $anotherPoint are the same.")
} else {
  println(s"$point and $anotherPoint are different.")
} // Point(1,2) and Point(1,2) are the same.

if (point == yetAnotherPoint) {
  println(s"$point and $yetAnotherPoint are the same.")
} else {
  println(s"$point and $yetAnotherPoint are different.")
} // Point(1,2) and Point(2,2) are different.

//===================================================

// Object
// Objects are single instances of their own definitions. You can think of them as singletons of their own classes.



object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

val newId: Int = IdFactory.create()
println(newId) // 1
val newerId: Int = IdFactory.create()
println(newerId) // 2

//===================================================

// Traits are abstract data types containing certain fields and methods.
// In Scala inheritance, a class can only extend one other class, but it can extend multiple traits.

trait GreeterTrait {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}

class DefaultGreeter extends GreeterTrait

class CustomizableGreeter(prefix: String, postfix: String) extends GreeterTrait {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val greeterDef = new DefaultGreeter()
greeterDef.greet("Scala developer") // Hello, Scala developer!

val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer") // How are you, Scala developer?

//======================================

class Point1(var x: Int = 0, var y: Int = 0)

val origin = new Point1  // x and y are both set to 0
val point1 = new Point1(1)
println(point1.x)  // prints 1
val point2 = new Point1(y = 2)
println(point2.y)  // prints 2


//========================================

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification


def showNotification(notification: Notification): String = {
  notification match {
    case Email(sender, title, _) =>
      s"You got an email from $sender with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
    case VoiceRecording(name, link) =>
      s"You received a Voice Recording from $name! Click the link to hear it: $link"
  }
}
val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

println(showNotification(someVoiceRecording))  // prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123

//==============================================

// The class Circle has a member area which is specific to each instance,
// and the singleton object Circle has a method calculateArea which is
// available to every instance.

import scala.math._

case class Circle(radius: Double) {
  import Circle._
  def area: Double = calculateArea(radius)
}

object Circle {
  def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}

val circle1 = Circle(5.0)

circle1.area

//================================================

// Companion class-object usage as static methods

class EmailCls(val username: String, val domainName: String)

object EmailCls {
  def fromString(emailString: String): Option[EmailCls] = {
    emailString.split('@') match {
      case Array(a, b) => Some(new EmailCls(a, b))
      case _ => None
    }
  }
}

val scalaCenterEmail = EmailCls.fromString("scala.center@epfl.ch")
scalaCenterEmail match {
  case Some(email) => println(
    s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """.stripMargin)
  case None => println("Error: could not parse email")
}






