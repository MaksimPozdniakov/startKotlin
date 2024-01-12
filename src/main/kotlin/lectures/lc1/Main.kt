package main.kotlin.lectures.lc1

//fun main() {
//    val args = arrayOf("23", "42") // так создается массив String
//
//    if (args.size >= 2) {
//        val a = args[0].toIntOrNull()
//        val b = args[1].toIntOrNull()
//        if (a != null && b != null) {
//            val sum = a + b
//            println("sum = $sum")
//            return
//        }
//    }
//    println("Error")
//}

// используем lateinit
lateinit var v: String

fun main(vararg args: String) {

    // используем lateinit
//    v = "str"
//    println(v)

//    task1(*args);
//    task3(*args)

    // работаем с типом данных Any
//    task4(45)
//    task4(45.0)
//    task4(45.0f)
//    task4(45L)
//    task4(null)

    // делаем так, чтобы функция возвращала String
//    task5(task4(45))
//    task5(task4(45.0))
//    task5(task4(45.0f))
//    task5(task4(45L))
//    task5(task4(null))

    // работаем с Boolean
//    task6(true)
//    task6(false)
//    task6(null)

//    task6v2(true)
//    task6v2(false)
//    task6v2(null)

    // работаем с массивами
//    task7()
    task8()


    // проверяем тип переменной
//    val x = 42
//    println("Тип переменной x: ${x::class.simpleName}")

}

fun task1(vararg args: String){
    if (args.size >= 2) {
        val a = args[0].toIntOrNull()
        val b = args[1].toIntOrNull()
        if (a != null && b != null) {
            val sum = a + b
            println("sum = $sum")
            return
        }
    }
    println("Error")
}

fun task2() {
    val a: Double = 34.0 // переменная типа double
    val b: Float = 32.0f // переменная типа float
    val c: Int = 34 // переменная типа int
    val d: Long = 12L // переменная типа long
    val e: Int = d.toInt() // приведение типов к int
}

fun task3(vararg args: String) {
    // работаем со строками
    val email = args[0]
    val parts = email.split('@')
//    for (part in parts) {
//        println(part)
//    }

    println("user = ${parts[0]}, address = ${parts[1]}")
}

fun task4(a: Any?) {
    println(a)
}

fun task5(a: Any?): String {

    // первый вариант записи
    return a?.toString() ?: "null"

    // второй вариант записи
//    return if (a != null) {
//        a.toString()
//    } else {
//        "null"
//    }

    // третий вариант записи
//    if (a != null) {
//        return a.toString()
//    } else {
//        return  "null"
//    }
}

// еще один вариант записи функции из 5-го задания
fun task5v2(a: Any?) = if (a != null) {
    a.toString()
} else {
    "null"
}

// еще один вариант записи функции из 5-го задания
fun task5v3(a: Any?) = a?.toString() ?: "null"

fun task6(a: Boolean?) {
    if (a == true) {
        println("true")
    } else {
        println("false or null")
    }
}

// вариант записи функции из 6-го задания через when
fun task6v2(a: Boolean?) {
    when (a) {
        true -> println("true")
        false -> println("false")
        else -> println("null")
    }
}

fun task7() {
    val array = IntArray(5)
//    array.fill(3)
//    for (el in array) {
//        println(el)
//    }

//    for (i in array.indices) {
//        array[i] = i
//    }
//
//    for (el in array) {
//        println(el)
//    }

    array.fill(3)
    println(array.joinToString())
}

fun task8() {
//    val range = 0..<6
//    for (a in range) {
//        println(a)
//    }

//    val range = 0..<6 step 2
//    for (a in range) {
//        println(a)
//    }

//    val range = 10 downTo 0 step 2
//    for (a in range) {
//        println(a)
//    }
}



