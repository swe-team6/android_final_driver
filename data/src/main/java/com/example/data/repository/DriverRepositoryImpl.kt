package com.example.data.repository

import com.example.data.network.api.PlaceholderService
import com.example.data.network.mapper.ChatMapper
import com.example.data.network.mapper.DriverMapper
import com.example.data.network.mapper.LoginMapper
import com.example.data.network.mapper.MessageMapper
import com.example.data.network.mapper.RouteMapper
import com.example.data.network.request.LoginRequest
import com.example.data.network.request.MessageRequest
import com.example.domain.model.Chat
import com.example.domain.model.Driver
import com.example.domain.model.LoginUser
import com.example.domain.model.Message
import com.example.domain.model.Route
import com.example.domain.repository.DriverRepository

class DriverRepositoryImpl(
    private val placeholderService: PlaceholderService,
    private val driverMapper: DriverMapper,
    private val routeMapper: RouteMapper,
    private val chatMapper: ChatMapper,
    private val loginMapper: LoginMapper,
    private val messageMapper: MessageMapper
): DriverRepository {
    override suspend fun getAllDrivers(): List<Driver?> {
        val driverResponse = placeholderService.getDrivers()
        return driverResponse.map { driverMapper.fromRemoteToDomain(it) }
    }

    override suspend fun getDriver(driverID: Long): Driver? {
        val driverResponse = placeholderService.getDriver(driverID)
        return driverMapper.fromRemoteToDomain(driverResponse)
    }

    override suspend fun getRoutesFromDriver(driverID: Long): List<Route> {
        val routeResponse = placeholderService.getRoutesFromDriver(driverID)
        return routeResponse.map{ routeMapper.fromRemoteToDomain(it) }
    }

    override suspend fun startRoute(routeID: Long) {
        placeholderService.startRoute(routeID)
    }

    override suspend fun finishRoute(routeID: Long) {
        placeholderService.finishRoute(routeID)
    }

    override suspend fun getChat(userID: Long): Chat {
        val chatResponse = placeholderService.getChat(userID)
        return chatMapper.fromRemoteToDomain(chatResponse)
    }

    override suspend fun login(email: String, password: String): LoginUser {
        val loginRequest = LoginRequest(email, password)
        val loginResponse = placeholderService.login(loginRequest)
        return loginMapper.fromRemoteToDomain(loginResponse)
    }

    override suspend fun sendMessage(chatID: Long, text: String, authorIsAdmin: Boolean): Message {
        val messageRequest = MessageRequest(chatID, text, authorIsAdmin)
        val messageResponse = placeholderService.sendMessage(messageRequest)
        return messageMapper.fromRemoteToDomain(messageResponse)
    }
}