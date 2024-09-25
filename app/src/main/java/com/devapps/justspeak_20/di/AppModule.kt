package com.devapps.justspeak_20.di

import android.app.Application
import android.content.Context
import com.devapps.justspeak_20.JustSpeakApplication
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    fun provideJustSpeakApplication() : JustSpeakApplication {
        return JustSpeakApplication()
    }

    @Provides
    @Singleton
    fun provideSignInClient(application: Application) : SignInClient {
        return Identity.getSignInClient(application)
    }

    @Provides
    @Singleton
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}