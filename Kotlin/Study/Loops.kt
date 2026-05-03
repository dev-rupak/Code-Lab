fun main(){
    for(i in 1 until 5){
        var Space = 5 - i;
        for(star in 1..i){
            while(Space > 0){
                print(" ")
                Space--
            }
            print("*")
        }
        println()
    }

    for(i in 5 downTo 1){
        var Space = 5 - i;
        for(star in 1..i){
            while(Space > 0){
                print(" ")
                Space--
            }
            print("*")
        }
        println()
    }
}