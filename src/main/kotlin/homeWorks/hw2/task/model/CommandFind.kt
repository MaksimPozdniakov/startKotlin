package main.kotlin.homeWorks.hw2.task.model

import main.kotlin.homeWorks.hw2.task.domain.Person

class CommandFind(private val list: MutableList<Person>, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        TODO("Not yet implemented")
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        TODO("Not yet implemented")
    }

    fun findInformation(searchParameter: String, searchString : String) : Person? {
        when (searchParameter) {
            "name" -> findName(searchString)
            "phone" -> findPhone(searchString)
            "email" -> findEmail(searchString)
        }
        return null
    }

    private fun findName(searchString : String) {
        for (person in list) {
            if (searchString == person.name) {
                println(person)
            }
        }
    }

    private fun findPhone(searchString : String) {
        for (person in list) {
            for (i in person.phones) {
                if (i == searchString) {
                    println(person)
                }
            }
        }
    }

    private fun findEmail(searchString : String) {
        for (person in list) {
            for (i in person.emails) {
                if (i == searchString) {
                    println(person)
                }
            }
        }
    }
}