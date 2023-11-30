package com.example.domain.model

data class ChatUser(
    val address: String,
    val chatID: Long,
    val email: String,
    val firstName: String,
    val govID: Long,
    val lastName: String,
    val middleName: String,
    val phoneNumber: String,
    val pictureUrl: String,
    val role: String,
    val userID: Long
)