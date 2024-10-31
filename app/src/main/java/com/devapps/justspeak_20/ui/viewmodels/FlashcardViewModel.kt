package com.devapps.justspeak_20.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devapps.justspeak_20.data.models.Deck
import com.devapps.justspeak_20.data.repositories.FirebaseRepository
import com.devapps.justspeak_20.utils.AddDeckResult
import com.devapps.justspeak_20.utils.AddDeckState
import com.devapps.justspeak_20.utils.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class FlashcardViewModel @Inject constructor(
  val  firebaseRepository: FirebaseRepository
) : ViewModel() {

    private val _decks = MutableLiveData<List<Map<String, Any>>>()
    val decks: LiveData<List<Map<String, Any>>> get() = _decks

    private val _createdBy = MutableStateFlow<String>("")
    val createdBy: StateFlow<String> = _createdBy

    private val _responseMessage = MutableStateFlow<String>("")
    val responseMessage: StateFlow<String> get() = _responseMessage

    private val _addDeckState = MutableStateFlow(AddDeckState())
    val addDeckState = _addDeckState.asStateFlow()


fun getDecksByUserID(userId: String) {
    viewModelScope.launch {
        val deckResponse = firebaseRepository.getDecksByUser(userId)
        _decks.value = deckResponse
    }
}
    fun addDeck(deck: Deck) {
        viewModelScope.launch {
            val addDeckResponse = firebaseRepository.addDeck(deck)
            when(addDeckResponse) {
                is Response.Success -> {
                    onAddDeckResult(
                        AddDeckResult(
                            deck,
                            errorMessage = null
                        )
                    )
                }
                is Response.Error -> {
                    onAddDeckResult(
                        AddDeckResult(
                            deck,
                            errorMessage = addDeckResponse.error.message
                        )
                    )
                }
            }
        }
    }

    fun onAddDeckResult(result: AddDeckResult) {
        _addDeckState.update {
            it.copy(
                isSuccessful = result.errorMessage == null,
                error = result.errorMessage
            )
        }
    }

    suspend fun getDecksByUserId(userId: String) : List<Map<String, Any>> {
            return firebaseRepository.getDecksByUser(userId)
    }
}