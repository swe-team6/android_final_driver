package com.example.data.network.response


import com.google.gson.annotations.SerializedName

data class GetChatMessageResponse(
    @SerializedName("authorIsAdmin")
    val authorIsAdmin: Boolean,
    @SerializedName("chatID")
    val chatID: Long,
    @SerializedName("isRead")
    val isRead: Boolean,
    @SerializedName("messageID")
    val messageID: Long,
    @SerializedName("sentTime")
    val sentTime: String,
    @SerializedName("text")
    val text: String
)