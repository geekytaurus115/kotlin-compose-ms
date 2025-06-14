package com.example.scaffold_appbar_fab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scaffold_appbar_fab.ui.theme.Scaffold_appbar_fabTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold_appbar_fabTheme {

            }
        }
    }
}

//Project 1: Basic Scaffold Layout
@Composable
fun BasicScaffoldLayout() {
    Scaffold { innerPadding ->
        Text("Hello", Modifier.padding(innerPadding))
    }

    Text("Hello", Modifier.padding(56.dp))

}


//Project 2: TopAppBar Only
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithTopAppBar() {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Red) // You can change the color and width
            ) {
                TopAppBar(
                    title = { Text("TopAppBar Example") }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text("Content Area")
        }
    }
}

//Project 3: BottomAppBar Only
@Composable
fun ScaffoldWithBottomAppBar() {
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Text(
                    "BottomAppBar Here",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text("Main Screen")
        }
    }
}

//Project 4: FAB Only
@Composable
fun ScaffoldWithFAB() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO */ }) {
                Text("+")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text("FAB Demo")
        }
    }
}

// Project 5: FAB Opens a Dialog
@Composable
fun FABWithDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Text("+")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("FAB with Dialog")
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Dialog Title") },
            text = { Text("Opened from FAB!") }
        )
    }
}



@Preview(showSystemUi = true)
@Composable
fun ScaffoldPreview(){
//    BasicScaffoldLayout()

//    ScaffoldWithTopAppBar()

//    ScaffoldWithBottomAppBar()

//    ScaffoldWithFAB()

    FABWithDialog()

}

