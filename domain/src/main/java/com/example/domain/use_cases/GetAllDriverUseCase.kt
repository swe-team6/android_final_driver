package com.example.domain.use_cases

import com.example.domain.model.Chat
import com.example.domain.model.Driver
import com.example.domain.model.LoginUser
import com.example.domain.model.Message
import com.example.domain.model.Route
import com.example.domain.repository.DriverRepository

class GetAllDriverUseCase(private val repository: DriverRepository) {
    suspend operator fun invoke(): List<Driver?>{
        return repository.getAllDrivers()
    }

    suspend operator fun invoke(driverID: Long): Driver?{
        return repository.getDriver(driverID)
    }

    suspend fun getRoutes(driverID: Long): List<Route>{
        return repository.getRoutesFromDriver(driverID)
    }

    suspend fun startRoute(routeID:Long){
        repository.startRoute(routeID)
    }

    suspend fun finishRoute(routeID: Long){
        repository.finishRoute(routeID)
    }

    suspend fun getChat(userID: Long): Chat {
        return repository.getChat(userID)
    }

    suspend fun login(email: String, password: String): LoginUser{
        return repository.login(email, password)
    }

    suspend fun sendMessage(chatID: Long, text: String, authorIsAdmin: Boolean): Message{
        return repository.sendMessage(chatID, text, authorIsAdmin)
    }
}