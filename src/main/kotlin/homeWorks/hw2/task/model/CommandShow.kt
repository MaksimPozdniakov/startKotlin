package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandShow(private val lastPerson: Person?, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        showLastPerson()
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    private fun showLastPerson() {
        if (lastPerson != null) {
            println("\tПоследнее добавленное значение: $lastPerson")
        } else {
            println("\tNot initialized")
        }
    }
}