package com.example.vms_swe.profile

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.model.Driver
import com.example.vms_swe.R
import org.koin.androidx.compose.get

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProfilePage(viewModel: ProfilePageViewModel = get(), userID: Long = 1) {

    val driver = viewModel.driverMap[userID]
    val routes = viewModel.driverMapRoutes[userID]

    if (driver != null && routes != null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GlideImage(
                model = driver.user.pictureUrl,
                contentDescription = "avatar of user",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .size(180.dp),
                alignment = Alignment.Center
            )
            Text(
                text = "${driver.user.firstName} ${driver.user.lastName}",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center
                ),
            )
            DriverInformation(driver)
            CarInformation(driver)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val completedRoutes = routes.count { it.status == "COMPLETED" }
                val assignedRoutes = routes.count { it.status == "ASSIGNED" }
                CircularGraph(completedRoutes = completedRoutes, assignedRoutes = assignedRoutes)

                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxSize(),
                    //contentAlignment = Alignment.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LegendItem(color = Color(0xFFF68E12), label = "Completed")
                    Spacer(modifier = Modifier.size(10.dp))
                    LegendItem(color = Color(0xFFB18652), label = "Assigned")
                }
            }

        }
    }
}


@Composable
fun DriverInformation(driver: Driver) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Email: ",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                        textAlign = TextAlign.Start
                    ),
                )
                Text(
                    text = " ${driver.user.email}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    )
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Phone Number: ",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                        textAlign = TextAlign.Start
                    ),
                )
                Text(
                    text = " ${driver.user.phoneNumber}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    )
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Government ID: ",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                        textAlign = TextAlign.Start
                    ),
                )
                Text(
                    text = " ${driver.user.govID}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarInformation(driver: Driver) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GlideImage(
                model = driver.car.pictureUrl,
                contentDescription = "car photo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(120.dp)
            )

            Column(
                modifier = Modifier.height(120.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Car Model: ",
                        modifier = Modifier,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Gray,
                            textAlign = TextAlign.Start
                        ),
                    )
                    Text(
                        text = " ${driver.car.model}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                        )
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Driver License: ",
                        modifier = Modifier,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Gray,
                            textAlign = TextAlign.Start
                        ),
                    )
                    Text(
                        text = " ${driver.drivingLicense}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                        )
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Total distance: ",
                        modifier = Modifier,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Gray,
                            textAlign = TextAlign.Start
                        ),
                    )
                    Text(
                        text = " ${driver.totalDistance}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                        )
                    )
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Total time: ",
                        modifier = Modifier,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Gray,
                            textAlign = TextAlign.Start
                        ),
                    )
                    Text(
                        text = " ${driver.totalTime}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                        )
                    )
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Tasks completed: ",
                        modifier = Modifier,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Gray,
                            textAlign = TextAlign.Start
                        ),
                    )
                    Text(
                        text = " ${driver.jobsDone}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun CircularGraph(
    completedRoutes: Int,
    assignedRoutes: Int,
    modifier: Modifier = Modifier,
) {
    val totalRoutes = completedRoutes + assignedRoutes

    val completedPercentage = if (totalRoutes > 0) completedRoutes.toFloat() / totalRoutes else 0f
    val assignedPercentage = if (totalRoutes > 0) assignedRoutes.toFloat() / totalRoutes else 0f

    val entries = listOf(
        PieChartEntry(color = Color(0xFFF68E12), percentage = completedPercentage),
        PieChartEntry(color = Color(0xFFB18652), percentage = assignedPercentage)
    )

    PieChart(entries = entries, modifier = modifier)
}

data class PieChartEntry(val color: Color, val percentage: Float)

@Composable
fun PieChart(
    entries: List<PieChartEntry>,
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier
            .aspectRatio(1f)
            .padding(8.dp)
    ) {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = size.minDimension / 2 - 16

        val startAngles = calculateStartAngles(entries)

        entries.forEachIndexed { index, entry ->
            drawArc(
                color = entry.color,
                startAngle = startAngles[index],
                sweepAngle = entry.percentage * 360f,
                useCenter = true,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
            )
        }
    }
}

fun calculateStartAngles(entries: List<PieChartEntry>): List<Float> {
    var totalPercentage = 0f
    return entries.map { entry ->
        val startAngle = totalPercentage * 360
        totalPercentage += entry.percentage
        startAngle
    }
}

@Composable
fun LegendItem(color: Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Canvas(
            modifier = Modifier
                .size(20.dp)
                .background(color, CircleShape)
        ) {
            // Draw nothing here, just a colored circle for the legend
        }
        Text(text = label)
    }
}

@Preview
@Composable
fun previewProfilePage() {
   // ProfilePage()
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
////        val completedRoutes = routes.count{it.status == "COMPLETED"}
////        val assignedRoutes = routes.count{it.status == "ASSIGNED"}
//        CircularGraph(completedRoutes = 5, assignedRoutes = 10 )
//
//        Box(
//            modifier = Modifier
//                .weight(1f)
//                .padding(start = 16.dp)
//        ) {
//            LegendItem(color = Color(0xFFF68E12), label = "Completed")
//            LegendItem(color = Color(0xFFB18652), label = "Assigned")
//        }
//    }

}