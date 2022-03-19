// A Scala program to illustrate
// Getting the value of members of a class

// Name of the class is Student
class Student
{
  // Class variables
  var student_name: String= " "
  var student_age: Int= 0

  // Getter
  private var student_rollno= 0

  // Class method
  def set_rollno(x: Int){
    student_rollno= x
  }
  def get_rollno(): Int ={
    return student_rollno
  }

}

// Class object
var obj = new Student()
obj.student_name= "Yash"
obj.student_age= 22
obj.set_rollno(59)

// Directly getting the value of variable
println("Student Name: " + obj.student_name)

// Directly getting the value of variable
println("Student Age: " + obj.student_age)

// Through method calling
println("Student Rollno: " + obj.get_rollno)


//==============================================

class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}

val point1 = new Point
point1.x = 99
point1.y = 101 // prints the warning