package com.example.button_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.button_compose.ui.theme.Button_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Button_composeTheme {

            }
        }
    }
}

// Simple Button
@Composable
fun BasicButton(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = {}) {
            Text("Click Me")
        }
    }
}


// Outlined Button
@Composable
fun OutlinedButton(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        androidx.compose.material3.OutlinedButton(onClick = {}) {
            Text("Cancel")
        }
    }
}

// Text Button
@Composable
fun TextButton(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        androidx.compose.material3.TextButton(onClick = {}) {
            Text("Forget Password")
        }
    }
}

// Custom color & shape Button
@Composable
fun CustomColorShape(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            shape = RoundedCornerShape(12.dp)
            ) {
            Text("Custom")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    BasicButton()
//    OutlinedButton()
//    TextButton()
    CustomColorShape()
}
