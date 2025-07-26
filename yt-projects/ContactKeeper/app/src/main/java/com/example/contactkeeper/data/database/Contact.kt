package com.example.contactkeeper.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts_table")
data class Contact (
  @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String,
    var phoneNumber: String,
    var email: String,
    var isActive: Boolean,
    var dateOfCreation: Long,
    var img: ByteArray? = null
)
