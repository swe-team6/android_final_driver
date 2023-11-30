package com.example.vms_swe.task

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Driver
import com.example.domain.model.Route
import com.example.domain.use_cases.GetAllDriverUseCase
import kotlinx.coroutines.launch

class TaskStatusChangePageViewModel(
    private val getAllDriverUseCase: GetAllDriverUseCase
): ViewModel() {

    private val _drivers = mutableStateListOf<Driver>()
    private val _driverMap = mutableStateMapOf<Long, Driver>()
    private val _driverMapRoutes = mutableStateMapOf<Long, List<Route>>()

    private val _routesMap = mutableStateMapOf<Long, Route>()
    val routesMap: SnapshotStateMap<Long, Route> = _routesMap

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> get() = _isLoading

    init {
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            try {
                val drivers = getAllDriverUseCase().filterNotNull()
                _drivers.addAll(drivers)

                drivers.forEach{
                    //getDriverById(it.userID)
                    _driverMap[it.userID] =it
                    getRoutesFromDriver(it.userID)
                }

                _isLoading.value = false
            } catch (e: Exception){
                Log.e("testbackviewmodel", "Error is fetching data ${e.message}")
                _isLoading.value= false
            }
        }
    }
    private fun getRoutesFromDriver(driverID: Long){
        viewModelScope.launch {
            val routes = getAllDriverUseCase.getRoutes(driverID)
            _driverMapRoutes[driverID] = routes

            routes.forEach{
                _routesMap[it.routeID] = it
            }
        }
    }

    fun updateStatus(routeId:Long, newStatus: String){
        viewModelScope.launch {
            try{
                when(newStatus){
                    "start" -> getAllDriverUseCase.startRoute(routeId)
                    "finish" -> getAllDriverUseCase.finishRoute(routeId)
                }

                val updated = _routesMap[routeId]
                if(updated != null){
                    _routesMap[routeId] = updated
                }


            } catch (e: Exception){
                Log.e("TaskStatusChagne", "${e.message}")
            }
        }
    }
}