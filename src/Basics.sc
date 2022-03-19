// Val vs var in scala
val x = 1 + 1
println(x) // 2
// x = 3  --- This gives error as this cannot be reassigned

var y = 1 + 1
y = 3 // This compiles because "x" is declared with the "var" keyword.
println(y * y) // 9

// Function
val addOne = (x: Int) => x + 1
println(addOne(1)) // 2

// Function
val add = (x: Int, y: Int) => x + y
println(add(1, 2)) // 3

// Method
def addMethod(x: Int, y: Int): Int = x + y
println(addMethod(1, 3)) // 4

// Method - A method can take multiple parameter lists:
def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(1, 2)(3)) // 9


val planets =
  List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
    ("Mars", 227.9), ("Jupiter", 778.3))
planets.foreach{
  case ("Earth", distance) =>
    println(s"Our planet is $distance million kilometers from the sun")
  case _ =>
}

//=======================================

// applying range method
val x1 = Range(0, 10, 2)

// applying until method
val y1 = 0 until 10 by 2

x1.foreach(p=>{println("==> " + p)})

// Displays true if both the
// methods are equivalent
println(x1 == y1)

//============================================

// applying range method
val x2 = Range(1, 8)

// Including upper bound
val y2 = x2.inclusive

// applying 'to' method
val z2 = 1 to 8

// Displays true if both the
// methods are equal
println(y2 == z2)

//=============================================
