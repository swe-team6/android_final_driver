package com.example.data.network.mapper

import com.example.data.network.response.GetChatMessageResponse
import com.example.domain.model.Message

class MessageMapper {
    fun fromRemoteToDomain(messageResponse: GetChatMessageResponse): Message{
        return Message(
            authorIsAdmin = messageResponse.authorIsAdmin,
            chatID = messageResponse.chatID,
            isRead = messageResponse.isRead,
            messageID = messageResponse.messageID,
            sentTime = messageResponse.sentTime,
            text = messageResponse.text
        )
    }
}