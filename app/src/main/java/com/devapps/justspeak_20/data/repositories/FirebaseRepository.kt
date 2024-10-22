package com.devapps.justspeak_20.data.repositories

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
}
