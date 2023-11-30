package com.example.domain.repository

import com.example.domain.model.Chat
import com.example.domain.model.Driver
import com.example.domain.model.LoginUser
import com.example.domain.model.Message
import com.example.domain.model.Route

interface DriverRepository {
    suspend fun getAllDrivers(): List<Driver?>
    suspend fun getDriver(driverID: Long): Driver?
    suspend fun getRoutesFromDriver(driverID: Long): List<Route>
    suspend fun startRoute(routeID: Long)
    suspend fun finishRoute(routeID: Long)
    suspend fun getChat(userID: Long): Chat
    suspend fun login(email: String, password: String): LoginUser
    suspend fun sendMessage(chatID: Long, text: String, authorIsAdmin: Boolean): Message
}