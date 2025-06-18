package com.example.dialogs_snackbars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dialogs_snackbars.ui.theme.Dialogs_snackbarsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dialogs_snackbarsTheme {
                NotesApp()
            }
        }
    }
}


/*

🛠️ Mini Project: Dialog Confirmation Before Deleting a Note
✨ Goal:
Create a simple list of notes. When the user tries to delete a note, show a Dialog for confirmation. After deletion, show a Snackbar that says “Note deleted”.

🧪 Features:
List of notes
Delete icon per note
When delete is tapped → show AlertDialog
If confirmed → remove the note & show Snackbar
 */

@Composable
fun NotesApp() {
    val snackbarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()


    val notes = remember { mutableStateListOf("Note 1", "Note 2", "Note 3") }
    var showDialog by remember { mutableStateOf(false) }
    var noteToDelete by remember { mutableStateOf<String?>(null) }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) {innerPadding ->
        LazyColumn (
            modifier = Modifier.padding(innerPadding)
        ){
            items(notes) { note ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(note)
                    IconButton(onClick = {
                        noteToDelete = note
                        showDialog = true
                    }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete")
                    }
                }
            }
        }

        // AlertDialog
        if (showDialog && noteToDelete != null) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Confirm Delete") },
                text = { Text("Are you sure you want to delete this note?") },
                confirmButton = {
                    TextButton(onClick = {
                        notes.remove(noteToDelete)
                        showDialog = false
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Note deleted")
                        }
                    }) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}
