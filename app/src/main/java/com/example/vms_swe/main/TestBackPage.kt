package com.example.vms_swe.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.model.Driver
import org.koin.androidx.compose.get

@Composable
fun TestBackPage(viewModel: TestBackViewModule = get()) {

    val drivers =viewModel.drivers
    val driver = viewModel.driverMap[1]

    if (viewModel.isLoading.value) {
        // Show loading indicator
        CircularProgressIndicator(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp))
    } else {
        // Display the list of drivers
        if (driver!=null){
            DriverItem(driver = driver)
        }
    /*LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(drivers.size) { index ->
                val driver = drivers[index]
                DriverItem(driver)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }*/
    }
}

@Composable
fun DriverItem(driver: Driver) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle item click if needed */ }
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            // Display driver information
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Display driver details such as name, license, etc.
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text(text = "User Id: ${driver.userID}")
                    Text(text = "Name: ${driver.user.firstName}")
                    Text(text = "License: ${driver.drivingLicense}")
                    Text(text = "Jobs Done: ${driver.jobsDone}")
                    Text(text = "Total Distance: ${driver.totalDistance} km")
                    Text(text = "Total Time: ${driver.totalTime} hours")
                }
            }
        }
    }
}
