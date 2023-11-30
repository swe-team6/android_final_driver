package com.example.vms_swe.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vms_swe.models.FirstCard
import com.example.vms_swe.models.SecondCard
import com.example.vms_swe.models.ThirdCard
import org.koin.androidx.compose.get

@Composable
fun TaskStatusChangePage(taskId: Long?, viewModel: TaskStatusChangePageViewModel = get(), navController: NavController){
    val route = viewModel.routesMap[taskId]
    if(route != null){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFFFF9E5), shape = RoundedCornerShape(size = 8.dp))
                    .padding(top = 16.dp, bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Task: $taskId",
                    modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            FirstCard(route)
            SecondCard(route)
            ThirdCard(route)

            var logText by remember { mutableStateOf("Log: ") }

            Spacer(modifier = Modifier.size(20.dp))
            if(route.status != "COMPLETED"){
                Button(
                    onClick = {
                        logText = "Start"
                        route.routeID?.let { viewModel.updateStatus(it, "start") }
                        navController.navigate("task")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF227A2A))
                ) {
                    Text("Start", color = Color.White)
                }

                Button(
                    onClick = {
                        logText = "Finish"
                        route.routeID?.let { viewModel.updateStatus(it, "finish") }
                       // navController.navigate("task/{taskID}")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFCE1B1B))
                ) {
                    Text("Finish", color = Color.White)
                }
            }

        }
    }
}

