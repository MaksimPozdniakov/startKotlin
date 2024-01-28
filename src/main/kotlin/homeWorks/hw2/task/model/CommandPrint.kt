package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandPrint(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command print")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    fun printList(list: MutableList<Person>) {
        list.forEach{println("\t${it}")}
    }
}