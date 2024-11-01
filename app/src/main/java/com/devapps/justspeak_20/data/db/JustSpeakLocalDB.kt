package com.devapps.justspeak_20.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devapps.justspeak_20.data.models.Flashcard

@Database(entities =  [Flashcard::class], version = 1, exportSchema = false)
abstract class JustSpeakLocalDB : RoomDatabase() {

    abstract fun flashcardDao() : FlashcardDao
}