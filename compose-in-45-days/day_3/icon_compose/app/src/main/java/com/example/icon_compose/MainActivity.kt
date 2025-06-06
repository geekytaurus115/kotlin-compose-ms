package com.example.icon_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.icon_compose.ui.theme.Icon_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Icon_composeTheme {

            }
        }
    }
}

// Basic Built-in Material Icon
@Composable
fun BuiltInMaterialIcon(){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
           Column {
               Icon(
                   Icons.Default.Home,
                   contentDescription = "home"
               )

               // Outlined Email
               Icon(
                   Icons.Outlined.Email,
                   contentDescription = "outlined email"
               )

               // Filled Email
               Icon(
                   Icons.Filled.Email,
                   contentDescription = "filled email"
               )

               // Icon with different color
               Icon(
                   Icons.Default.Settings,
                   contentDescription = "default settings",
                   tint = Color.Magenta,
                   modifier = Modifier.size(52.dp)
               )
           }
        }
}

//Custom Vector Icon from Asset
@Composable
fun VectorIcon(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(R.drawable.baseline_message_24),
            contentDescription = "message icon",
            tint = Color.Unspecified
        )
    }
}




@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
//    BuiltInMaterialIcon()
    VectorIcon()
}