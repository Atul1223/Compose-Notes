package com.example.compose_notes.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.compose_notes.data.NotesDataSource
import com.example.compose_notes.model.Note

class NoteViewModel: ViewModel() {

    private val _noteList = mutableStateListOf<Note>()

    init {
        _noteList.addAll(NotesDataSource().loadNotes())
    }

    fun getNoteList(): List<Note> = _noteList

    fun addNote(note: Note) {
        _noteList.add(note)
    }

    fun removeNote(note: Note){
        _noteList.remove(note)
    }

}