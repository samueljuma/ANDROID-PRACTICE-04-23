package com.example.kotlinpractice

fun divide(num1: Int, num2: Int){
    var division = num1 / num2
    var remainder = num1 % num2
    println("division: $division")
    println("remainder: $remainder")
}

fun areaOfACircle(radius: Double){
    val area: Double =22.0/7.0 * radius * radius
    println("Area: $area")
}

fun perimeterOfACircle(radius: Double){
    val perimeter: Double = 2 * 22.0/7.0 * radius
    println("Perimeter: $perimeter")
}
fun swapAWithB(num1: Int, num2: Int){

    var a = num1
    var b = num2
    var temp = a
    a = b
    b = temp

    println("a: $a, b: $b")
}

fun reversedString1 (string: String){
    println(string.reversed())
}

fun reversedString (string: String){
    var reversedString = ""
    for (i in string.length - 1 downTo 0){
        reversedString += string[i]
    }
    println(reversedString)
}

fun multiplyArrays(array1: Array<Int>, array2: Array<Int>): IntArray {
    val resultArray = IntArray(array1.size)
    for (i in array1.indices) {
        resultArray[i] = (array1[i] * array2[i])
    }

    return resultArray
}

fun countEvenAndOdd(myArray: Array<Int>){
    var evenCount = 0
    var oddCount =0
    for (i in myArray){
        if( i % 2 == 0){
           evenCount ++
        }
        else{
            oddCount ++
        }
    }
    println("You have $evenCount Even Numbers and $oddCount odd Numbers")
}

fun whichIsGreater(){
    print("Enter Your First Number: ")
    val firstNumber = readLine()!!.toInt()
    print("Enter Your Second Number: ")
    val secondNumber = readLine()!!.toInt()
    print("Enter Your Third Number: ")
    val thirdNumber = readLine()!!.toInt()

    var greatest = firstNumber

    if (secondNumber > greatest){
        greatest = secondNumber
    }
    if (thirdNumber > greatest){
        greatest = thirdNumber
    }
    println("$greatest is the greatest")
    greatest= maxOf(firstNumber,secondNumber,thirdNumber) // alternative
    println("$greatest is the greatest")
}

fun main(){
//    divide(42,7)
//    areaOfACircle(7.0)
//    perimeterOfACircle(7.0)
//    swapAWithB(4,5)
//    reversedString("!kcuf sa emosewa dna looc si asekew amuj leumaS")
//    reversedString1("!kcuf sa emosewa dna looc si asekew amuj leumaS")
//    var array1 = arrayOf(1,2,3,4)
//    var array2 = arrayOf(1,2,3,4)
//    println(multiplyArrays(array1, array2).contentToString())
//    countEvenAndOdd(array1)
    whichIsGreater()
}


