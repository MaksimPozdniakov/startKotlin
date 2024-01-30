package main.kotlin.homeWorks.hw2.task.domain

data class Person(
    val name: String,
    val phones: MutableList<String?>,
    val emails: MutableList<String?>
) {

    // Новая реализация
    // Вторичный конструктор, принимает флаг, указывающий тип контактных данных
    constructor(name: String, contact: MutableList<String?>, contactType: String) : this(
        name,
        phones = if (contactType == "phone") contact else mutableListOf(),
        emails = if (contactType == "email") contact else mutableListOf()
    )

    override fun toString(): String {
        return buildString {
            append(name)

            if (phones.isNotEmpty()) {
                append(", Phone: $phones")
            }
            if (emails.isNotEmpty()) {
                append(", Email: $emails")
            }
        }
    }
}


    // Старая реализация
    // Вторичный конструктор
//    constructor(name: String, contact: MutableList<String?>, isPhone: Boolean) :
//            this(
//                name,
//                phone = if (isPhone) contact else "",
//                email = if (isPhone) "" else contact
//            )
//
//    override fun toString(): String {
//        return buildString {
//            append(name)
//
//            if (phone.isNotEmpty()) {
//                append(", Phone: $phone")
//            }
//            if (email.isNotEmpty()) {
//                append(", Email: $email")
//            }
//        }
//    }
//}
