package main.kotlin.homeWorks.hw2.task
import main.kotlin.homeWorks.hw2.task.model.Model
fun main() {
    print("Введите команду: ")
    logic()
}

fun logic() {
    val model = Model()
    val command = model.readCommand()
    val className = command?.let { it::class.simpleName ?: "Unknown" } ?: "Unknown"
    println("Class name: $className")
}
