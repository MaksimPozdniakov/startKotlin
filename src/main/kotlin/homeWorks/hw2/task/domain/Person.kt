package main.kotlin.homeWorks.hw2.task.domain

data class Person(
    val name: String,
    val phone: String,
    val email: String
) {

    // Вторичный конструктор
    constructor(name: String, contact: String, isPhone: Boolean) :
            this(
                name,
                phone = if (isPhone) contact else "",
                email = if (isPhone) "" else contact
            )

    override fun toString(): String {
        return "$name, $phone, $email"
    }
}
