package com.geekytaurus.rojems

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RomanticGreeting()
        }
    }
}

@Composable
fun RomanticGreeting(modifier: Modifier = Modifier) {
    var showMessage by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // Romantic message with fade-in and fade-out animation
            AnimatedVisibility(
                visible = showMessage,
                enter = fadeIn(animationSpec = tween(durationMillis = 300)), // Fade-in with duration
                exit = fadeOut(animationSpec = tween(durationMillis = 300)) // Fade-out with duration
            ) {
                Text(
                    text = "You are my sunshine, Roje 💖",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(40.dp))


            // Button to reveal or hide the romantic message
            Button(
                onClick = { showMessage = !showMessage },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF50B9AF)
                ),
                modifier = Modifier
                    .animateContentSize() // Animate size change
            ) {
                Text(
                    text = if (showMessage) "Hide My Feelings 😐" else "Reveal My Love 💖",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

        }
    }
}