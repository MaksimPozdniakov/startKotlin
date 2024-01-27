package main.kotlin.homeWorks.hw2.task.model

class Model {
    val validation = Validation()

    private val commands: MutableList<SealedCommand> = mutableListOf()

    fun readCommand(): Command? {
        val consoleString = readlnOrNull()
        val stringArray = consoleString?.split(" ")?.toTypedArray()
        return when (stringArray?.get(0)) {
            "add" -> return CommandAdd(validation)
            "remove" -> return CommandRemove(validation)
            "print" -> return CommandPrint(validation)
            "exit" -> return CommandExit(validation)
            "help" -> return CommandHelp(validation)
            "show" -> return CommandShow(validation)
            else -> null
        }
    }










    private fun fillListCommands() {
        commands.add(CommandRemove(validation))
        commands.add(CommandAdd(validation))
        commands.add(CommandPrint(validation))
        commands.add(CommandExit(validation))
        commands.add(CommandHelp(validation))
        commands.add(CommandShow(validation))
    }

    private fun handleCommand(command: SealedCommand) {
        when (command) {
            is CommandRemove -> command.execute()
            is CommandAdd -> command.execute()
            is CommandPrint -> command.execute()
            is CommandExit -> command.execute()
            is CommandHelp -> command.execute()
            is CommandShow -> command.execute()
        }
    }

    fun showAllCommands() {
        fillListCommands()
        for (i in commands) {
            handleCommand(i)
        }
    }

}