package com.devapps.justspeak_20.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devapps.justspeak_20.data.repositories.FirebaseRepository
import com.devapps.justspeak_20.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgressViewModel @Inject constructor(private val firebaseRepository: FirebaseRepository)
    : ViewModel() {

    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> get() = _progress

    private val _saveProgressResponse = MutableStateFlow<Response?>(null)
    val saveProgressResponse: StateFlow<Response?> get() = _saveProgressResponse

    // Function to save progress
    fun saveUserProgress(userId: String, topicId: String, progress: Float) {


        viewModelScope.launch {

            val result = firebaseRepository.saveProgress(userId, topicId, progress)

            _saveProgressResponse.value = when (result) {
                is Response.Success -> {
                    // Handle success case
                    Response.Success("Progress saved successfully.")
                }
                is Response.Error -> {
                    // Handle error case
                    Response.Error(result.error)
                }
            }
        }
    }


    // Function to fetch progress
    fun fetchUserProgress(userId: String, topicId: String) {
        viewModelScope.launch {
            try {
                val fetchedProgress = firebaseRepository.getProgress(userId, topicId) ?: 0f
                _progress.value = fetchedProgress
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}