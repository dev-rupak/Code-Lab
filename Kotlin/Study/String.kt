fun main(){
    val myChar: Char = 'a'
    val myString = """Hello
This is a String. 
It is on multiple lines."""

    val age = 70 
    val myString2 = "My age is $age"

    val myChar2: Char = 'a'
    val myString3 = myChar2.toString()

    val myString4 = "Hello"
    val myLongStrong = myString4 + " World"

    val myString5 = "Hello"
    val myStringLength = myString5.length 

    val myString6 = "Hello"
    val startsWithHel = myString6.startsWith("Hel")

    val myString7 = "Hello"
    val endsWithLo = myString7.endsWith("lo")

    val myString8 = "Hello"
    val firstChar = myString8.first()

    val myString9 = "Hello"
    val lastChar = myString9.last()

    val myString10 = "Hello"
    val equalsHello = myString10.equals("Hello")

    val myString11 = "Hello"
    val myUpperString = myString11.uppercase()

    val myString12 = "Hello"
    val myLowerString = myString12.lowercase()

    val myString13 = "Hello"
    val myString14 = myString13.substring(0, 2)

    println(myChar)
    println(myString)
    println(myString2)
    println(myString3)

    println(myLongStrong)
    println(myStringLength)
    println(startsWithHel)
    println(endsWithLo)
    println(firstChar)
    println(lastChar)
    println(equalsHello)
    println(myUpperString)
    println(myLowerString)
    println(myString14)
    
}
