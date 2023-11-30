package com.example.data.network.mapper

import com.example.data.network.response.GetAllDriverUserResponse
import com.example.data.network.response.GetChatUserResponse
import com.example.domain.model.ChatUser
import com.example.domain.model.User

class ChatUserMapper {
    fun fromRemoteToDomain(userResponse: GetChatUserResponse): ChatUser {
        return ChatUser(
            phoneNumber = userResponse.phoneNumber,
            address = userResponse.address,
            lastName = userResponse.lastName,
            middleName = userResponse.middleName,
            firstName = userResponse.firstName,
            govID = userResponse.govID,
            email = userResponse.email,
            pictureUrl = userResponse.pictureUrl,
            chatID = userResponse.chatID,
            role = userResponse.role,
            userID = userResponse.userID
        )
    }
}