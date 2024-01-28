package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandAdd(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command add")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }



    fun addNewNote(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        return if (isValid(stringArray[2], stringArray[3])) Person(stringArray[1], stringArray[2], stringArray[3])
        else null
    }
}