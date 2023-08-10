package com.example.compose_notes.model

import java.util.Calendar
import java.util.Date
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: Date = Calendar.getInstance().time
)
