package com.example.vms_swe.models

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Message

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageModel(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = if (message.authorIsAdmin) Arrangement.Start else Arrangement.End
    ) {
        Spacer(modifier = Modifier.width(8.dp))

        Card(
            onClick = {},
            modifier = Modifier.padding(4.dp),
            colors = CardDefaults.cardColors(Color(0xFFFFF9E5))
        ) {
            Text(text = message.text, modifier = Modifier.padding(start = 8.dp, end = 8.dp))
        }

        Spacer(modifier = Modifier.width(4.dp))
    }
}
/*
@Preview
@Composable
fun previewMessageModel() {
    MessageModel(
        message = Message(
            text = "hello I have question",
            authorIsAdmin = true,
            chatID = 1,
            isRead = false,
            messageID = 1,
            sentTime = ""
        )
    )

}*/
