package com.example.compose_notes.repository

import com.example.compose_notes.data.NotesDatabaseDao
import com.example.compose_notes.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val notesDatabaseDao: NotesDatabaseDao
) {
    suspend fun addNote(note: Note) {
        notesDatabaseDao.insertNote(note = note)
    }

    suspend fun updateNote(note: Note) {
        notesDatabaseDao.updateNote(note = note)
    }

    suspend fun deleteNote(note: Note) {
        notesDatabaseDao.deleteNote(note = note)
    }

    suspend fun deleteAllNotes() {
        notesDatabaseDao.deleteAllNotes()
    }

    fun getAllNotes(): Flow<List<Note>> =
        notesDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}