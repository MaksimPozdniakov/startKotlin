package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandRemove(private val list: MutableList<Person>, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        //println("Command remove")
        removeNote()
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    fun removeNote() {
        print("Какую строку нужно удалить: ")
        val num = readln().toInt()
        list.removeAt(num - 1)
    }
}