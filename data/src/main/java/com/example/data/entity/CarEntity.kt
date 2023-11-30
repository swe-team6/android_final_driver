package com.example.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CarEntity (
    @PrimaryKey
    val carID: Int = 0,
    val licensePlate: String = "",
    val model: String = "",
    val year: Int = 0,
    val capacity: Int = 0,
    val type: String = "",
    val pictureUrl: String = "",
    val mileage: Int = 0,
    val status: String = "",
    val mileageInterval: Int = 0,
    val timeInterval: Int = 0,
    val maintenanceJson: String = "",
    val usageDescription: String = ""
)
