package com.example.domain.model

data class Chat (
    val chatID: Long,
    val lastUpdated: String,
    val messages: List<Message>,
    val user: ChatUser
)