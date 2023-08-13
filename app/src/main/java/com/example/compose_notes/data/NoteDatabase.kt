package com.example.compose_notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.compose_notes.model.Note
import com.example.compose_notes.util.DateConvertor
import com.example.compose_notes.util.UUIDConvertor

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(DateConvertor::class, UUIDConvertor::class)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NotesDatabaseDao

}