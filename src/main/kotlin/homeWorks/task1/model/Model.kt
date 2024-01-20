package main.kotlin.homeWorks.task1.model

import main.kotlin.homeWorks.task1.domain.Note

class Model {
    private val phoneBook: MutableList<Note> = mutableListOf()

    fun addNewNote(newNote: Note) {
        phoneBook.add(newNote)
    }

    fun removeNote(id:Int) {
        phoneBook.removeAt(id - 1)
    }

    fun print() {
        for (item in phoneBook) {
            println(item)
        }
    }
}

