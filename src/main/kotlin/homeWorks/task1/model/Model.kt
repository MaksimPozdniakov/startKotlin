package main.kotlin.homeWorks.task1.model

import main.kotlin.homeWorks.task1.domain.Note
import main.kotlin.homeWorks.task1.view.ConsoleUI
import kotlin.system.exitProcess

class Model {
    private val phoneBook: MutableList<Note> = mutableListOf()

    private val validation = Validation()
    private  val consoleUI = ConsoleUI()

    fun addNewNote(newNote: Note) {
        phoneBook.add(newNote)
    }

    fun removeNote(id:Int) {
        phoneBook.removeAt(id - 1)
    }

    fun printPhoneBook() {
        for (item in phoneBook) {
            println(item)
        }
    }

    fun consoleUI(consoleString: String) {
        val stringArray = consoleString.split(" ").toTypedArray()

        when (stringArray[0]) {
            "print" -> {
                printPhoneBook()
            }
            "add" -> {
                if (validation.checkEmail(stringArray[3])
                    && validation.checkPhoneNumber(stringArray[2])
                    && validation.checkName(stringArray[1])) {

                    addNewNote(Note(stringArray[1], stringArray[2], stringArray[3]))
                }  else {
                    if (!validation.checkEmail(stringArray[3])) {
                        println("Email введен неверно!")
                    }

                    if (!validation.checkPhoneNumber(stringArray[2])) {
                        println("Номер телефона введен неверно!")
                    }

                    if (!validation.checkName(stringArray[1])) {
                        println("Имя введено неверно!")
                    }
                }
            }
            "remove" -> {
                removeNote(stringArray[1].toInt())
            }
            "help" -> {
                println(consoleUI.rules)
            }
            "exit" -> exitProcess(0)
        }
    }
}

