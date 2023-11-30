package com.example.data.entity

import androidx.room.Entity
@Entity
data class UserEntity (
    val phoneNumber: String = "",
    val address: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val firstName: String = "",
    val password: String = "",
    val govID: Long = 0,
    val email: String = ""
)
