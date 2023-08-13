package com.example.compose_notes.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.compose_notes.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDatabaseDao{

    @Query(value = "SELECT * FROM notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query(value = "SELECT * FROM notes_tbl WHERE id=:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query(value = "DELETE FROM notes_tbl")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteNote(note: Note)

}