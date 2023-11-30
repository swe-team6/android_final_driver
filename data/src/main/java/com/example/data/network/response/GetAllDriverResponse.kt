package com.example.data.network.response


import com.google.gson.annotations.SerializedName

data class GetAllDriverResponse(
    @SerializedName("car")
    val car: GetAllDriverCarResponse,
    @SerializedName("drivingLicense")
    val drivingLicense: String,
    @SerializedName("jobsDone")
    val jobsDone: Int,
    @SerializedName("totalDistance")
    val totalDistance: Int,
    @SerializedName("totalTime")
    val totalTime: Int,
    @SerializedName("user")
    val user: GetAllDriverUserResponse,
    @SerializedName("userID")
    val userID: Long
)