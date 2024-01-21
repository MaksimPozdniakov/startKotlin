package main.kotlin.homeWorks.task1.view

import main.kotlin.homeWorks.task1.domain.Note
import main.kotlin.homeWorks.task1.model.Validation
import main.kotlin.homeWorks.task1.presenter.Presenter
import kotlin.system.exitProcess

class View {

    private val presenter = Presenter()
    private val validation = Validation()
    private val consoleUI = ConsoleUI()

    fun printMenu() {
        while (true) {
            println()
            val menu: String = """
            1. Вывести на экран телефонную книгу
            2. Добавить новую запись
            3. Удалить запись
            4. Закрыть телефонную книгу
            5. Отключить графический интерфейс и перейти в консоль
        """.trimIndent()
            println(menu)
            print("Сделайте выбор: ")
            val userChoice = readlnOrNull()

            when (userChoice) {
                1.toString() -> {
                    println()
                    presenter.printPhoneBook()
                }
                2.toString() -> addNewNote()
                3.toString() -> removeNote()
                4.toString() -> exitProcess(0)
                5.toString() -> consoleUI()
                else -> println("Что-то не то!")
            }
        }
    }

    private fun addNewNote() {
        print("Введите имя: ")
        val name = readlnOrNull()

        print("Введите номер: ")
        val phoneNumber = readlnOrNull()

        print("Введите Email: ")
        val email = readlnOrNull()

        if (
            validation.checkEmail(email) &&
            validation.checkPhoneNumber(phoneNumber) &&
            validation.checkName(name)) {

            presenter.addNewNote(Note(name, phoneNumber, email))
        } else {
            if (!validation.checkEmail(email)) {
                println("Email введен неверно!")
            }

            if (!validation.checkPhoneNumber(phoneNumber)) {
                println("Номер телефона введен неверно!")
            }

            if (!validation.checkName(name)) {
                println("Имя введено неверно!")
            }
        }
    }

    private fun removeNote() {
        presenter.printPhoneBook()
        print("Укажите номер записи, которую нужно удалить: ")
        val userChoice = readln()
        try {
            val number = userChoice?.toInt()

            if (number == null) {
                println("Что-то вы не то ввели!")
            } else {
                presenter.removeNote(number)
            }
        } catch (e: NumberFormatException) {
            println("Что-то вы не то ввели!")
        }
    }

    private fun consoleUI() {
        consoleUI.consoleUI()
        while (true) {
            print("Введите команду с параметрами: ")
            val consoleString = readln()
            presenter.consoleUI(consoleString)
        }
    }
}