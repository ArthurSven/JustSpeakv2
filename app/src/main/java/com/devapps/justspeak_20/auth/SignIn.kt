package com.devapps.justspeak_20.auth

import com.devapps.justspeak_20.data.models.UserData

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

