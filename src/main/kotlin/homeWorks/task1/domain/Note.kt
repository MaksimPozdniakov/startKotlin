package main.kotlin.homeWorks.task1.domain

class Note(
    val name: String?,
    val phoneNumber: String?,
    val email: String?
) {
    override fun toString(): String {
        return "$name, $phoneNumber, $email"
    }
}
