package com.example.data.network.mapper

import com.example.data.network.response.GetAllDriverResponse
import com.example.domain.model.Driver

class DriverMapper(
    private val carMapper: CarMapper,
    private val userMapper: UserMapper
) {
    fun fromRemoteToDomain(driverResponse: GetAllDriverResponse): Driver?{
        return carMapper.fromRemoteToDomain(driverResponse.car)?.let {
            Driver(
                car = it,
                drivingLicense = driverResponse.drivingLicense,
                jobsDone = driverResponse.jobsDone,
                totalDistance = driverResponse.totalDistance,
                totalTime = driverResponse.totalTime,
                user = userMapper.fromRemoteToDomain(driverResponse.user),
                userID = driverResponse.userID
            )
        }
    }
}