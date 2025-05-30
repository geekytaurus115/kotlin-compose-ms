package com.example.compose45.day_02_fundamentals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun BoxWithCenteredText(){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Gray),
        contentAlignment = Alignment.Center
    ){
        Text("Centered Text")
    }
}

@Composable
fun AlignMultipleItemsInBox(){
Box(
    modifier = Modifier.fillMaxSize()
        .padding(30.dp)
){
    Text("Top Start", modifier = Modifier.align(Alignment.TopStart))
    Text("Bottom End", modifier = Modifier.align(Alignment.BottomEnd))
}
}

@Composable
fun AbsolutePositioningWithOffset(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Text("Floating Text",
                modifier = Modifier
                    .offset(x = 50.dp, y = 300.dp)
                    .background(color = Color.Yellow)
            )
    }
}

@Composable
fun BoxShapeBorderClipShadow(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .size(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.Magenta)
            .border(2.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))
            .shadow(8.dp, shape = RoundedCornerShape(16.dp))

    )
}

@Composable
fun BoxZIndex(){


/*

   | `zIndex()` Value | Drawing Order     | Visual Layer             |
| ---------------- | ----------------- | ------------------------ |
| `-1f`            | Drawn **first**   | Appears **at the back**  |
| `0f` (default)   | Drawn after `-1f` | Behind anything > 0      |
| `2.7f`           | Drawn after `0f`  | In front of lower values |
| `42f`            | Drawn **last**    | Appears **on top**       |

 */

        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Text("Behind", modifier = Modifier.zIndex(0f))
            Text("In Front", modifier = Modifier.zIndex(1f).align(Alignment.Center))
        }

//    Box(modifier = Modifier.fillMaxSize()) {
//        Text(
//            "Behind",
//            modifier = Modifier
//                .align(Alignment.Center)
//                .zIndex(0f)
//                .background(Color.LightGray)
//        )
//
//        Text(
//            "In Front",
//            modifier = Modifier
//                .align(Alignment.Center)
//                .zIndex(1f)
//                .background(Color.Red)
//        )
//    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewBox(){
//    BoxWithCenteredText()
//    AlignMultipleItemsInBox()
//    AbsolutePositioningWithOffset()
//    BoxShapeBorderClipShadow()

    BoxZIndex()
}