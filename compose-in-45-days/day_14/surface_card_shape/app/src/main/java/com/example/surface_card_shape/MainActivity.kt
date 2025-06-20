package com.example.surface_card_shape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import com.example.surface_card_shape.ui.theme.Surface_card_shapeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface_card_shapeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SurfaceExample(Modifier.padding(innerPadding))
                }
            }
        }
    }
}


/*
📘 Concept:
Surface is a basic container in Jetpack Compose that:
Applies background color
Supports elevation and shape
Can hold content like Column, Row, Text, etc.
* */

@Composable
fun SurfaceExample(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .padding(16.dp, 56.dp, 16.dp, 16.dp)
            .fillMaxWidth(),
        color = Color(0xFFE0F7FA),
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 4.dp
    ) {
        Text(
            text = "This is inside a Surface",
            modifier = Modifier.padding(16.dp)
        )
    }
}

/*
🔹 Step 2: Card
📘 Concept:
Card is similar to Surface but has material styling, commonly used for UI elements like:
Dashboard tiles
News items
List entries
 */

@Composable
fun CardExample() {
    Card(
        modifier = Modifier
            .padding(16.dp, 56.dp, 16.dp, 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Card Title", style = MaterialTheme.typography.titleMedium)
            Text("This is some card content.", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

/*
🔹 Step 3: Shape
📘 Concept:
Shapes define the corner styles of components:
RoundedCornerShape(16.dp) → rounded corners
CutCornerShape(12.dp) → cut diagonals
Custom shapes possible!
 */

@Composable
fun ShapeExample() {
    Surface(
        modifier = Modifier
            .padding(16.dp, 56.dp, 16.dp, 16.dp)
            .size(150.dp),
        color = Color(0xFFFFF59D),
        shape = CutCornerShape(12.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text("Cut Shape")
        }
    }
}

/*
🔹 Step 4: Elevation
📘 Concept:
Elevation gives a shadow/depth effect to components.
 Use:
elevation in Card
tonalElevation in Surface
Higher values = more visible shadows

 */

@Composable
fun ElevationDemo() {
    Column {
        Surface(
            modifier = Modifier
                .padding(16.dp, 56.dp, 16.dp, 16.dp)
                .fillMaxWidth(),
            color = Color.White,
            tonalElevation = 2.dp
        ) {
            Text("Elevation 2.dp", Modifier.padding(16.dp))
        }

        Surface(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            color = Color.White,
            tonalElevation = 12.dp
        ) {
            Text("Elevation 12.dp", Modifier.padding(16.dp))
        }
    }
}


/*
🔸 Final Step: Mini Project – Styled Dashboard with Cards and Shadows
🎯 Goal:
Create a simple dashboard layout with:
2 cards in a row
Each card has a title, an icon, and a value
Uses shape and elevation
 */

@Composable
fun DashboardCard(
    title: String,
    value: String,
    icon: ImageVector,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(32.dp))
            Text(title, style = MaterialTheme.typography.titleSmall)
            Text(value, style = MaterialTheme.typography.headlineSmall)
        }
    }
}

@Composable
fun DashboardScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Dashboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DashboardCard(
                title = "Users",
                value = "1,024",
                icon = Icons.Filled.Person,
                color = Color(0xFFE3F2FD),
                modifier = Modifier.weight(1f)
            )
            DashboardCard(
                title = "Revenue",
                value = "$12K",
                icon = Icons.Filled.ThumbUp,
                color = Color(0xFFC8E6C9),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSurface(){
    SurfaceExample()

    
//    CardExample()

//    ShapeExample()

//    ElevationDemo()

//    DashboardScreen()

}