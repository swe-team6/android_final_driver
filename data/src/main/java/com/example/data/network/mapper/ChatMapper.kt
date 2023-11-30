package com.example.data.network.mapper

import androidx.room.PrimaryKey
import com.example.data.network.response.GetChatResponse
import com.example.domain.model.Chat

class ChatMapper(
    private val messageMapper: MessageMapper,
    private val chatUserMapper: ChatUserMapper
) {
    fun fromRemoteToDomain(chatResponse: GetChatResponse): Chat{
        return Chat(
            chatID = chatResponse.chatID,
            lastUpdated = chatResponse.lastUpdated,
            messages = chatResponse.messages.map { messageMapper.fromRemoteToDomain(it) },
            user = chatUserMapper.fromRemoteToDomain(chatResponse.user)
        )
    }
}