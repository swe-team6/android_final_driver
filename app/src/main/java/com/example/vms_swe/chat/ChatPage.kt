package com.example.vms_swe.chat

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Message
import com.example.vms_swe.models.MessageModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.get

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ChatPage(viewModel: ChatPageViewModel=get(), userID: Long = 1){

    LaunchedEffect(userID) {
        viewModel.getChat(userID)
    }

    // Periodically fetch messages
    LaunchedEffect(true) {
        while (true) {
            viewModel.getChat(userID)
            delay(1000) // Delay for 1 second before fetching again
        }
    }

   Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        viewModel.getChat(userID)
        val chat = viewModel.chat
        Text(
            text = "Chat with Admin",
            style = typography.h5.copy(
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.size(12.dp))

        LazyColumn(modifier = Modifier.fillMaxHeight(.9f)){
            chat?.messages?.reversed()?.forEach{
                item {
                    MessageModel(message = it)
                }
            }

        }
        // Text Field for typing messages
        var newMessage by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }
        val keyboardController = LocalSoftwareKeyboardController.current

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
               // .padding(bottom = 16.dp)
        ) {
            TextField(
                value = newMessage,
                onValueChange = { newMessage = it },
                label = { Text("Type your message...") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Send
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        // Handle sending the message
                        if (newMessage.isNotEmpty()) {
                            // You can call a function in your view model to send the message
                            if (chat != null) {
                                viewModel.sendMessage(chatID = chat.chatID, text = newMessage, authorIsAdmin = false)
                            }
                            Log.e("ChatPage", "Message was sent")
                            newMessage = ""
                            keyboardController?.hide()
                        }
                    }
                ),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            // Handle sending the message
                            if (newMessage.isNotEmpty()) {
                                // You can call a function in your view model to send the message
                                if (chat != null) {
                                    viewModel.sendMessage(chatID = chat.chatID, text = newMessage, authorIsAdmin = false)
                                }
                                Log.e("ChatPage", "Message was sent")
                                newMessage = ""
                                keyboardController?.hide()
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Send, contentDescription = null)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(end = 8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFFFF9E5), // Set your desired background color
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),

            )
        }

    }
}
//
//@Preview
//@Composable
//fun previewChat(){
//    ChatPage()
//}
