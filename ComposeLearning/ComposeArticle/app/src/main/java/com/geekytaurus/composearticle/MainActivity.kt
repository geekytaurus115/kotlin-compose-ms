package com.geekytaurus.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekytaurus.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  ComposeImage(
                      heading = stringResource(R.string.jetpack_compose_heading),
                      firstPara = stringResource(R.string.jetpack_compose_first_para),
                      secondPara = stringResource(R.string.jetpack_compose_second_para),
                      Modifier.padding(innerPadding)
                  )
                }
            }
        }
    }
}

@Composable
fun ComposeImage(heading: String, firstPara: String, secondPara: String, modifier: Modifier = Modifier){
    val headerImage = painterResource(R.drawable.bg_compose_background)

    Column (modifier){
        Image(
            painter = headerImage,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        ComposeArticle(
            heading = heading,
            firstPara = firstPara,
            secondPara = secondPara,
        )
    }
}

@Composable
fun ComposeArticle(heading: String, firstPara: String, secondPara: String, modifier: Modifier = Modifier) {
    Column(
        modifier
    ) {
        Text(text = heading,
            modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            fontSize = 24.sp
        )
        Text(text = firstPara,
            modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            textAlign = TextAlign.Justify
        )
        Text(text = firstPara,
            modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeImage(
            stringResource(R.string.jetpack_compose_heading),
            firstPara = stringResource(R.string.jetpack_compose_first_para),
            secondPara = stringResource(R.string.jetpack_compose_second_para)
        )
    }
}