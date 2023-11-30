package com.example.domain.model


data class Driver(
    val car: Car = Car(),
    val drivingLicense: String = "",
    val jobsDone: Int = 0,
    val totalDistance: Int = 0,
    val totalTime: Int = 0,
    val user: User = User(),
    val userID: Long = 0
)
