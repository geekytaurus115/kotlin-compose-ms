package com.example.compose45

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose45.day_01_intro.Greeting
import com.example.compose45.day_02_fundamentals.AlignMultipleItemsInBox
import com.example.compose45.day_02_fundamentals.BoxShapeBorderClipShadow
import com.example.compose45.day_02_fundamentals.BoxZIndex
import com.example.compose45.day_02_fundamentals.ColumnAlignment
import com.example.compose45.day_02_fundamentals.ColumnCustomBackgroundAndShape
import com.example.compose45.day_02_fundamentals.ColumnScrollability
import com.example.compose45.day_02_fundamentals.ColumnWeightDistribution
import com.example.compose45.day_02_fundamentals.LearnColumn
import com.example.compose45.day_02_fundamentals.LearnRow
import com.example.compose45.day_02_fundamentals.ProfileCardUI
import com.example.compose45.day_02_fundamentals.SpacingBetweenColumnItems
import com.example.compose45.ui.theme.Compose45Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose45Theme {

                // *** day-1 : intro ***
                //Greeting()

                // *** day-2: Column, Row, Box, Spacer, Padding, Margin ***
                // Column
//                LearnColumn()
//                ColumnAlignment()
//                SpacingBetweenColumnItems()
//                ColumnScrollability()
//                ColumnWeightDistribution()
//                ColumnCustomBackgroundAndShape()

                //Row
                //LearnRow()

                //Box
                //    BoxWithCenteredText()
//    AlignMultipleItemsInBox()
//    AbsolutePositioningWithOffset()
                //BoxShapeBorderClipShadow()
                //BoxZIndex()

                // Final Project on Day-2 : Profile Card UI
                ProfileCardUI()

            }
        }
    }
}
