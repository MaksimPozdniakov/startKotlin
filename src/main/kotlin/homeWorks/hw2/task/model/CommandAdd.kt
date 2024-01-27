package main.kotlin.homeWorks.hw2.task.model
class CommandAdd(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command add")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }
}