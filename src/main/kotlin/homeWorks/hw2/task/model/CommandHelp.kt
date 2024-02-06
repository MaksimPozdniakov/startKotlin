package main.kotlin.homeWorks.hw2.task.model

class CommandHelp(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        //println("Command show")
        helpMethod()
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    fun helpMethod() {
        val rules: String =
                    "\tprint - показывает все содержимое в телефонной книге\n" +
                    "\tadd - добавляет новую запись в телефонную книгу (пример:\n" +
                            "\t\tadd phone Имя Номер телефона\n" +
                            "\t\tadd email Имя email\n" +
                            "\t\tadd all Имя Номер телефона email)\n" +
                    "\tremove - удаляет выбранную запись из телефонной книги (пример: remove индекс записи)\n" +
                    "\thelp - выводит подсказку с командами\n" +
                    "\tshow - показывает последнее добавление в книгу\n" +
                            "\tfind - осуществляет поиск по телефонной книге\n" +
                            "\taddPhone - осуществляет добавление номера телефона к имеющемуся контакту\n" +
                            "\taddEmail - осуществляет добавление номера Email к имеющемуся контакту\n" +
                            "\texport - записывает данные в файл" +
                    "\texit - закрывает телефонную книгу и закрывает программу"

        println(rules)
    }
}