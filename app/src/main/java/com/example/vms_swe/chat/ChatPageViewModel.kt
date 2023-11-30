package com.example.vms_swe.chat

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Chat
import com.example.domain.use_cases.GetAllDriverUseCase
import kotlinx.coroutines.launch

class ChatPageViewModel(
    private val getAllDriverUseCase: GetAllDriverUseCase
): ViewModel() {

    private val _chat = mutableStateOf<Chat?>(null)
    val chat get() = _chat.value

    // Mutable state for loading indicator
    private val _isLoading = mutableStateOf(true)
    val isLoading get() = _isLoading.value

    fun getChat(userID: Long){
        viewModelScope.launch {
            try {

                val chat = getAllDriverUseCase.getChat(userID)
                _chat.value = chat
                _isLoading.value = false

            }catch (e: Exception){
                Log.e("chatViewModel", "Error is fetching data ${e.message}")
                _isLoading.value = true
            }
        }
    }

    fun sendMessage(chatID:Long, text: String, authorIsAdmin: Boolean){
        viewModelScope.launch {
            try {
                getAllDriverUseCase.sendMessage(chatID, text, authorIsAdmin)
            }catch (e:Exception){
                Log.e("sendMessage", "{${e.message}")
            }
        }
    }
}