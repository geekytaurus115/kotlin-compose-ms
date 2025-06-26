package com.example.note_app.data.repository

import com.example.note_app.data.local.dao.NoteDao
import com.example.note_app.data.local.entity.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val dao: NoteDao){
    val notes: Flow<List<Note>> = dao.getAllNotes()

    suspend fun insert(note: Note) = dao.insertNote(note)
    suspend fun delete(note: Note) = dao.deleteNote(note)
}