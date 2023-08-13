package com.example.compose_notes.util

import androidx.room.TypeConverter
import java.util.Date

class DateConvertor {

    @TypeConverter
    fun timeStampFromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun dateTimeStamp(timeStamp: Long):Date? {
        return Date(timeStamp)
    }
}