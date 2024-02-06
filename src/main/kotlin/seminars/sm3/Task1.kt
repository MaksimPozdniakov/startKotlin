package main.kotlin.seminars.sm3

data class Entry(
    val city: String,
    val name: String,
    val age: Int
)

val entries = listOf(
    Entry("London", "Liam", 28),
    Entry("Berlin", "Oliver", 24),
    Entry("Madrid", "Oliver", 45),
    Entry("Berlin", "Jerry", 29),
    Entry("London", "Oliver", 19),
    Entry("Madrid", "Kate", 16),
    Entry("Berlin", "Oliver", 34),
    Entry("London", "Kate", 25),
    Entry("Berlin", "Oliver", 23),
    Entry("Milan", "Jerry", 28),
    Entry("Paris", "Charles", 44)
)

fun main() {
    /*
     * При помощи стандартных функций-расширений для работы с коллекциями вывести на экран:
	 * Количество людей в городе London в возрасте от 21 до 30 лет включительно.
	 * Список имён без повторений для города Berlin.
	 * Список городов, в которых есть хотя бы один человек по имени Oliver.
	 */

    val firstTask = entries.count {it.city == "London" && it.age in 21..30}
    println(firstTask)

    val secondTask = entries.filter { it.city == "Berlin"}.map { it.name }.distinct()
    println(secondTask)

    val thirdTAsk = entries.filter { it.name == "Oliver"}.map { it.city }.distinct()
    println(thirdTAsk)
    /* альтернативный вариант последнего решения:
    println( entries.filter { it.name == "Oliver" }.groupBy { it.city }.mapValues { it.value.count() } */
}