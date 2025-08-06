package com.devapps.justspeak_20.data.repositories

import com.devapps.justspeak_20.data.models.Homework
import com.devapps.justspeak_20.data.models.HomeworkResponse
import com.devapps.justspeak_20.utils.Response
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import java.util.UUID


private interface HomeworkRepositoryImpl {

    // Define methods for the HomeworkRepository

    suspend fun addHomework(homework: Homework): Response
    suspend fun getHomeworkById(homeworkid: String): HomeworkResponse?
    suspend fun getHomeworkByUserId(userid: String): List<HomeworkResponse?>
    suspend fun updateHomework(homework: HomeworkResponse): Response
    suspend fun deleteHomework(homeworkid: String, userid: String): Response
}
class HomeworkRepository(
    private val fireStore: FirebaseFirestore) : HomeworkRepositoryImpl {

    private val homeworkCollection = fireStore.collection("homework")
    override suspend fun addHomework(homework: Homework): Response {

        return try {
            val homeworkId = UUID.randomUUID().toString()

            homeworkCollection.document(homeworkId).set(
                mapOf(
                    "id" to homeworkId,
                    "title" to homework.title,
                    "assignment" to homework.assignment,
                    "submitDate" to com.google.firebase.Timestamp.now(),
                    "level" to homework.level,
                    "submittedBy" to homework.submittedBy
                )
            ).await()
            Response.Success("Homework added successfully submittedD: $homeworkId")
        } catch (e: Exception) {
            Response.Error(Exception("Error adding homework: ${e.message}"))
        }

    }

    override suspend fun getHomeworkById(homeworkid: String): HomeworkResponse? {
        return try {
            val document = homeworkCollection.document(homeworkid).get().await()
            if (document.exists()) {
                HomeworkResponse(
                    homeworkid = document.getString("id") ?: "",
                    title = document.getString("title") ?: "",
                    assignment = document.getString("assignment") ?: "",
                    submitDate = document.getDate("submitDate")?.toString() ?: "",
                    level = document.getString("level") ?: "",
                    submittedBy = document.getString("submittedBy") ?: "",
                    feedback = document.getString("feedback") ?: "",
                    grade = document.getLong("grade")?.toInt() ?: 0,
                    userid = document.getString("googleid") ?: ""
                )
            } else {
                null
            }
        } catch (e: Exception) {
            throw Exception("Failed to fetch homework: ${e.message}")
        }
    }

    override suspend fun getHomeworkByUserId(userid: String): List<HomeworkResponse?> {
        return try {
            homeworkCollection
                .whereEqualTo("googleid", userid)
                .orderBy("submitDate", Query.Direction.DESCENDING)
                .get()
                .await()
                .documents
                .mapNotNull { document ->
                    val data = document.data ?: throw Exception("Document data is null")
                    HomeworkResponse(
                        homeworkid = document.getString("id") ?: "",
                        title = data["title"] as? String ?: "",
                        assignment = data["assignment"] as? String ?: "",
                        submitDate = document.getDate("submitDate")?.toString() ?: "",
                        level = data["level"] as? String ?: "",
                        submittedBy = data["submittedBy"] as? String ?: "",
                        feedback = data["feedback"] as? String ?: "",
                        grade = (data["grade"] as? Number)?.toInt() ?: 0,
                        userid = data["googleid"] as? String ?: ""
                    )
                }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun updateHomework(homework: HomeworkResponse): Response {
        return try {
            val homeworkId = homework.homeworkid
            val updateData = mapOf(
                "title" to homework.title,
                "assignment" to homework.assignment,
                "submitDate" to com.google.firebase.Timestamp.now(),
                "level" to homework.level,
                "submittedBy" to homework.submittedBy,
                "feedback" to homework.feedback,
                "grade" to homework.grade,
                "googleid" to homework.userid
            )

            homeworkCollection.document(homeworkId).update(updateData).await()
            Response.Success("Homework updated successfully")
        } catch (e: Exception) {
            Response.Error(Exception("Error updating homework: ${e.message}"))
        }
    }

    override suspend fun deleteHomework(homeworkid: String, userid: String): Response {
       return try {
            val homework = homeworkCollection.document(homeworkid).get().await()
           val homeworkowner = homework.getString("googleid") ?: ""

            if (homeworkowner != userid) {
                return Response.Error(Exception("You are not authorized to delete this homework"))
            }
            if (!homework.exists()) {
                return Response.Error(Exception("Homework with ID $homeworkid does not exist"))
            }
            homeworkCollection.document(homeworkid).delete().await()
            Response.Success("Homework deleted successfully")
        } catch (e: Exception) {
            Response.Error(Exception("Error deleting homework: ${e.message}"))
        }
    }


}