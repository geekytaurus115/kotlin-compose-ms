package com.geekytaurus.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geekytaurus.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp

// related animations
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.graphicsLayer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            DiceRollerTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                }
//            }
//            DiceRollerTheme {
//                DiceRollerApp()
//            }

            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)

    )
}

// ******* With Animation ********
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var isRolling by remember { mutableStateOf(false) } // Track rolling state
    var rotationZ by remember { mutableStateOf(0f) } // Z-axis rotation
    var translationY by remember { mutableStateOf(0f) } // Vertical throw movement

    // Animate rotation
    val animatedRotationZ by animateFloatAsState(
        targetValue = if (isRolling) rotationZ else 0f,
        animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing)
    )

    // Animate vertical throw (up and back to center)
    val animatedTranslationY by animateFloatAsState(
        targetValue = if (isRolling) translationY else 0f,
        animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing)
    )

    // Reset state after rolling
    if (!isRolling && rotationZ != 0f) {
        rotationZ = 0f
        translationY = 0f
    }

    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier
                .size(120.dp)
                .graphicsLayer(
                    rotationZ = animatedRotationZ, // Rotate while throwing
                    translationY = animatedTranslationY // Move vertically (throw up)
                )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (!isRolling) {
                    rotationZ += 720f // Double rotation for dramatic effect
                    translationY = -300f // Move upward (negative Y direction)
                    isRolling = true
                    result = (1..6).random() // Randomize dice result

                    // Reset after animation
                    android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                        isRolling = false
                    }, 800) // Match animation duration
                }
            }
        ) {
            Text(
                stringResource(R.string.roll),
                fontSize = 24.sp
            )
        }
    }
}



// ******** Normal Dice without Animation *********
//@Composable
//fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
//    var result by remember { mutableStateOf(1)}
//
//    val imageResource = when(result){
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }
//
//    Column(
//        modifier = modifier,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(imageResource),
//            contentDescription = result.toString()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = { result = (1..6).random() }) {
//            Text(
//                stringResource(R.string.roll),
//                fontSize = 24.sp
//                )
//        }
//    }
//}
//
//
