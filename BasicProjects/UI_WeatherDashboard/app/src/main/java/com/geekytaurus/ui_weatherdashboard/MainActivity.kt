package com.geekytaurus.ui_weatherdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekytaurus.ui_weatherdashboard.ui.theme.UI_WeatherDashboardTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.TachometerAlt
import compose.icons.fontawesomeicons.solid.Tint
import compose.icons.fontawesomeicons.solid.Wind


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UI_WeatherDashboardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   WeatherDashboard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WeatherDashboard(modifier: Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.city_bg_1), // Use paint to set the image background
                contentScale = ContentScale.Crop // Adjust as needed (e.g., FillBounds, Crop)
            )

    ){
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
//                .offset(x = 10.dp, y = 70.dp)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "San Francisco", fontSize = 28.sp,
                fontWeight = FontWeight.Bold, color = Color.White
            )
            Text(text = "22°C", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = "Sunny", fontSize = 20.sp, color = Color.White)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = FontAwesomeIcons.Solid.Wind, // Replace with FontAwesome icon
                        contentDescription = "Wind",
                        modifier = Modifier.size(24.dp),
                         tint = Color.White
                    )
                    Text("15 km/h", color = Color.White)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = FontAwesomeIcons.Solid.Tint, // Replace with FontAwesome icon for Humidity
                        contentDescription = "Humidity",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                    Text("60%", color = Color.White)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = FontAwesomeIcons.Solid.TachometerAlt, // Replace with FontAwesome icon for Pressure
                        contentDescription = "Pressure",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                    Text("1012 hPa", color = Color.White)
                }
            }

        }
    }
}
