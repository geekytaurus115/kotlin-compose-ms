package com.example.ebook.data.di

import com.example.ebook.data.repoImpl.AllBookRepoImpl
import com.example.ebook.domain.repo.AllBookRepo
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object HiltModel{

    @Provides
    @Singleton
    fun provideRealtimeDatabase(): FirebaseDatabase{
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage{
        return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideAllBookRepo(firebaseDatabase: FirebaseDatabase): AllBookRepo {
        return AllBookRepoImpl(firebaseDatabase)
    }

}