package com.example.data.network.response


import com.google.gson.annotations.SerializedName

data class GetChatResponse(
    @SerializedName("chatID")
    val chatID: Long,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("messages")
    val messages: List<GetChatMessageResponse>,
    @SerializedName("user")
    val user: GetChatUserResponse
)