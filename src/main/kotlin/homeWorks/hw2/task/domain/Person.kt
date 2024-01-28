package main.kotlin.homeWorks.hw2.task.domain

data class Person(
    val name: String,
    val phone: String,
    val email: String
) {
    override fun toString(): String {
        return "$name, $phone, $email"
    }
}
