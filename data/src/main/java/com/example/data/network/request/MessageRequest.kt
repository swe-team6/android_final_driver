package com.example.data.network.request

import com.google.gson.annotations.SerializedName

data class MessageRequest (
    @SerializedName("chatID")
    val chatID: Long,
    @SerializedName("text")
    val text: String,
    @SerializedName("authorIsAdmin")
    val authorIsAdmin: Boolean

)