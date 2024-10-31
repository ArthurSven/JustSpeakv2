package com.devapps.justspeak_20.data.models

data class Deck(
    val deckId: String = "",     // Auto-incremented ID stored as a String
    val title: String = "",
    val creator: String = "",    // User ID of the creator
    val dateCreated: String = ""
)

data class Card(
    val cardId: String = "",
    val question: String = "",
    val answer: String = "",
    val deckId: String = "'"
)
