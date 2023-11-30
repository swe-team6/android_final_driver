package com.example.domain.model

data class Message(
    val authorIsAdmin: Boolean,
    val chatID: Long,
    val isRead: Boolean,
    val messageID: Long,
    val sentTime: String,
    val text: String
)