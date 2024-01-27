package main.kotlin.homeWorks.hw2.task.model


sealed class SealedCommand(val validation: Validation) : Command {
    abstract override fun execute()
    abstract fun isValid(numberPhone: String, email: String): Boolean
}