package com.example.data.network.response

import com.google.gson.annotations.SerializedName

data class GetAllDriverUserResponse (
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("middleName")
    val middleName: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("govID")
    val govID: Long,
    @SerializedName("email")
    val email: String,
    @SerializedName("pictureUrl")
    val pictureUrl: String
)