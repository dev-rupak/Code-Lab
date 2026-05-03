fun main(){
    var score = 0;
    println(score)
    score += getPoints(10, 1)
    println(score)
    score += getPoints(20, 2)
    println(score)
    score += getPoints(-10, 1)
    println(score)
    score += getPoints(5, 3)
    println(score)
    score += getPoints(-15, 2)
    println(score)
}

fun getPoints(base : Int, boost : Int) : Int = base * boost

fun triangleArea(width: Double, height: Double): Double {
    return width * height / 2
}

fun isoscelesTriangle(width: Int) {
    ascendingTriangle(width - 1)
    descendingTriangle(width)
}

fun descendingTriangle(height: Int) {
    for (i in height downTo 1) {
        printStar(i)
    }
}

fun ascendingTriangle(height: Int){
    for(i in 1 .. height){
        printStar(i)
    }
}

fun printStar(height: Int){
    for(i in 1 .. height){
        print("*")
    }
    println()
}