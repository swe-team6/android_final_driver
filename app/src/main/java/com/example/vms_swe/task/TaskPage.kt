package com.example.vms_swe.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.vms_swe.R
import com.example.vms_swe.models.TaskModel
import org.koin.androidx.compose.get

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TaskPage(viewModel: TaskPageViewModel=get(), navController: NavController, userID: Long = 1) {
    val driver = viewModel.driverMap[userID]
    val routes = viewModel.driverMapRoutes[userID]

    if((driver != null) && (routes != null)){
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    GlideImage(
                        model = driver.user.pictureUrl,
                        contentDescription = "profile avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(65.dp)
                    )
                    Text(
                        text = "${driver.user.firstName} ${driver.user.lastName}",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight(600)
                        ),
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }

                var clickedText by remember { mutableStateOf<String?>("Completed") }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ClickableText(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = if (clickedText == "Completed") Color(0xFFFFE27C) else Color.Black,
                                    // textDecoration = if (clickedText == "Completed") TextDecoration.None else TextDecoration.Underline
                                    fontSize = 20.sp
                                )
                            ) {
                                append("Completed")
                            }
                        },
                        onClick = {
                            clickedText = "Completed"
                        },
                        modifier = Modifier.clickable { }
                    )

                    ClickableText(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = if (clickedText == "Started") Color(0xFFFFE27C) else Color.Black,
                                    fontSize = 20.sp
                                )
                            ) {
                                append("Started")
                            }
                        },
                        onClick = {
                            clickedText = "Started"
                        },
                        modifier = Modifier.clickable { }
                    )

                    ClickableText(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = if (clickedText == "Uncompleted") Color(0xFFFFE27C) else Color.Black,
                                    //textDecoration = if (clickedText == "Uncompleted") TextDecoration.None else TextDecoration.Underline
                                    fontSize = 20.sp
                                )
                            ) {
                                append("Uncompleted")
                            }
                        },
                        onClick = {
                            clickedText = "Uncompleted"
                        },
                        modifier = Modifier.clickable { }
                    )
                }

                LazyColumn {

                    itemsIndexed(routes.filter { route ->
                        when (clickedText) {
                            "Completed" -> route.status == "COMPLETED"
                            "Uncompleted" -> route.status == "ACCEPTED" || route.status == "ASSIGNED"
                            "Started" -> route.status == "STARTED"
                            else -> true
                        }
                    }) { index, route ->
                        TaskModel(route = route, navController)
                    }

                }
            }
        }
    }
}
