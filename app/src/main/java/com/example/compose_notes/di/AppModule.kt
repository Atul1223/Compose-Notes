package com.example.compose_notes.di

import android.content.Context
import androidx.room.Room
import com.example.compose_notes.data.NoteDatabase
import com.example.compose_notes.data.NotesDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase): NotesDatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase
        = Room.databaseBuilder(
            context = context,
            klass = NoteDatabase::class.java,
            name = "notes_db"
        ).fallbackToDestructiveMigration().build()
}