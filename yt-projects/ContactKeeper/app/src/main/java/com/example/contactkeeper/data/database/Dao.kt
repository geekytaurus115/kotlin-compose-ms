package com.example.contactkeeper.data.database

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface Dao {
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts_table ORDER BY name ASC")
    fun getContactsSortedByName(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts_table ORDER BY dateOfCreation ASC")
    fun getContactsSortedByDat(): Flow<List<Contact>>



}