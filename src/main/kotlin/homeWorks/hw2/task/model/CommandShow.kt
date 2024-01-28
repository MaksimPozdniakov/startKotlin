package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandShow(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command show")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    fun showLastPerson(person: Person) {
        println(person)
    }
}