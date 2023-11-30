package com.example.data.network.response


import com.google.gson.annotations.SerializedName

data class GetRoutesFromDriverResponse(
    @SerializedName("dateCreated")
    val dateCreated: String,
    @SerializedName("departurePoint")
    val departurePoint: String,
    @SerializedName("destinationPoint")
    val destinationPoint: String,
    @SerializedName("gmapsData")
    val gmapsData: String,
    @SerializedName("routeID")
    val routeID: Long,
    @SerializedName("status")
    val status: String,
    @SerializedName("task")
    val task: String
)