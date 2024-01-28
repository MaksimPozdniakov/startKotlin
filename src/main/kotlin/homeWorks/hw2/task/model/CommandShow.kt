package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandShow(val lastPerson: Person?, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        //println("Command show")
        showLastPerson()
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    fun showLastPerson() {
        if (lastPerson != null) {
            println("\tПоследнее добавленное значение: $lastPerson")
        } else {
            println("\tNot initialized")
        }
    }
}