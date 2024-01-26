package main.kotlin.seminars.sm2.task1

/*
    Написать реализацию класса Holder и интерфейса
    ValueChangeListener, таких, чтобы программа компилировалась, и при
    выполнении функции main на экран было выведено "New value is 1".
 */

// Интерфейс, который определяет метод обработки нового значения
interface ValueChangeListener {
    fun onNewValue(number: Int)
}

// Класс Holder
class Holder private constructor(number: Int) {
    // Свойство для хранения числа
    var number: Int = number
        set(value) {
            // При установке нового значения вызываем метод onNewValue у слушателя (если установлен)
            listener?.onNewValue(value)
            field = value // field это специальная переменная, которая доступна только внутри settera,
                          // она обозначает значение поля
        }
    // Ссылка на объект, реализующий интерфейс ValueChangeListener
    var listener: ValueChangeListener? = null

    // Статический метод для создания экземпляра Holder с указанным значением по умолчанию
    companion object {
        const val DEFAULT_NUMBER = -1

        // Метод createHolder возвращает новый экземпляр Holder с установленным значением по умолчанию
        fun createHolder(defaultNumber: Int): Holder {
            return Holder(DEFAULT_NUMBER)
        }
    }
}

fun main() {
    // Создаем экземпляр Holder с установленным значением по умолчанию
    val holder = Holder.createHolder(Holder.DEFAULT_NUMBER)

    // Устанавливаем значение свойства number в 9
    holder.number = 9

    // Устанавливаем слушателя, который реализует интерфейс ValueChangeListener
    holder.listener = object : ValueChangeListener {
        override fun onNewValue(number: Int) {
            // При изменении значения вызываем этот метод, который выводит сообщение в консоль
            println("New value is $number")
        }
    }

    // Устанавливаем новое значение свойства number, вызывая срабатывание слушателя и вывод в консоль
    holder.number = 1
}

