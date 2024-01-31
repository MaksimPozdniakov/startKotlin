package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandAddEmail(private val list: MutableList<Person>, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        addEmail()
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        // TODO придумать как использовать это в проверке (сейчас проверка осуществляется напрямую)
        return validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email)
    }

    private fun addEmail() {
        print("Укажите id контакта, который нужно отредактировать: ")
        val num = readln().toInt()
        print("Добавьте новый Email: ")
        val newEmail = readln()
        if (validation.checkEmail(newEmail)) list[num - 1].emails.add(newEmail)
        else println("Введенные данные некорректны!")
    }
}