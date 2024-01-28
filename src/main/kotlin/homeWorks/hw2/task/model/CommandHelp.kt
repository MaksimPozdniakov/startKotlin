package main.kotlin.homeWorks.hw2.task.model

class CommandHelp(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command show")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    fun helpMethod() {
        val rules: String =
                    "\tprint - показывает все содержимое телефонной книге\n" +
                    "\tadd - добавляет новую запись в телефонную книгу (пример: add Имя Номер телефона Email)\n" +
                    "\tremove - удаляет выбранную запись из телефонной книги (пример: remove индекс записи)\n" +
                    "\thelp - выводит подсказку с командами\n" +
                    "\texit - закрывает телефонную книгу и закрывает программу"

        println(rules)
    }
}