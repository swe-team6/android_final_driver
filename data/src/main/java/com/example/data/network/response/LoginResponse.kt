package com.example.data.network.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("address")
    val address: String,
    @SerializedName("chatID")
    val chatID: Long,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("govID")
    val govID: Long,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("middleName")
    val middleName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("pictureUrl")
    val pictureUrl: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("userID")
    val userID: Long
)