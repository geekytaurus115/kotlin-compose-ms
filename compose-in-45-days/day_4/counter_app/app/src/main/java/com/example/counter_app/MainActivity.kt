package com.example.counter_app

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counter_app.ui.theme.Counter_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Counter_appTheme {

            }
        }
    }
}



@Composable
fun CounterApp(){

    // counter state
    val counter = remember { mutableStateOf(0) }

    // derived state
    val isEven = remember { derivedStateOf { counter.value % 2 == 0 } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Counter: ${counter.value}",
            fontSize = 32.sp
            )

        Spacer(modifier = Modifier.height(16.dp))

        // conditional rendering
        Text(
            text = if (isEven.value) "Even Number" else "Odd Number",
            color = if (isEven.value) Color.Blue else Color.Red,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(50.dp))

        Row (

        ){
            Button(
                onClick = {counter.value--},
                colors = ButtonDefaults.buttonColors(Color(0xFFAB286F))
                ) {
                Text("-")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {counter.value = 0},
                colors = ButtonDefaults.buttonColors(Color(0xFFAB286F))) {
                Text("Reset")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {counter.value++},
                colors = ButtonDefaults.buttonColors(Color(0xFFAB286F))) {
                Text("+")
            }
        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewCounterApp(){
        CounterApp()
}