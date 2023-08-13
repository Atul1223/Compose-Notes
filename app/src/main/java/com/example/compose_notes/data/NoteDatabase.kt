package com.example.compose_notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.compose_notes.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false,
)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NotesDatabaseDao

}