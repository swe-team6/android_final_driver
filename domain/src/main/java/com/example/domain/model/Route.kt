package com.example.domain.model

data class Route(
    val dateCreated: String?,
    val departurePoint: String?,
    val destinationPoint: String?,
    val gmapsData: String?,
    val routeID: Long,
    val status: String?,
    val task: String?
)