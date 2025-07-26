package com.example.contactkeeper.data.di

import android.app.Application
import androidx.room.Room
import com.example.contactkeeper.data.database.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModel {

    @Provides
    fun provideDatabase(application: Application): ContactDatabase{
        return Room.databaseBuilder(
            application.baseContext,
            ContactDatabase::class.java,
            "contact_db"
        ).fallbackToDestructiveMigration().build()
    }

}