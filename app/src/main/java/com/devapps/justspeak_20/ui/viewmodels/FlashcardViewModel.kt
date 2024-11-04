package com.devapps.justspeak_20.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devapps.justspeak_20.data.models.Flashcard
import com.devapps.justspeak_20.data.repositories.FirebaseRepository
import com.devapps.justspeak_20.data.repositories.FlashcardRepository
import com.devapps.justspeak_20.utils.Response
import com.devapps.justspeak_20.utils.UpsertFlashCardState
import com.devapps.justspeak_20.utils.UpsertFlashcardResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlashcardViewModel @Inject constructor(
  val  flashcardRepository: FlashcardRepository
) : ViewModel() {

  private val _upsertResultState = MutableStateFlow(UpsertFlashCardState())
  val upsertFlashcardResultState = _upsertResultState.asStateFlow()

  private val _userFlashcards = MutableStateFlow<List<Flashcard>>(emptyList())
  val userFlashcards = _userFlashcards.asStateFlow()

  private val _createdBy = MutableStateFlow("")
  val createdBy: StateFlow<String> = _createdBy

  private val _germanFlashcard = MutableStateFlow("")
  val germanFlashcard: StateFlow<String> = _germanFlashcard.asStateFlow()

  private val _englishTranslation = MutableStateFlow("")
  val englishTranslation: StateFlow<String> = _englishTranslation.asStateFlow()

  init {
      viewModelScope.launch {
        getFlashcardsByUserId(_createdBy.value)
      }
  }

  fun setCreatedBy(userId: String) {
    _createdBy.value = userId
    viewModelScope.launch {
      getFlashcardsByUserId(userId)
    }

  }

  fun resetForm() {
    _germanFlashcard.value = ""
    _englishTranslation.value = ""
  }

  fun updateGermanFlashcard(value: String) {
    _germanFlashcard.value = value
  }

  fun updateEnglishTranslation(value: String) {
    _englishTranslation.value = value
  }

  suspend fun getFlashcardsByUserId(userId: String) {
    viewModelScope.launch {
      flashcardRepository.getFlashcardsByUserId(userId).collect {
        flashCards ->
        _userFlashcards.value = flashCards
      }
    }
  }

  suspend fun upsertFlashcard(flashcard: Flashcard) {
    viewModelScope.launch {
      val result = flashcardRepository.upsertFlashcard(flashcard)
      when(result) {
        is Response.Success -> {
          onUpsertResult(
            UpsertFlashcardResult(
              flashcard,
              errorMessage = null
            )
          )
        }
        is Response.Error -> {
          onUpsertResult(
            UpsertFlashcardResult(
              data = flashcard,
              errorMessage = result.error.message
            )
          )
        }
      }
    }
  }

  private fun onUpsertResult(result: UpsertFlashcardResult) {
    _upsertResultState.update {
      it.copy(
        isSuccessful = result.errorMessage == null,
        error = result.errorMessage
      )
    }
  }

  suspend fun deleteFlashcard(flashcard: Flashcard) {
    return flashcardRepository.deleteFlashcard(flashcard)
  }

  fun getFlashcardById(flashcardId: Int) : Flow<Flashcard?> {
      return flashcardRepository.getFlashcardById(flashcardId)
  }

  fun resetState() {
    _upsertResultState.update {
      UpsertFlashCardState()
    }
  }

}