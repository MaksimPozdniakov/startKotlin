package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandAddPhone(private val list: MutableList<Person>, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        addPhone()
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        // TODO придумать как использовать это в проверке (сейчас проверка осуществляется напрямую)
        return validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email)
    }

    private fun addPhone() {
        print("Укажите id контакта, который нужно отредактировать: ")
        val num = readln().toInt()
        print("Добавить номер телефона: ")
        val newPhoneNumber = readln()
        if (validation.checkPhoneNumber(newPhoneNumber)) list[num-1].phones.add(newPhoneNumber)
        else println("Введенные данные некорректны!")
    }
}

