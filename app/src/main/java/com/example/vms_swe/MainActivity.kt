package com.example.vms_swe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vms_swe.auth.AuthPage
import com.example.vms_swe.chat.ChatPage
import com.example.vms_swe.profile.ProfilePage
import com.example.vms_swe.task.TaskPage
import com.example.vms_swe.task.TaskStatusChangePage
import com.example.vms_swe.ui.theme.VMS_sweTheme
import org.koin.core.scope.ScopeID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VMS_sweTheme {
                BottomNavWithScaffold()
            }

        }
    }
}


@Composable
fun BottomNavWithScaffold() {
    val navController = rememberNavController()
    val currentRoute = currentRoute(navController)
    Scaffold(
        bottomBar = {
            if (currentRoute !in listOf(Screen.Login.route)) {
                BottomNavigation(
                    backgroundColor = Color(0xFFFBEFC2)
                ) {
                    BottomNavigationItem(
                        selected = navController.currentDestination?.hierarchy?.any { it.route == Screen.Profile.route } == true,
                        onClick = {
                            navController.navigate(Screen.Profile.route)
                        },
                        icon = {
                            Icon(Icons.Default.AccountCircle, contentDescription = null)
                        },
                        label = {
                            Text("Profile")
                        }
                    )

                    BottomNavigationItem(
                        selected = navController.currentDestination?.hierarchy?.any { it.route == Screen.Task.route } == true,
                        onClick = {
                            navController.navigate(Screen.Task.route)
                        },
                        icon = {
                            Icon(Icons.Default.Check, contentDescription = null)
                        },
                        label = {
                            Text("Task")
                        }
                    )

                    BottomNavigationItem(
                        selected = navController.currentDestination?.hierarchy?.any { it.route == Screen.Task.route } == true,
                        onClick = { navController.navigate(Screen.Chat.route) },
                        icon = { Icon(Icons.Default.Phone, contentDescription = null) },
                        label = { androidx.compose.material3.Text("Chat") })

                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = Screen.Profile.route,
            //    arguments = listOf(navArgument("userID") { type = NavType.LongType })
            ) {
              //  val userID = it.arguments?.getLong("userID")
                ProfilePage()
//                if(userID!=null){
//                }
            }
            composable(route = Screen.Task.route,
               // arguments = listOf(navArgument("userID") { type = NavType.LongType })
            ) {
                //val userID = it.arguments?.getLong("userID")
                TaskPage(navController = navController)
//                if(userID!= null){
//                }
            }
            composable(
                route = Screen.TaskStatusChange.route,
                arguments = listOf(navArgument("taskId") { type = NavType.LongType })
            ) {
                val taskId = it.arguments?.getLong("taskId")
                TaskStatusChangePage(taskId, navController = navController)
            }
            composable(
                route = Screen.Chat.route,
               // arguments = listOf(navArgument("taskId") { type = NavType.LongType })
                ) {
                //val userID = it.arguments?.getLong("userID")
                ChatPage()
//                if(userID!= null){
//                }
            }
            composable(Screen.Login.route) {
                AuthPage(navController = navController)
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Profile : Screen("profile/{userID}")
    object Task : Screen("task/{userID}")
    object TaskStatusChange : Screen("taskStatusChange/{taskId}")
    object Chat : Screen("chat/{userID}")
    object Login : Screen("login")
}

@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}