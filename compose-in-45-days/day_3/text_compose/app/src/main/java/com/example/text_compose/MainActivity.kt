package com.example.text_compose

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.text_compose.ui.theme.Text_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text_composeTheme {
                ClickableTextTask()
            }
        }
    }
}

@Composable
fun SimpleText(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("This is a Simple Text")
    }
}

@Composable
fun SimpleTextTask(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
       Column (
           modifier = Modifier.fillMaxWidth(),
           horizontalAlignment = Alignment.CenterHorizontally
       ){
           Text("My Awesome Headline",
               style = MaterialTheme.typography.headlineLarge,
               color = Color(0xFF1E88E5)
           )

           Spacer(modifier = Modifier.height(8.dp))

           Text("Here is my tagline",
               style = MaterialTheme.typography.bodyLarge,
               color = Color.DarkGray
           )
       }
    }
}

@Composable
fun StyledText(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Styled Text",
        fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
    }
}

//Create a pricing section with bold amount, small currency.
@Composable
fun StyledTextTask(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
       Row(
           verticalAlignment = Alignment.Bottom,
           modifier = Modifier.padding(16.dp)
       ) {

           Text("₹",
               fontSize = 16.sp,
               fontWeight = FontWeight.Normal,
               modifier = Modifier.padding(2.dp)
           )

           Text("499",
               fontSize = 36.sp,
               fontWeight = FontWeight.Bold
               )

       }
    }
}


//Make a sentence with colored keywords like: "Jetpack Compose is awesome"
@Composable
fun AnnotedTextTask(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            buildAnnotatedString {
                append("Jetpack ")
                withStyle(style = SpanStyle(color = Color(0xFF1E88E5), fontWeight = FontWeight.Bold)){
                    append("Compose")
                }
                append(" is ")
                withStyle(style = SpanStyle(color = Color(0xFFFA1C7C), fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)){
                    append("awesome")
                }
            },
            fontSize = 20.sp
        )
    }
}

//Add a “Terms & Conditions” link at the bottom.
@Composable
fun ClickableTextTask() {
    val context = LocalContext.current

    val annotatedText = buildAnnotatedString {
        append("By signing up, you agree to our ")

        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Terms & Conditions")
        }
    }


    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = annotatedText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    // Open Google when clicked
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                    context.startActivity(intent)
                }
        )
    }
}

// Display Terms & Conditions as scrollable content.
@Composable
fun ScrollableTextTask(){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)

    ) {
        Text(
            text = """
                 Terms & Conditions

                1. Introduction
                Welcome to our app. By using our app, you agree to these Terms & Conditions.

                2. Use License
                Permission is granted to temporarily download one copy of the materials for personal, non-commercial use only.

                3. Disclaimer
                The materials are provided "as is". We make no warranties.

                4. Limitations
                In no event shall we be liable for damages.

                5. Revisions
                We may revise the terms at any time without notice.

                6. Governing Law
                These terms are governed by the laws of the respective country.
   1. Introduction
                Welcome to our app. By using our app, you agree to these Terms & Conditions.

                2. Use License
                Permission is granted to temporarily download one copy of the materials for personal, non-commercial use only.

                3. Disclaimer
                The materials are provided "as is". We make no warranties.

                4. Limitations
                In no event shall we be liable for damages.

                5. Revisions
                We may revise the terms at any time without notice.

                6. Governing Law
                These terms are governed by the laws of the respective country.

                ...

                (Add more detailed content here to make it scrollable.)
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}





@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
////    SimpleText()
////    SimpleTextTask()
////    StyledText()
////    StyledTextTask()
//    AnnotedTextTask()
//ClickableTextTask()

    ScrollableTextTask()
}