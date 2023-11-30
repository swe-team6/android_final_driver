package com.example.vms_swe.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.vms_swe.R
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthPage(viewModel: AuthPageViewModel = get(), navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.im_background_auth),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .padding(top = 218.dp, start = 37.dp, end = 38.dp, bottom = 217.dp)
                .size(width = 318.dp, height = 419.dp)
                .background(color = Color.White)
                .align(Alignment.Center)
        )
        {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.im_nu_logo),
                    contentDescription = "nu logo",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(top = 16.dp, start = 80.dp)
                        .size(width = 150.dp, height = 50.dp)
                )
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp)
                )


                // Username TextField
                TextField(
                    value = email,
                    onValueChange = {email = it},
                    label = {Text("Email address")},
                    singleLine = true,
                    placeholder = {Text("Email address")},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    leadingIcon = {
                        Icons.Outlined.MailOutline
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                )


                // Creating a variable to store toggle state
                var passwordVisible by remember { mutableStateOf(false) }

                // Create a Text Field for giving password input
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    singleLine = true,
                    placeholder = { Text("Password") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"

                        // Toggle button to hide or display password
                        IconButton(onClick = {passwordVisible = !passwordVisible}){
                            Icon(imageVector  = image, description)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .padding(bottom = 8.dp),
                )

            }
        }
        Box(
            modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Button(
                onClick = {
                    viewModel.viewModelScope.launch{
                        val result = viewModel.login(password = password, email = email)
                        if(result != null){
                            val userID = result.userID
                            navController.navigate("profile/$userID")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)
            ) {
                Text("Login")
            }
        }
    }
}
//
//@Preview
//@Composable
//fun previewLogin(){
//    AuthPage()
//}