package com.example.vms_swe.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.model.LoginUser
import com.example.domain.use_cases.GetAllDriverUseCase

class AuthPageViewModel(
    private val allDriverUseCase: GetAllDriverUseCase
): ViewModel() {

    suspend fun login(password: String, email: String): LoginUser {
//        try {
//                // Call the login use case with the provided credentials
//                val result = allDriverUseCase.login(email, password)
//                Log.e("login", "${result.userID}")
//                return result
//                // Handle the result as needed (e.g., update LiveData or State variables)
//            } catch (e: Exception) {
//                Log.e("login", "${e.message}")
//                // Handle login failure (e.g., show an error message)
//            }
        return allDriverUseCase.login(email, password)
    }

}