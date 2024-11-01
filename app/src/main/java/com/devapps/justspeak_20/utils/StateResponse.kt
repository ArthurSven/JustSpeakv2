package com.devapps.justspeak_20.utils

import com.devapps.justspeak_20.data.models.Flashcard


sealed class Response {
    class Success(val response: Any) : Response()
    class Error(val error: Exception) : Response()
}

data class UpsertFlashCardState(
    val isSuccessful: Boolean = false,
    val error: String? = null
)

data class UpsertFlashcardResult(
    val data: Flashcard,
    val errorMessage: String?
)


