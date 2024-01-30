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
            "name" -> {
                findName(searchString)
            }
            "phone" -> {
                findPhone(searchString)
            }
            "email" -> {
                findEmail(searchString)
            }
        }
        return null
    }

    private fun findName(searchString : String) : Person? {
        for (person in list) {
//            if (searchString == person.name) {
//                return person
//            }
            return person
        }
        return null
    }
    private fun findPhone(searchString : String) : Person? {
        for (person in list) {
            val phones = person.phones
            for (i in phones) {
                if (i == searchString) {
                    return person
                }
            }
        }
        return null
    }

    private fun findEmail(searchString : String) : Person? {
        for (person in list) {
            val emails = person.phones
            for (i in emails) {
                if (i == searchString) {
                    return person
                }
            }
        }
        return null
    }
}