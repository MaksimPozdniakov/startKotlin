package main.kotlin.homeWorks.hw2.task.model
class CommandRemove(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command remove")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }
}