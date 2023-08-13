package com.example.compose_notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.compose_notes.model.Note

@Dao
interface NotesDatabaseDao{

    @Query(value = "SELECT * FROM notes_tbl")
    fun getNotes(): List<Note>

    @Query(value = "SELECT * FROM notes_tbl WHERE id=:id")
    fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: Note)

    @Query(value = "DELETE FROM notes_tbl")
    fun deleteAllNotes()

    @Delete
    fun deleteNote(note: Note)

}