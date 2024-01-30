package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandAddPhone(private val list: MutableList<Person>, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        addPhone()
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        TODO("Not yet implemented")
    }

    private fun addPhone() {
        print("Укажите id контакта, который нужно отредактировать: ")
        val num = readln().toInt()
        print("Добавить номер телефона: ")
        val newPhoneNumber = readln()
        list[num-1].phones.add(newPhoneNumber)
    }
}

