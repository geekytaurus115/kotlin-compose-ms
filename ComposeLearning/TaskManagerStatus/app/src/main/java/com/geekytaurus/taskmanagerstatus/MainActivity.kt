package com.geekytaurus.taskmanagerstatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekytaurus.taskmanagerstatus.ui.theme.TaskManagerStatusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerStatusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskCompleteStatus(
                        status = stringResource(R.string.task_complete_status),
                        complement = stringResource(R.string.complement_text),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

}

@Composable
fun TaskCompleteStatus (status: String, complement: String, modifier: Modifier = Modifier){
    val task_complete_image = painterResource(R.drawable.ic_task_completed)

    Column (
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = task_complete_image,
            contentDescription = null,
            )
        Text(
            text = status,
            Modifier.padding(8.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = complement,
            fontSize = 16.sp
            )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerStatusTheme {
        TaskCompleteStatus(
            status = stringResource(R.string.app_name),
            complement = stringResource(R.string.app_name)
        )
    }
}