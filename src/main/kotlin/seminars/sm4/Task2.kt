package main.kotlin.seminars.sm4

class NotIntArgException(message: String?): RuntimeException(message)

fun sum(num1: String, num2: String): Int {
    try {
        return num1.toInt() + num2.toInt()
    } catch (ex: NumberFormatException) {
        throw NotIntArgException(ex.message)
    }
}

fun main(vararg args: String) {
    try {
        val num1 = args[0]
        val num2 = args[1]
        val res = sum(num1, num2)
        println(res)
    }
    catch (ex: IndexOutOfBoundsException) {
        println(ex.message)
    }
    catch (ex: NotIntArgException) {
        println(ex.message)
    }

}