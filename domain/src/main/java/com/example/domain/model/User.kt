package com.example.domain.model

data class User (
    val phoneNumber: String = "",
    val address: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val firstName: String = "",
    //val password: String?,
    val govID: Long = 0,
    val email: String = "",
    val pictureUrl: String = ""
)
