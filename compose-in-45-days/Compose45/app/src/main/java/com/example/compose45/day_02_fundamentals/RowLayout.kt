package com.example.compose45.day_02_fundamentals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LearnRow(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text("Item-1")
            Spacer(modifier = Modifier.width(10.dp))
            Text("Item-2")
            Spacer(modifier = Modifier.width(10.dp))
            Text("Item-3")
            Spacer(modifier = Modifier.width(10.dp))
        }

    }


}


//@Preview(showSystemUi = true)
//@Composable
//fun AppPreview(){
//    LearnRow()
//}