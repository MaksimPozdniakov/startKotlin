package main.kotlin.homeWorks.hw1.task1.domain

class Note(
    val name: String?,
    val phoneNumber: String?,
    val email: String?
) {
    override fun toString(): String {
        return "$name, $phoneNumber, $email"
    }
}
