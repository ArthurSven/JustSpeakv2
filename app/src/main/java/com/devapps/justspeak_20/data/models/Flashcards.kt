package com.devapps.justspeak_20.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flashcards")
data class Flashcard(
    @PrimaryKey(autoGenerate = true)
    val flashCardId: Int = 0,
    @ColumnInfo("german")
    val german: String,
    @ColumnInfo("english")
    val english: String,
    @ColumnInfo("date")
    val date: String,
    @ColumnInfo("createdBy")
    val createdBy: String
)
