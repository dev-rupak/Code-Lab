fun main(){

    // println("Is it going to rain?")
    // val probability = 70
    // when {
    //     probability < 40 -> {
    //         println("Unlikely")
    //     }
    //     probability <= 80 -> {
    //         println("Likely")
    //     }
    //     probability < 100 -> {
    //         println("Yes")
    //     }
    //     else -> {
    //         println("What?")
    //     }
    // }

    // println("Is it going to rain?")
    // val probability = 70
    // when {
    //     probability < 40 -> println("Unlikely")
    //     probability <= 80 -> println("Likely")
    //     probability < 100 -> println("Yes")
    //     else -> println("What?")
    // }

    println("Is it going to rain?")
    val probability = 70
    val text = when {
        probability < 40 -> "Unlikely"
        probability <= 80 -> "Likely"
        probability < 100 -> "Yes"
        else -> "What?"
    }
    println(text)

    val number = 4 // or 2, 3, 4, 5, 6
    when (number) {
        1 -> {
            println("Missed hit")
        }
        2, 3, 4, 5 -> {
            println("Hit with value $number")
        }
        6 -> {
            println("Critical hit")
        }
    }

    val num = 1 // or 2, 3, 4, 5, 6
    val printnum = when (num) {
        1 -> "Missed hit"
        2, 3, 4, 5 -> "Hit with value $num"
        6 -> "Critical hit"
        else -> "Unsupported value"
    }
    println(printnum)

    val hit = 6 // or 2, 3, 4, 5, 6
    val printhit = when (hit) {
        1 -> "Missed hit"
        in 2..5 -> "Hit with value $hit"
        6 -> "Critical hit"
        else -> "Unsupported value"
    }
    println(printhit)

    val something: Any = "ABC" // or 123, 0.1, true
        when (something) {
            is String -> println("This is String")
            is Int -> println("This is Int")
            is Double -> println("This is Double")
            is Boolean -> println("This is Boolean")
        }
    println(something)
}