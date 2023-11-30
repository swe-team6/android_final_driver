package com.example.data.network.mapper

import com.example.data.network.response.GetAllDriverUserResponse
import com.example.domain.model.User

class UserMapper {
    fun fromRemoteToDomain(userResponse: GetAllDriverUserResponse): User {
        return User(
            phoneNumber = userResponse.phoneNumber,
            address = userResponse.address,
            lastName = userResponse.lastName,
            middleName = userResponse.middleName,
            firstName = userResponse.firstName,
            //password = userResponse.password,
            govID = userResponse.govID,
            email = userResponse.email,
            pictureUrl = userResponse.pictureUrl
        )
    }
}