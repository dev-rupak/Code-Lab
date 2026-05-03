fun main(){

    var weekday = "Sunday"
    var hour = 21

    val isOpen = when(weekday){
        "Monday" -> (hour >= 8 && hour <= 12)
        "Tuesday" -> hour in 8..18
        "Wednesday" -> hour in 8..18
        "Thursday" -> hour in 8..18
        "Friday" -> hour in 8..21
        "Saturday" -> hour in 9..16
        "Sunday" -> hour in 8..16
        else -> false
    }

    if(isOpen) println("Little Lemon cafeteria is open now") 
    else println("Little Lemon cafeteria is closed now")
}