package main.kotlin.seminars.sm1

/*
Написать программу, выводящую на экран фигуру из звёздочек.
    a – количество звёздочек на первой строчке;
    b – количество строк от первой до центральной и от
    центральной до последней;
    c – количество звёздочек, на которое увеличивается
    последовательность с каждой строкой.
 */

fun main() {
    val a = 5
    val b = 2
    val c = 2

    printv2(a, b, c)
}

fun printv2(a: Int, b: Int, c: Int) {
    val countLens = b + b + 1 // общее кол-во строк
    val middle = countLens / 2 + 1 // нашли середину
    val range1 = 0 until middle // диапазон верха с центром
    val range2 = middle until countLens // диапазон низа без центра

    var linesToMiddle = a
    for (i in range1) {
        print(linesToMiddle)
        linesToMiddle += c
    }

    var linesAfterMiddle = linesToMiddle - c
    for (i in range2) {
        linesAfterMiddle -= c
        print(linesAfterMiddle)
    }
}

fun print(a: Int) {
    var i = 0
    println()
    while (i < a) {
        print("*")
        i++
    }
}








