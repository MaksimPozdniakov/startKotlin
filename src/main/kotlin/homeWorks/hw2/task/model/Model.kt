package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class Model {
    val validation = Validation()

    private val list: MutableList<Person> = mutableListOf()

    fun startMethod() {
        print("Введите команду (Для выходы введите команду exit): ")
        val consoleString = readlnOrNull()
        if (consoleString != null) {
            val typeClass = readCommand(consoleString)
            if (typeClass != null) {
                classWork(typeClass, consoleString)
            }
        }
    }

    private fun readCommand(consoleString: String): Command? {
        val stringArray = consoleString.split(" ").toTypedArray()
        return when (stringArray[0]) {
            "add" -> return CommandAdd(validation)
            "print" -> return CommandPrint(validation)
            "remove" -> return CommandRemove(validation)
            "exit" -> return CommandExit(validation)
            "help" -> return CommandHelp(validation)
            "show" -> return CommandShow(validation)
            else -> null
        }
    }

    private fun classWork(typeClass: Command, consoleString: String) {
        when (typeClass) {
            is CommandAdd -> list.add(typeClass.addNewNote(consoleString))
            is CommandPrint -> typeClass.printList(list)
            is CommandRemove -> typeClass.removeNote(list)
            is CommandExit -> typeClass.exitMethod()
            is CommandHelp -> typeClass.helpMethod()
            is CommandShow -> typeClass.showLastPerson()
        }
    }
}