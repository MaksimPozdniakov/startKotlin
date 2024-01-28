package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandAdd(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command add")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        // TODO придумать как использовать это в проверке
        return validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email)
    }

    fun addNewNote(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        return if (stringArray[1] == "phone" && validation.checkPhoneNumber(stringArray[3])) {
            addNewNoteOnlyPhone(consoleString)
        } else if (stringArray[1] == "email" && validation.checkEmail(stringArray[3])) {
            addNewNoteOnlyEmail(consoleString)
        } else if (stringArray[1] == "all" && validation.checkPhoneNumber(stringArray[3]) && validation.checkEmail(stringArray[4])) {
            addNewNoteOnlyAll(consoleString)
        } else {
            return null
        }
    }

    private fun addNewNoteOnlyAll(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        return Person(stringArray[2], stringArray[3], stringArray[4])
    }

    private fun addNewNoteOnlyPhone(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        return Person(stringArray[2], stringArray[3], true)
    }

    private fun addNewNoteOnlyEmail(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        return Person(stringArray[2], stringArray[3], false)
    }
}
