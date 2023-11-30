package com.example.data.network.mapper

import com.example.data.network.response.GetRoutesFromDriverResponse
import com.example.domain.model.Route

class RouteMapper {

    fun fromRemoteToDomain(routeResponse: GetRoutesFromDriverResponse): Route {
        return Route(
            dateCreated = routeResponse.dateCreated,
            departurePoint = routeResponse.departurePoint,
            destinationPoint = routeResponse.destinationPoint,
            gmapsData = routeResponse.gmapsData,
            routeID = routeResponse.routeID,
            status = routeResponse.status,
            task = routeResponse.task
        )
    }
}