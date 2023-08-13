package com.example.compose_notes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JetNoteApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}