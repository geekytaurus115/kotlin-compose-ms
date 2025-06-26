package com.example.note_app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note_app.data.local.dao.NoteDao
import com.example.note_app.data.local.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun noteDao(): NoteDao
}