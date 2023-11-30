package com.example.data.network.response

import com.google.gson.annotations.SerializedName


data class GetAllDriverCarResponse(
    @SerializedName("CarID")
    val carID: Int,
    @SerializedName("licensePlate")
    val licensePlate: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("capacity")
    val capacity: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("pictureUrl")
    val pictureUrl: String,
    @SerializedName("mileage")
    val mileage: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("mileageInterval")
    val mileageInterval: Int,
    @SerializedName("timeInterval")
    val timeInterval: Int,
   /* @SerializedName("maintenanceJson")
    val maintenanceJson: String,*/
    @SerializedName("usageDescription")
    val usageDescription: String
)
