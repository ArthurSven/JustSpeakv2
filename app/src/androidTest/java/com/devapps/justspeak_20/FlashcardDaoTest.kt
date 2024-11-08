package com.devapps.justspeak_20

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devapps.justspeak_20.data.db.FlashcardDao
import com.devapps.justspeak_20.data.db.JustSpeakLocalDB
import com.devapps.justspeak_20.data.models.Flashcard
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FlashcardDaoTest {


    private lateinit var database: JustSpeakLocalDB
    private lateinit var flashcardDao: FlashcardDao

    @Before
    public fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            JustSpeakLocalDB::class.java
        ).allowMainThreadQueries().build()
        flashcardDao = database.flashcardDao()
    }


    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertFlashcard() = runTest {
        val flashcard = Flashcard(
            german = "Wahltag",
            english = "Election",
            date = "05-11-2024",
            createdBy = "Artska1212"
        )


        // Assuming your actual insertFlashcard method takes the Flashcard object
        flashcardDao.upsertFlashcard(flashcard)
    }

    @Test
    fun getFlashcardByUserId() {
        val userId = "Artska1212"
        flashcardDao.getFlashcardsByUserId(userId)
    }

    @Test
    fun getFlashcardByFlashcardId() {
        val flashcardId = 1
        flashcardDao.getFlashcardById(flashcardId)
    }

}