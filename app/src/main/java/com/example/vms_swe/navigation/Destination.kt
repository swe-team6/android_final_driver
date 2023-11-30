package com.example.vms_swe.navigation

object Destination {
    const val Profile = "profile"
    const val Tasks = "task"
    const val Chat = "chat"
    const val Login = "login"

    object UserLogin {
        const val route = "login"
    }

    object UserProfile {
        const val route ="profile/{userID}"
        const val userIDArg ="userID"

        fun createRoute(userID: Long): String{
            return "profile/$userID"
        }
    }

    object UserTasks{
        const val route = "task/{userID}"
        const val userIDArg = "userID"

        fun createRoute(userID: Long): String{
            return "task/$userID"
        }
    }

    object UserChat {
        const val route = "chat/{userID}"
        const val userIdArg = "userID"

        fun createRoute(userID: Long): String {
            return "chat/$userID"
        }
    }

    object TaskStatusChange{
        const val route = "taskStatusChange/{taskID}"
        const val taskIdArg = "taskID"

        fun createRoute(taskID:Long): String{
            return "taskStatusChange/$taskID"
        }
    }

}