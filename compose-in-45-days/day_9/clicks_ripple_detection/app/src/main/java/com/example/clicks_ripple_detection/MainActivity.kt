package com.example.clicks_ripple_detection

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.clicks_ripple_detection.ui.theme.Clicks_ripple_detectionTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Clicks_ripple_detectionTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//
//                }

//                FruitList()

//                ClickableBox()

                PhotoViewer()
            }
        }
    }
}


/*
✅ 1. clickable
What it does:
Makes a Composable respond to user click/tap actions.

Real-life Mini Project Example:
🧡 Like Button in a Social Media Post

Use case: Tap a heart icon to "like" or "unlike" a post.
 */

@Composable
fun LikeButtonExample(){
    var isLiked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
       androidx.compose.material3.Icon(
           imageVector = Icons.Default.Favorite,
           contentDescription = "",
           tint = if (isLiked) Color.Red else Color.Gray,
           modifier = Modifier
               .size(64.dp)
               .clickable {
                   isLiked = !isLiked
               }
       )
    }
}





// Modifier.clickable
// Create a list of items. When an item is clicked, show a Toast or Snackbar with the item's name.
@Composable
fun FruitList() {
    val context = LocalContext.current
    val fruits = listOf("Apple", "Banana", "Cherry")

    LazyColumn {
        items(fruits) { fruit ->
            Text(
                text = fruit,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        Toast
                            .makeText(context, "$fruit clicked", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun ClickableBox() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null // Optional: Use null to disable ripple OR leave it out to use default ripple
            ) {
                Toast.makeText(context, "Box clicked!", Toast.LENGTH_SHORT).show()
            }
    )
}


@Composable
fun CustomButtonWithoutRipple() {
    var clicked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(if (clicked) Color.DarkGray else Color.LightGray)
            .clickable(
                indication = null, // 👉 removes ripple effect
                interactionSource = remember { MutableInteractionSource() }
            ) {
                clicked = !clicked
            }
            .padding(vertical = 12.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (clicked) "Clicked" else "Click Me",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Composable
fun CustomButtonWithRipple() {
    var clicked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(if (clicked) Color.DarkGray else Color.LightGray)
            .clickable {
                clicked = !clicked
            }
            .padding(vertical = 12.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (clicked) "Clicked" else "Click Me",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

/*
✅ 3. pointerInput
What it does: Detects low-level gestures like drag, swipe, long press, and more by giving you full control over pointer events.

✅ Project: Swipe Card to Remove using pointerInput
🧩 Features:
Stack of profile cards
Swipe left/right to remove
Smooth drag animation using pointerInput + Animatable
 */


@Composable
fun SwipeCardStack() {
    var cardList by remember {
        mutableStateOf(
            listOf("Alice", "Bob", "Charlie", "Diana", "Eve")
        )
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        cardList.takeLast(4).forEachIndexed { index, name ->
            SwipeableCard(
                name = name,
                onSwiped = {
                    cardList = cardList - name
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .aspectRatio(0.75f)
                    .offset(y = (index * 8).dp) // Stack spacing
            )
        }
    }
}

@Composable
fun SwipeableCard(
    name: String,
    onSwiped: () -> Unit,
    modifier: Modifier = Modifier
) {
    val offsetX = remember { Animatable(0f) }

    val rotation = offsetX.value / 60

    Box(
        modifier = modifier
            .graphicsLayer(
                translationX = offsetX.value,
                rotationZ = rotation
            )
            .pointerInput(Unit) {
                // ✅ Correct coroutine scope usage
                coroutineScope {
                    detectDragGestures(
                        onDragEnd = {
                            launch {
                                when {
                                    offsetX.value > 300f || offsetX.value < -300f -> {
                                        onSwiped()
                                    }
                                    else -> {
                                        offsetX.animateTo(0f, tween(300))
                                    }
                                }
                            }
                        },
                        onDrag = { _, dragAmount ->
                            launch {
                                offsetX.snapTo(offsetX.value + dragAmount.x)
                            }
                        }
                    )
                }
            }
            .background(
                color = Color(0xFFBBDEFB),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

/*
✅ Mini Project: Photo Viewer with Pinch to Zoom & Drag
🔧 Features
Pinch to zoom in/out on an image.
Drag (pan) the image across the screen.

Line/Part	Explanation
scale & offset	State values to track zoom and drag
detectTransformGestures	Built-in gesture detector for pan + zoom
scale *= zoom	Multiplies scale factor to zoom in/out
offset += pan	Updates image position as user drags
graphicsLayer	Applies transformation to the image

🧪 Real-Life Use
Zoom in on product photos in a shopping app.
Pan around a large image (map, blueprint).
Photo gallery with gesture support.

 */

@Composable
fun PhotoViewer() {
    var scale by remember { mutableStateOf(1f) }           // Zoom level
    var offset by remember { mutableStateOf(Offset.Zero) } // Position for pan

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale *= zoom                        // Zoom in/out
                    offset += pan                        // Move image
                }
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.cr7_1), // replace with your image
            contentDescription = "Zoomable image",
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale.coerceIn(1f, 5f),    // limit zoom scale
                    scaleY = scale.coerceIn(1f, 5f),
                    translationX = offset.x,
                    translationY = offset.y
                )
        )
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewAppp(){
//    FruitList()

//    LikeButtonExample()

//    CustomButtonWithoutRipple()

//    CustomButtonWithRipple()

//    SwipeCardStack()

    PhotoViewer()
}