package com.example.vms_swe.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Driver
import com.example.domain.use_cases.GetAllDriverUseCase
import kotlinx.coroutines.launch

class TestBackViewModule(
    private val getAllDriverUseCase: GetAllDriverUseCase
): ViewModel() {

    private val _drivers = mutableStateListOf<Driver>()
    val drivers: SnapshotStateList<Driver> = _drivers

    private val _driverMap = mutableStateMapOf<Long, Driver>()
    val driverMap: SnapshotStateMap<Long, Driver> = _driverMap

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
                }

                _isLoading.value = false
            } catch (e: Exception){
                Log.e("testbackviewmodel", "Error is fetching data ${e.message}")
                _isLoading.value= false
            }
        }
    }

   /* private fun getDriverById(driverID: Long){
        viewModelScope.launch {
            val driverById = getAllDriverUseCase(driverID)
            if(driverById != null){
                _driverMap[driverID] = driverById
            }
        }

    }*/
}