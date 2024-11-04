package com.devapps.justspeak_20.data.repositories

import com.devapps.justspeak_20.data.db.FlashcardDao
import com.devapps.justspeak_20.data.models.Flashcard
import com.devapps.justspeak_20.utils.Response
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FlashcardRepository {

    suspend fun upsertFlashcard(flashcard: Flashcard) : Response

    suspend fun deleteFlashcard(flashcard: Flashcard)

    suspend fun getFlashcardsByUserId(userId: String?) : Flow<List<Flashcard>>

    fun getFlashcardById(flashcardId: Int) : Flow<Flashcard>
}

class FlashcardRepositoryImpl @Inject constructor(
    private val flashcardDao: FlashcardDao
) : FlashcardRepository {
    override suspend fun upsertFlashcard(flashcard: Flashcard) : Response {
        return try {
            val success = flashcardDao.upsertFlashcard(flashcard)
            Response.Success(success)
        } catch (e: Exception) {
            return Response.Error(e)
        }
    }

    override suspend fun deleteFlashcard(flashcard: Flashcard) = flashcardDao.deleteFlashcard(flashcard)

    override suspend fun getFlashcardsByUserId(userId: String?): Flow<List<Flashcard>> = flashcardDao.getFlashcardsByUserId(userId)

    override fun getFlashcardById(flashcardId: Int): Flow<Flashcard> = flashcardDao.getFlashcardById(flashcardId)

}