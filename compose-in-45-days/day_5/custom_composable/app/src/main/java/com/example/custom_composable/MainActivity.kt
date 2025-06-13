package com.example.custom_composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.custom_composable.ui.theme.Custom_composableTheme
import androidx.compose.material.icons.filled.Home


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Custom_composableTheme {
//                GreetingCard("Android")
            }
        }
    }
}


// Simple custom composable
@Composable
fun GreetingCard(name: String){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Hello $name!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}


// Custom Button
@Composable
fun CutomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    bgColor: Color = Color.Blue
){
   Box(
            modifier = Modifier.fillMaxSize(),
       contentAlignment = Alignment.Center
   ){
       Button(
           onClick = onClick,
           modifier = modifier,
           colors = ButtonDefaults.buttonColors(bgColor)
       ) {
           Text(
               text
           )
       }
   }
}

// Mini Project Reusable Stat Card
@Composable
fun StatCard(
    icon: ImageVector,
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer
) {
    Card(
        modifier = modifier
            .padding(8.dp, 30.dp, 8.dp, 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )
            Column {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = value, style = MaterialTheme.typography.bodyLarge)

            }
        }
    }
}

// Use the Stat Card in List
@Composable
fun Dashboard() {
    Column(modifier = Modifier.padding(16.dp)) {
        StatCard(
            icon = Icons.Default.Home,
            title = "Steps",
            value = "5,432"
        )
        StatCard(
            icon = Icons.Default.Favorite,
            title = "Heart Rate",
            value = "78 bpm"
        )
    }
}




@Preview(showSystemUi = true)
@Composable
fun PreviewApp(){
//    GreetingCard("Android")

//    CutomButton(
//        "Click",
//        onClick = {},
//        modifier = Modifier,
//        bgColor = Color.Gray
//    )

    Dashboard()
}