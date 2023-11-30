package com.example.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DriverEntity(
    val car: CarEntity = CarEntity(),
    val drivingLicense: String = "",
    val jobsDone: Int = 0,
    val totalDistance: Int = 0,
    val totalTime: Int = 0,
    val user: UserEntity = UserEntity(),
    @PrimaryKey
    val userID: Int = 0
)
