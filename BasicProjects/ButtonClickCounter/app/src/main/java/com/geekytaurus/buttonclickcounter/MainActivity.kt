package com.geekytaurus.buttonclickcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.geekytaurus.buttonclickcounter.ui.theme.ButtonClickCounterTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonClickCounterTheme {
                Scaffold { innerPadding ->
                    ClickCounter(modifier = Modifier.padding(innerPadding))
                }
            }
            }
        }
    }

@Composable
fun ClickCounter(modifier: Modifier){
    var count by remember { mutableStateOf(0) }
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp // Get screen width in dp
    val textBackgroundWidth = screenWidth * 3 / 4
    val elevation by animateDpAsState(if (count > 0) 8.dp else 0.dp)

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF99FFFF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text(
            //text = "You Clicked Me: $count Times 😢",
            buildAnnotatedString {
                append("You Clicked Me:  ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)) {
                    append("$count ")
                }
                append(" Times 😢")
            },
            color = Color.White,
            modifier = Modifier
                .width(textBackgroundWidth)
                .background(
                    Color.Black,
                    RoundedCornerShape(15.dp)
                )
                .padding(20.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.padding(30.dp))

        Row(
        ) {

            Button(onClick = { count++ }) {
                Text(
                    text = "Click Me",
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Button(onClick = { count = 0}) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )

            }
        }

    }

}