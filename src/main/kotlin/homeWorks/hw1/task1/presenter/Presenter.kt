package main.kotlin.homeWorks.hw1.task1.presenter

import main.kotlin.homeWorks.hw1.task1.domain.Note
import main.kotlin.homeWorks.hw1.task1.model.Model

class Presenter {
    private val model = Model()

    fun addNewNote(newNote: Note) {
        model.addNewNote(newNote)
    }

    fun removeNote(id: Int) {
        model.removeNote(id)
    }

    fun printPhoneBook() {
        model.printPhoneBook()
    }

    fun consoleUI(consoleString: String) {
        model.consoleUI(consoleString)
    }
}