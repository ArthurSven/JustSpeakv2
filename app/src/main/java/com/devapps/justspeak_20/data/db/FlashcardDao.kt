package com.devapps.justspeak_20.data.db

import androidx.compose.ui.text.style.LineBreak
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.devapps.justspeak_20.data.models.Flashcard
import kotlinx.coroutines.flow.Flow

@Dao
interface FlashcardDao {

    @Query("SELECT * FROM flashcards WHERE createdBy = :userId ORDER BY date")
    fun getFlashcardsByUserId(userId: String) : Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcards WHERE flashCardId = :flashcardId")
    fun getFlashcardById(flashcardId: Int) : Flow<Flashcard>

    @Upsert
    suspend fun upsertFlashcard(flashcard: Flashcard)

    @Delete
    suspend fun deleteFlashcard(flashcard: Flashcard)
}