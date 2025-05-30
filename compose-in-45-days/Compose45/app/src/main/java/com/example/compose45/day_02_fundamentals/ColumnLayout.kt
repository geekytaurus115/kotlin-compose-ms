package com.example.compose45.day_02_fundamentals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LearnColumn(){
    Box(
        modifier = Modifier.fillMaxSize(),
//            .background(color = Color.Red)
//            .padding(20.dp)
//            .background(color = Color.Cyan),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.background(color = Color.Gray)
                .padding(24.dp)
                .background(color = Color.Blue)
        ) {
            Text("Item-1")
            Text("Item-2")
            Text("Item-3")
        }
    }
}

// Center children horizontally
@Composable
fun ColumnAlignment(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Hello World!")
    }
}


// Adds space between children vertically
@Composable
fun SpacingBetweenColumnItems(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Item-1")
        Text("Item-2")
        Text("Item-3")
    }
}

@Composable
fun ColumnScrollability(){
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        repeat(30){
            Text("Item $it",
                modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ColumnWeightDistribution(){
    Column (
        modifier = Modifier.fillMaxHeight()
    ){
        Text("Hello")
        // Pushes next item to the bottom
        Spacer(modifier = Modifier.weight(1f))
        Text("World")
        Spacer(modifier = Modifier.weight(2f))
    }

/*
Spacer(modifier = Modifier.weight(0.5f))
Spacer(modifier = Modifier.weight(1.5f))

    Total weight = 0.5f + 1.5f = 2f
    Total space = 300 pixels

    Calculate:

    Spacer	Weight	Space taken
            First Spacer	0.5f	(0.5 / 2) × 300 = 75 px
    Second Spacer	1.5f	(1.5 / 2) × 300 = 225 px


 */
}


@Composable
fun ColumnCustomBackgroundAndShape(){
    Column(
        modifier = Modifier
            .background(color = Color.LightGray,
            shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text("Styled Column")
        Text("With Rounded Corners")
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun AppPreview(){
//    //LearnColumn()
////    ColumnAlignment()
////    SpacingBetweenColumnItems()
////    ColumnScrollability()
////    ColumnWeightDistribution()
//
//    ColumnCustomBackgroundAndShape()
//
//
//}