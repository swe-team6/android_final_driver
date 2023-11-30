package com.example.data.network.mapper

import com.example.data.network.response.LoginResponse
import com.example.domain.model.LoginUser

class LoginMapper {
    fun fromRemoteToDomain(loginResponse: LoginResponse): LoginUser{
        return LoginUser(
            userID = loginResponse.userID,
            role = loginResponse.role
        )
    }
}