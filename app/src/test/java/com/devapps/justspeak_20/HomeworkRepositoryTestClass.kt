package com.devapps.justspeak_20

import com.devapps.justspeak_20.data.models.Homework
import com.devapps.justspeak_20.data.repositories.HomeworkRepository
import com.devapps.justspeak_20.utils.Response
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
// Mockito imports
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any



@RunWith(MockitoJUnitRunner::class)
class HomeworkRepositoryTestClass {

    @Mock
    private lateinit var mockFirestore: FirebaseFirestore

    @Mock
    private lateinit var mockCollection: CollectionReference

    @Mock
    private lateinit var mockDocument: DocumentReference

    @Mock
    private lateinit var mockQuery: Query

    @Mock
    private lateinit var mockQuerySnapshot: QuerySnapshot

    @Mock
    private lateinit var mockDocumentSnapshot: DocumentSnapshot

    private lateinit var repository: HomeworkRepository

    @Before
    fun setup() {
        Mockito.`when`(mockFirestore.collection("homework")).thenReturn(mockCollection)
        Mockito.`when`(mockCollection.document(anyString())).thenReturn(mockDocument)
        repository = HomeworkRepository(mockFirestore)
    }

    @Test
    fun addHomework_returnsSuccess_whenFirestoreSucceeds() = runTest {
        // Arrange
        val homework = Homework(
            title = "Math HW",
            assignment = "Do problems 1-10",
            level = "Advanced",
            submittedBy = "user123",
            submitDate = "2023-10-01",
            userid = "hw123"
        )

        // Mock successful Firestore operation
        val mockTask = mock(Task::class.java) as Task<Void>
        Mockito.`when`(mockDocument.set(any())).thenReturn(mockTask as Task<Void>?)
        Mockito.`when`(mockTask.await()).thenReturn(null)

        // Act
        val result = repository.addHomework(homework)

        // Assert
        assertTrue(result is Response.Success)
    }

}