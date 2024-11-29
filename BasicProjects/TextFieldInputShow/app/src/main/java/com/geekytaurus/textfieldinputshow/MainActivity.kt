package com.geekytaurus.textfieldinputshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geekytaurus.textfieldinputshow.ui.theme.TextFieldInputShowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextFieldInputShowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextFieldInputShow(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextFieldInputShow(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var displayedText by remember { mutableStateOf("")}

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = {text = it},
            label = {
                Text("Enter Text")
            }
        )
        Spacer(modifier = modifier.height(10.dp))
        Row {
            Button(onClick = { displayedText = text }) {
                Text(text = "Display Text")
            }
            Spacer(modifier = modifier.width(10.dp))
            Button(onClick = {text = ""}) {
                Text(text = "Clear")
            }
        }
        Spacer(modifier = modifier.height(30.dp))

        if(displayedText.isNotEmpty()){
            Text(text = displayedText)
        }
    }

}

