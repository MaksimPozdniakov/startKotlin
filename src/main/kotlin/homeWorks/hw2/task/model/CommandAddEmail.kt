package main.kotlin.homeWorks.hw2.task.model

class CommandAddEmail(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        TODO("Not yet implemented")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        TODO("Not yet implemented")
    }
}