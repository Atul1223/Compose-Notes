package com.example.compose_notes.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConvertor {

    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromStaring(string: String?): UUID? {
        return UUID.fromString(string)
    }
}