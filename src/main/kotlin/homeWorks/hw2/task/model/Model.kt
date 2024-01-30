package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class Model {
    val validation = Validation()
    private val help = CommandHelp(validation)

    private val list: MutableList<Person> = mutableListOf()
    private var lastPerson: Person? = null

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

    // TODO переработать метод, убрать его из Model
    private fun searchParameter(): String {
        print("\tПо какому параметру будем искать?\n" +
                "\t\t'name' по имени\n" +
                "\t\t'phone' по номеру телефона\n" +
                "\t\t'email' по email\n")
        val consoleString = readln()
        return consoleString
    }

    private fun searchString(): String {
        print("Укажите имя, номер телефона или email, в соответствии с выбранным ранее параметром: ")
        val consoleString = readln()
        return consoleString
    }

    private fun readCommand(consoleString: String): Command? {
        val stringArray = consoleString.split(" ").toTypedArray()
        return when (stringArray[0]) {
            "add" -> return CommandAdd(validation)
            "print" -> return CommandPrint(list, validation)
            "remove" -> return CommandRemove(list, validation)
            "exit" -> return CommandExit(validation)
            "help" -> return CommandHelp(validation)
            "show" -> return CommandShow(lastPerson, validation)
            "find" -> return CommandFind(list, validation)
            else -> null
        }
    }

    private fun classWork(typeClass: Command, consoleString: String) {
        when (typeClass) {
            is CommandAdd -> {
                typeClass.addNewNote(consoleString)?.let { list.add(it) }
                lastPerson = typeClass.addNewNote(consoleString)
                if (lastPerson != null) {
                    println("Запись успешно добавлена!")
                } else {
                    println("Введенные данные некорректны!")
                    help.execute()
                }
            }
            is CommandPrint -> typeClass.execute()
            is CommandRemove -> typeClass.execute()
            is CommandExit -> typeClass.execute()
            is CommandHelp -> typeClass.execute()
            is CommandShow -> typeClass.execute()
            is CommandFind -> println(typeClass.findInformation(searchParameter(), searchString()))
        }
    }
}

