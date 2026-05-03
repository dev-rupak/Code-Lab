fun main(){
    val finishedHomework = true
    if (finishedHomework) {
        println("Can go to the cinema")
    } else {
        println("Cannot go to the cinema")
    }

    val i = 1 // or 5
    if (i < 3) {
        println("Smaller")
    } else {
        println("Bigger")
    }

    // val haveSomeExtraMoney = true
    // val tip: Double =
    //     if (haveSomeExtraMoney) {
    //         10.0
    //     } else {
    //         0.0
    //     }
    // println(tip)

    // val haveSomeExtraMoney = true
    // val tip: Double =
    //     if (haveSomeExtraMoney) {
    //         println("Here you go") // Here you go
    //         1.0 // this value is ignored, because it is not the last one
    //         5.0 // this value is ignored, because it is not the last one
    //         10.0
    //     } else {
    //         println("Sorry, I am broke")
    //         0.0
    //     }
    // println(tip) // 10.0

    val haveSomeExtraMoney = true
    val tip: Double = if (haveSomeExtraMoney) 10.0 else 0.0
    println(tip) // 10.0

    println("Is it going to rain?")
    val probability = 70
    if (probability <= 40) {
        println("Unlikely")
    } else if (probability <= 80) {
        println("Likely")
    } else if (probability < 100) {
        println("Yes")
    } else {
        println("What?")
    }

}