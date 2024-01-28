package main.kotlin.homeWorks.hw2.task.model

import kotlin.system.exitProcess

class CommandExit(validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        println("Command exit")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        return (validation.checkPhoneNumber(numberPhone) && validation.checkEmail(email))
    }

    fun exitMethod() {
        exitProcess(0)
    }
}