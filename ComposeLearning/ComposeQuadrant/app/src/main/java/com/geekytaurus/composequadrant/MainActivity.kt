package com.geekytaurus.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekytaurus.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrant(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    val text_head = stringResource(R.string.text_composable_heading)
    val text_para = stringResource(R.string.text_composable_para)
    val image_head = stringResource(R.string.image_composable_heading)
    val image_para = stringResource(R.string.image_composable_para)
    val row_head = stringResource(R.string.row_composable_heading)
    val row_para = stringResource(R.string.row_composable_para)
    val column_head = stringResource(R.string.column_composable_heading)
    val column_para = stringResource(R.string.column_composable_para)

    Column (
        modifier.fillMaxSize()
    ){
        Row (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ){
            Column (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFEADDFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = text_head,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = text_para,
                    textAlign = TextAlign.Justify

                )
            }
            Column (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFD0BCFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = image_head,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = image_para,
                    textAlign = TextAlign.Justify

                )
            }
        }
        Row (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ){
            Column (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFB69DF8))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = row_head,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = row_para,
                    textAlign = TextAlign.Justify

                )
            }
            Column (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFF6EDFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = column_head,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = column_para,
                    textAlign = TextAlign.Justify

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}