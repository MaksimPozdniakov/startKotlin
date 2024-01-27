package main.kotlin.homeWorks.hw2.task.model
class CommandPrint(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command print")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }
}