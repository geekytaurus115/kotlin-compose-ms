package com.geekytaurus.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.geekytaurus.helloandroid.ui.theme.HelloAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Center $name!",
        color = Color.White,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .background(
                Color.Blue,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(40.dp)
    )

    // Righ Side Center
    Text(
        text = "Center End",
        color = Color.White,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.CenterEnd)
            .background(
                Color.Red,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(30.dp)
    )

    // Alignment in variable distant
    //.offset(x = 0.dp, y = 100.dp)
    Text(
        text = "Hello Variable",
        color = Color.White,
        modifier = modifier
            .offset(x = 0.dp, y = 100.dp)
            .background(
                Color.Green,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(30.dp)
    )

    // Top Center
    Text(
        text = "Top Center",
        color = Color.White,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
            .background(
                Color.Magenta,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(30.dp)
    )

    // Bottom End
    Text(
        text = "Bottom End",
        color = Color.White,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomEnd)
            .background(
                Color.Cyan,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(30.dp)
    )
}
