package com.example.data.network.api

import com.example.data.network.request.LoginRequest
import com.example.data.network.request.MessageRequest
import com.example.data.network.response.GetAllDriverResponse
import com.example.data.network.response.GetChatMessageResponse
import com.example.data.network.response.GetChatResponse
import com.example.data.network.response.GetRoutesFromDriverResponse
import com.example.data.network.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PlaceholderService {
    @GET("drivers")
    suspend fun getDrivers(): List<GetAllDriverResponse>

    @GET("drivers/{driverID}")
    suspend fun getDriver(@Path("driverID") driverID: Long): GetAllDriverResponse

    @GET("drivers/{driverID}/routes")
    suspend fun getRoutesFromDriver(@Path("driverID") driverID: Long): List<GetRoutesFromDriverResponse>

    @POST("routes/{routeID}/start")
    suspend fun startRoute(@Path("routeID") routeID: Long)

    @POST("routes/{routeID}/complete")
    suspend fun finishRoute(@Path("routeID") routeID: Long)

    @GET("users/{userID}/chat")
    suspend fun getChat(@Path("userID") userID: Long): GetChatResponse

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("/messages")
    suspend fun sendMessage(@Body messageRequest: MessageRequest): GetChatMessageResponse

}