package com.sng.homework6.model

data class Contact(val type: ContactType, val description: String, val img: Int, val url: String)

enum class ContactType {
    ADD,
    MAIL,
    SOCIAL,
    PHONE_NUMBER
}