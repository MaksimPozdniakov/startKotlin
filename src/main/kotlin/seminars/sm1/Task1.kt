package main.kotlin.seminars.sm1


fun main() {
    println("sumAll = ${sumAll(1, 5, 20)}")
    println("sumAll = ${sumAll()}")
    println("sumAll = ${sumAll(2, 3, 4, 5, 6, 7)}")
    println(createOutputString("Alice"))
    println(createOutputString("Bob", 23))
    println(createOutputString(isStudent = true, name = "Carol", age = 19))
    println(createOutputString("Daniel", 32, isStudent = null))
    println(multiplyBy(null, 4))
    println(multiplyBy(3, 4))
}

fun sumAll(vararg args: Int) {}


fun createOutputString(vararg args: Any){}

fun createOutputString(isStudent: Boolean, name: String, age: Int): String {
    return ""
}

fun createOutputString(name: String, age: Int, isStudent: Boolean?): String {
    return ""
}

fun multiplyBy(vararg args: Any?) {}


