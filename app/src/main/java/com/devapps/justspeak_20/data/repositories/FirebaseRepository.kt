package com.devapps.justspeak_20.data.repositories

import com.devapps.justspeak_20.utils.Response
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    // Function to save progress to Firestore
    suspend fun saveProgress(userId: String, topicId: String, progress: Float): Response {
        val progressData = mapOf(
            "userId" to userId,
            "topicId" to topicId,
            "progress" to progress
        )

        return try {
            firestore.collection("user_progress")
                .document("$userId-$topicId")
                .set(progressData)
                .await()  // Use Kotlin Coroutines for asynchronous work

            Response.Success("Progress saved successfully.")
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

    // Function to get progress from Firestore
    suspend fun getProgress(userId: String, topicId: String): Float? {
        return try {
            val document = firestore.collection("user_progress")
                .document("$userId-$topicId")
                .get()
                .await()

            document.getDouble("progress")?.toFloat() // Convert retrieved double to float
        } catch (e: Exception) {
            // Handle the error, or return null to indicate failure
            null
        }
    }
}