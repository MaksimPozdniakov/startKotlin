package main.kotlin.homeWorks.task1.model

class Validation {

    fun checkName(name: String?): Boolean {
        return name != null
    }

    fun checkPhoneNumber(phoneNumber: String?): Boolean {
        if (phoneNumber != null) {
            val phoneNumberPattern = """^\+?\d+$"""
            return phoneNumber.matches(phoneNumberPattern.toRegex())
        }
        return false
    }

    fun checkEmail(email: String?): Boolean {
        if (email != null) {
            val emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
            return email.matches(emailPattern.toRegex())
        }
        return false
    }
}