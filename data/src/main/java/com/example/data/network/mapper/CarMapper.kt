package com.example.data.network.mapper

import com.example.data.network.response.GetAllDriverCarResponse
import com.example.domain.model.Car

class CarMapper {

    fun fromRemoteToDomain(carResponse: GetAllDriverCarResponse?): Car? {
        return carResponse?.let {
            Car(
                carID = carResponse.carID,
                licensePlate = it.licensePlate,
                model = carResponse.model,
                year = carResponse.year,
                capacity = carResponse.capacity,
                type = carResponse.type,
                pictureUrl = carResponse.pictureUrl,
                mileage = carResponse.mileage,
                mileageInterval = carResponse.mileageInterval,
                status = carResponse.status,
                timeInterval = carResponse.timeInterval,
                //maintenanceJson = carResponse.maintenanceJson,
                usageDescription = carResponse.usageDescription
            )
        }
    }
}
