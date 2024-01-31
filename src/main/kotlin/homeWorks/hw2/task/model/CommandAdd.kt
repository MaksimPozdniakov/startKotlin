package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandAdd(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command add")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        // TODO придумать как использовать это в проверке (сейчас проверка осуществляется напрямую)
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
        return if (helpMethodValidationPhones(phones) && helpMethodValidationEmails(emails))
            Person(stringArray[2], phones, emails)
        else null
    }

    private fun addNewNoteOnlyPhone(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        val phones: MutableList<String?> = stringArray[3].split(",").toMutableList()
        return if (helpMethodValidationPhones(phones))
            Person(stringArray[2], phones, "phone")
        else null
    }

    private fun addNewNoteOnlyEmail(consoleString: String): Person? {
        val stringArray = consoleString.split(" ").toTypedArray()
        val emails: MutableList<String?> = stringArray[3].split(",").toMutableList()
        return if (helpMethodValidationEmails(emails))
            Person(stringArray[2], emails, "email")
        else null
    }

    private fun helpMethodValidationPhones(phones: MutableList<String?>): Boolean {
        for (phone in phones) {
            if (phone != null && !validation.checkPhoneNumber(phone)) {
                return false
            }
        }
        return true
    }

    private fun helpMethodValidationEmails(emails: MutableList<String?>): Boolean {
        for (email in emails) {
            if (email != null && !validation.checkEmail(email)) {
                return false
            }
        }
        return true
    }
}
