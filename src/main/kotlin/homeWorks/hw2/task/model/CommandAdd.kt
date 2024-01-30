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

    // Новая реализация
    fun addNewNote(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        return if (stringArray[1] == "all") {
            addNewNoteOnlyAll(consoleString)
        } else if (stringArray[1] == "phone") {
            addNewNoteOnlyPhone(consoleString)
        }else if (stringArray[1] == "email") {
            addNewNoteOnlyEmail(consoleString)
        } else {
            return null
        }
    }

    private fun addNewNoteOnlyAll(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        val phones: MutableList<String?> = stringArray[3].split(",").toMutableList()
        val emails: MutableList<String?> = stringArray[4].split(",").toMutableList()
        return Person(stringArray[2], phones, emails)
    }

    private fun addNewNoteOnlyPhone(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        val phones: MutableList<String?> = stringArray[3].split(",").toMutableList()
        return Person(stringArray[2], phones, "phone")
    }

    private fun addNewNoteOnlyEmail(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        val emails: MutableList<String?> = stringArray[3].split(",").toMutableList()
        return Person(stringArray[2], emails, "email")
    }
}
