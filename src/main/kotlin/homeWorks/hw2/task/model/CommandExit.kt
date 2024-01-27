package main.kotlin.homeWorks.hw2.task.model

class CommandExit(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command exit")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }
}