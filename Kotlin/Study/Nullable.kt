fun main(){
    val List : StudentList = StudentList()
    List.studentEntry(223, "John", 140.0)
    List.studentEntry(548, "Mark", 120.0)
    List.studentEntry(342, "Naitali", 150.0)
    List.studentEntry(781, "Sara", 130.0)

    print("Enter your Id: ")
    val Id : Int = readln().toInt()
    List.getStudentById(Id)

    // print("Enter your Name: ")
    // val Name : String = readln()
    // List.getStudentByName(Name)
}

class StudentList{
    val StudentList : MutableList<Student> = mutableListOf()

    fun studentEntry(Id : Int, StudentName : String, Grade : Double){
        StudentList.add(Student(Id, StudentName, Grade))
    }

    fun getStudentById(TargetId : Int) : Student?{
        val IdExists = StudentList.find { it.Id == TargetId}
        if(IdExists != null){
            println("Student Id : ${IdExists.Id}")
            println("Student Name : ${IdExists.StudentName}")
            println("Student Grade : ${IdExists.Grade}")
            return IdExists
        }   else    {
            println("$TargetId not found in List.")
            return null
        }
    }

    fun getStudentByName(TargetName : String) : Student?{
        val IdExists = StudentList.find { Student -> Student.StudentName == TargetName}
        if(IdExists != null){
            println("Student Id : ${IdExists.Id}")
            println("Student Name : ${IdExists.StudentName}")
            println("Student Grade : ${IdExists.Grade}")
            return IdExists
        }   else    {
            println("$TargetName not found in List.")
            return null
        }
    }
}

data class Student(val Id : Int, val StudentName : String, var Grade : Double){
    
}