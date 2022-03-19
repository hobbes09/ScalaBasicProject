/*
Reference : https://stackoverflow.com/questions/2529184/difference-between-method-and-function-in-scala
TBD
 */

def f: String = {
  val g = () => { return "test" }
  g()
  "not this"
}

println(f)

def f2: String = {
  def g(): String = { return "test2" }
  g()
  "is this"
}

println(f2)

//=======================================

/*
Eta Expansion :: https://stackoverflow.com/questions/39445018/what-is-the-eta-expansion-in-scala
 */

//========================================

// ANONYMOUS FUNCTION

// Creating anonymous functions
// with multiple parameters Assign
// anonymous functions to variables
var myfc1 = (str1:String, str2:String) => str1 + str2

// An anonymous function is created
// using _ wildcard instead of
// variable name because str1 and
// str2 variable appear only once
var myfc2 = (_:String) + (_:String)

// Here, the variable invoke like a function call
println(myfc1("Geeks", "12Geeks"))
println(myfc2("Geeks", "forGeeks"))

//================================================

// CURRYING OF FUNCTIONS

// Ref : https://www.youtube.com/watch?v=YEudoVTR02o

def add(x:Int, y:Int) = x+y

def addCurried(x:Int) = (y:Int) => x+y

def addCurried2(x:Int) (y:Int) = x+y


println(add(20,30))
println(addCurried(20)(40))

val sum40 = addCurried(40)
println(sum40(12))

val sum50 = addCurried2(50)_
println(sum50(100))

//====================================================

// ANONYMOUS FUNCTION

var myfun1 = () => {"Welcome to GeeksforGeeks...!!"}
println(myfun1())

// A function which contain anonymous
// function as a parameter
def myfunction(fun:(String, String)=> String) =
{
  fun("Dog", "Cat")
}

// Explicit type declaration of anonymous
// function in another function
val f1 = myfunction((str1: String,
                     str2: String) => str1 + str2)

// Shorthand declaration using wildcard
val f21 = myfunction(_ + _)
println(f1)
println(f21)

//==================================================

// Partially Applied functions
// Ref :: https://www.geeksforgeeks.org/scala-partially-applied-functions/

val multiply = (a: Int, b: Int, c: Int) => a * b * c

// less arguments passed
val partialMultiple = multiply(1, 2, _: Int)

println(partialMultiple(10)) // 20

def Mul(x: Double, y: Double): Double =
{
  x * y
}

// Not applying any argument
val partialMulFunc = Mul _

// Displays Multiplication
println(partialMulFunc(9, 8))

// Currying approach can be utilized in Partially
// applied functions to transmit a function with
// multiple arguments into multiple functions,
// where each function takes only one argument.

def div(x: Double, y: Double): Double =
{
  x / y
}

// applying currying approach
val partialDiv = (div _).curried

// Displays division
println(partialDiv(72)(9))
