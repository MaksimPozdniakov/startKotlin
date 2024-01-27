package main.kotlin.homeWorks.hw2.task.model

class CommandShow(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command show")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }
}