package com.example.view_model

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.view_model.ui.theme.View_modelTheme
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            View_modelTheme {
//                Surface {
//                    // Use ViewModel here
//                    val counterViewModel: CounterViewModel = viewModel()
//                    CounterScreen(
//                        count = counterViewModel.count,
//                        onIncrement = counterViewModel::incrementCount
//                    )
//                }

                // Login Screen
                Scaffold {innerPadding ->
                    LoginScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

