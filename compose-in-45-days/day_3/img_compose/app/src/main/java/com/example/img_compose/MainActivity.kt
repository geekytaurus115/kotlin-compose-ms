package com.example.img_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.img_compose.ui.theme.Img_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Img_composeTheme {
                LoadImageFromURL()
            }
        }
    }
}

// Show app icons, logos, or assets stored in res/drawable
@Composable
fun LocalImage(){
    Image(
        painter = painterResource(R.drawable.img),
        contentDescription  = "App logo",
//        contentScale = ContentScale.Fit

    )
}

// Task: Show your app logo at the center of a splash screen.
@Composable
fun SplashScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.krishna),
            contentDescription = "app logo"
        )
    }
}

// Load Image from URL: using Coil
@Composable
fun LoadImageFromURL(){

    val imageUrl = "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d"


    Image(
        painter = rememberAsyncImagePainter(model = imageUrl),
        contentDescription = "",
        modifier = Modifier
            .size(250.dp),
        contentScale = ContentScale.Crop
    )
}


// Circular Image
@Composable
fun CircularImage(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.krishna),
            contentDescription = "krishna",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)

        )
    }
}




@Composable
@Preview(showSystemUi = true)
fun PreviewImgCompose(){
//    LocalImage()
//    SplashScreen()
//     LoadImageFromURL()
//    CircularImage()
}
