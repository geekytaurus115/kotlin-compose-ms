package com.example.textfield_forminput

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.textfield_forminput.ui.theme.Textfield_forminputTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Textfield_forminputTheme {

//                TextFieldEx()
//                FocusManagementEx()
                LoginForm()

            }
        }
    }
}


@Composable
fun TextFieldEx(){
    var text by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter name") },
                singleLine = true
            )

            // Outlined TextField
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter name") },
                singleLine = true
            )

            // Keyboard Options
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                )
            )

        }
    }
}


@Composable
fun FocusManagementEx(){
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email") },
        modifier = Modifier.focusRequester(focusRequester)
    )

// To request focus programmatically
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

// To clear focus
    Button(onClick = { focusManager.clearFocus() }) {
        Text("Clear Focus")
    }

}

@Composable
fun LoginForm() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorEmail by remember { mutableStateOf("") }
    var errorPassword by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

   Box(
       modifier = Modifier.fillMaxSize(),
       contentAlignment = Alignment.Center
   ){
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp)
       ) {
           Text("Login", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

           OutlinedTextField(
               value = email,
               onValueChange = {
                   email = it
                   errorEmail = ""
               },
               label = { Text("Email") },
               isError = errorEmail.isNotEmpty(),
               keyboardOptions = KeyboardOptions(
                   keyboardType = KeyboardType.Email,
                   imeAction = ImeAction.Next
               ),
               keyboardActions = KeyboardActions(
                   onNext = { focusManager.moveFocus(FocusDirection.Down) }
               ),
               modifier = Modifier.fillMaxWidth()
           )
           if (errorEmail.isNotEmpty()) {
               Text(text = errorEmail, color = Color.Red, fontSize = 12.sp)
           }

           Spacer(modifier = Modifier.height(8.dp))

           OutlinedTextField(
               value = password,
               onValueChange = {
                   password = it
                   errorPassword = ""
               },
               label = { Text("Password") },
               isError = errorPassword.isNotEmpty(),
               keyboardOptions = KeyboardOptions(
                   keyboardType = KeyboardType.Password,
                   imeAction = ImeAction.Done
               ),
               keyboardActions = KeyboardActions(
                   onDone = { focusManager.clearFocus() }
               ),
               visualTransformation = PasswordVisualTransformation(),
               modifier = Modifier.fillMaxWidth()
           )
           if (errorPassword.isNotEmpty()) {
               Text(text = errorPassword, color = Color.Red, fontSize = 12.sp)
           }

           Spacer(modifier = Modifier.height(16.dp))

           Button(
               onClick = {
                   if (email.isBlank()) errorEmail = "Email can't be empty"
                   else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) errorEmail = "Invalid email"

                   if (password.length < 6) errorPassword = "Minimum 6 characters"

                   if (errorEmail.isEmpty() && errorPassword.isEmpty()) {
                       // Proceed with login
                       println("Logged in with $email")
                   }
               },
               modifier = Modifier.fillMaxWidth()
           ) {
               Text("Login")
           }
       }
   }
}


@Preview(showSystemUi = true)
@Composable
fun AppPreview(){
    TextFieldEx()

}