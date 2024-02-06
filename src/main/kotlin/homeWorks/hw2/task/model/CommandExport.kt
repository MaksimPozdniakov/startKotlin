package main.kotlin.homeWorks.hw2.task.model

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonNull
import com.google.gson.JsonObject
import main.kotlin.homeWorks.hw2.task.domain.Person
import java.io.File

class CommandExport(private val list: MutableList<Person>, validation: Validation) : SealedCommand(validation) {
    override fun execute() {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val personsJson = serializePersons()
        val prettyJsonString = gson.toJson(personsJson)
        val pathToFile = "src/main/kotlin/homeWorks/hw2/task/phoneBook/phoneBook.json"
        File(pathToFile).writeText(prettyJsonString)
    }

    override fun isValid(numberPhone: String, email: String): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Используем DSL чтобы создать JsonObject
     */
    fun jsonObject(block: JsonObject.() -> Unit): JsonObject = JsonObject().apply(block)

    /**
     * Используем DSL чтобы создать JsonArray
     */
    private fun jsonArray(elements: List<Any?>): JsonArray = JsonArray().apply {
        elements.forEach {
            when (it) {
                is Number -> add(it)
                is String -> add(it)
                is Boolean -> add(it)
                is JsonObject -> add(it)
                is JsonArray -> add(it)
                null -> add(JsonNull.INSTANCE)
                else -> throw IllegalArgumentException("Unsupported type: ${it?.javaClass}")
            }
        }
    }

    private fun serializePersons(): JsonArray {
        return JsonArray().apply {
            list.forEach { person ->
                add(jsonObject {
                    addProperty("name", person.name)
                    add("phones", jsonArray(person.phones))
                    add("emails", jsonArray(person.emails))
                })
            }
        }
    }

}