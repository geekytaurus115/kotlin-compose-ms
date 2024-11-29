package com.geekytaurus.netflixfirstscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekytaurus.netflixfirstscreen.ui.theme.NetflixFirstScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetflixFirstScreenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NetflixFirstScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NetflixFirstScreen(modifier: Modifier){

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 0.dp)
    ) {
       Row(
           verticalAlignment = Alignment.CenterVertically, // Aligns content vertically in the Row
       ) {
           Spacer(modifier = Modifier.weight(1f))
           Image(
               painter = painterResource(id = R.drawable.netflix_logo),
               contentDescription = "Logo",
               modifier = Modifier
                   .width(120.dp)
           )
           /*
           * If one composable has weight(1f) and another weight(2f), the first will take up one-third, and the second will take up two-thirds of the space.
Using weight(1f) for Spacer in a Row helps distribute empty space around elements, like centering the logo in your layout.
           * */
           Spacer(modifier = Modifier.weight(1f))
           Image(painter = painterResource(id = R.drawable.baseline_edit_24),
               contentDescription = "Edit Logo",
               modifier = Modifier.size(45.dp)
           )
       }
        
        Spacer(modifier = Modifier.height(140.dp))
        Text(
            text = "Who's Watching?",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
            )

        Box(
            modifier = Modifier
                .padding(
                    start = 50.dp,
                    top = 24.dp,
                    end = 50.dp,
                    bottom = 24.dp
                ) // Apply specific padding
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center // Centers the LazyVerticalGrid inside the Box
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // Set 2 columns
                verticalArrangement = Arrangement.spacedBy(16.dp), // Space between rows
                horizontalArrangement = Arrangement.spacedBy(16.dp), // Space between columns
                modifier = Modifier.width(256.dp) // Corrected width for two boxes plus spacing

            ) {
                items(imageList) { item -> // Creating 5 boxes
                    Box(
                        modifier = Modifier
                            .size(120.dp) // Size of each box
                            .aspectRatio(1f), // Ensures a 1:1 aspect ratio for a square
//                            .background(Color.Gray),
                        contentAlignment = Alignment.TopCenter

                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = item.imageRes),
                                contentDescription = "Image desc",
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop

                            )
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 4.dp)
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }


       }
}