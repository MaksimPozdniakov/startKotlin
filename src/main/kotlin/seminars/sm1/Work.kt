package main.kotlin.seminars.sm1

//fun createOutputString(name: String, age: Int = 42, isStudent: Boolean? = null) =
//    "${if (isStudent == true) "Student" else ""} $name has age of $age"

//for (a in args) {} // итерация по аргументам

// Задача со звездочкой от преподавателя
fun main(args:Array<String>) {
    if (args.size < 3) return

    val a = args[0].toInt()
    val b = args[1].toInt()
    val c = args[2].toInt()

    for (i in 0..<b) {
        printStarsLine(a,c,i)
    }
    for (i in b downTo 0) {
        printStarsLine(a,c,i)
    }
}

fun printStarsLine(a:Int, c:Int, i:Int) {
    for (j in 1..i*c+a) {
        print('*')
    }
    println()
}