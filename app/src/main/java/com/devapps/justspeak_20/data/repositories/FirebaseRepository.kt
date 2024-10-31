package com.devapps.justspeak_20.data.repositories

import com.devapps.justspeak_20.data.models.Deck
import com.devapps.justspeak_20.utils.Response
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    // Function to save progress to Firestore
    suspend fun saveProgress(userId: String?, topic: String, progress: Float): Response {
        val progressData = mapOf(
            "userId" to userId,
            "topic" to topic,
            "progress" to progress
        )

        return try {
            firestore.collection("user_progress")
                .document("$userId-$topic")
                .set(progressData)
                .await()  // Use Kotlin Coroutines for asynchronous work

            Response.Success("Progress saved successfully.")
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

    // Function to get progress from Firestore
    suspend fun getProgress(userId: String?, topic: String): Map<String, Float> {
        return try {
            // Fetch all documents related to the user's progress
            val documentSnapshot = firestore.collection("user_progress")
                .whereEqualTo("userId", userId) // Match userId
                .whereEqualTo("topic", topic)
                .get()
                .await()

            // Create a map of topic to progress value
            documentSnapshot.documents.associate { document ->
                val topic = document.getString("topic") ?: "Unknown Topic" // Get the topic or default to "Unknown Topic"
                val progress = document.getDouble("progress")?.toFloat() ?: 0f // Get the progress or default to 0f
                topic to progress
            }
        } catch (e: Exception) {
            // Handle the error, or return an empty map to indicate failure
            emptyMap()
        }
    }

    suspend fun addDeck(deck: Deck): Response {
        return try {
            // Reference to the counter document in Firestore
            val counterRef = firestore.collection("counters").document("deckCounter")

            // Transaction to increment the counter and get a new deckId
            val newDeckId = firestore.runTransaction { transaction ->
                val snapshot = transaction.get(counterRef)
                val nextDeckId = snapshot.getLong("nextDeckId")?.plus(1) ?: 1
                transaction.update(counterRef, "nextDeckId", nextDeckId)
                nextDeckId.toString()
            }.await()

            // Create a map for the deck data
            val deckData = mapOf(
                "userId" to deck.deckId,
                "title" to deck.title,
                "dateCreated" to deck.dateCreated,
                "deckId" to newDeckId
            )

            // Add the new deck to the "decks" collection with the incremented deckId
            firestore.collection("decks").document(newDeckId).set(deckData).await()

            Response.Success("Deck added successfully.")
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

    suspend fun getDecksByUser(userId: String): List<Map<String, Any>> {
        return try {
            val querySnapshot = firestore.collection("decks")
                .whereEqualTo("userId", userId)
                .get()
                .await()

            // Convert each document to a Map for easier use
            querySnapshot.documents.map { document ->
                document.data ?: emptyMap()
            }
        } catch (e: Exception) {
            // Log the exception or handle it as needed
            emptyList()  // Return an empty list in case of error
        }
    }

    suspend fun deleteDeck(deckId: String): Response {
        return try {
            firestore.collection("decks").document(deckId).delete().await()
            Response.Success("Deck deleted successfully.")
        } catch (e: Exception) {
            Response.Error(e)
        }
    }
}
