package com.devapps.justspeak_20.utils

import com.devapps.justspeak_20.data.models.Deck

sealed class Response {
    class Success(val response: Any) : Response()
    class Error(val error: Exception) : Response()
}

data class SaveProgressState(
    val isSuccessful: Boolean = false,
    val error: String? = null
)

data class SaveProgressResult(
    val topic: String, // or any relevant data related to the progress
    val errorMessage: String?
)

data class AddDeckState(
    val isSuccessful: Boolean = false,
    val error: String? = null
)

data class AddDeckResult(
    val deck: Deck, // or any relevant data related to the progress
    val errorMessage: String?
)