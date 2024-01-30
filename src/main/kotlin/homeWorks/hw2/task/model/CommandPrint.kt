package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandPrint(private val list: MutableList<Person>, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        printList()
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    private fun printList() {
        list.forEachIndexed { index, person ->
            println("\t${index + 1}. $person")
        }
    }
}