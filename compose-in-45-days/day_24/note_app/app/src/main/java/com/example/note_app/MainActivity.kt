package com.example.note_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note_app.data.local.database.DatabaseProvider
import com.example.note_app.data.repository.NoteRepository
import com.example.note_app.presentation.note.NoteScreen
import com.example.note_app.ui.theme.Note_appTheme
import com.example.note_app.viewmodel.NoteViewModel
import com.example.note_app.viewmodel.NoteViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Setup DAO, Repository, and ViewModelFactory
        val dao = DatabaseProvider.getDatabase(applicationContext).noteDao()
        val repository = NoteRepository(dao)
        val viewModelFactory = NoteViewModelFactory(repository)

        setContent {
            Note_appTheme {
                val viewModel: NoteViewModel = viewModel(factory = viewModelFactory)
                NoteScreen(viewModel = viewModel)
            }
        }
    }
}
