plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrainsKotlinKsp)
    alias(libs.plugins.hiltPlugin)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}

android {
    namespace = "com.devapps.justspeak_20"
    compileSdk = 34

    signingConfigs {
        create("release") {
            storeFile = file("C:/Users/asmsiska/Desktop/keystores/JustSpeakKey.jks")
            storePassword = (project.findProperty("KEYSTORE_PASSWORD") ?: "").toString()
            keyAlias = "JustSpeak"
            keyPassword = (project.findProperty("KEY_PASSWORD") ?: "").toString()
        }
    }

    defaultConfig {
        applicationId = "com.devapps.justspeak_20"
        minSdk = 29
        targetSdk = 34
        versionCode = 5
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        signingConfig = signingConfigs.getByName("release")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    bundle {
        abi {
            enableSplit = true
        }
        density {
            enableSplit = true
        }
        language {
            enableSplit = true
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.firebase.auth)
    implementation(libs.play.services.base)
    implementation(libs.play.services.auth.v2120)

    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.core.splashscreen)

    //livecycle
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)

    //Coil
    implementation(libs.coil.compose)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //okhttp
    implementation(libs.logging.interceptor)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    //datastore
    implementation(libs.androidx.datastore)
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.androidx.lifecycle.runtime.ktx.v240)
    implementation(libs.androidx.lifecycle.viewmodel.compose.v240)

    //Dependency injection
    implementation(libs.hilt.android)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.crashlytics)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.work)
    ksp(libs.androidx.hilt.compiler)
    ksp(libs.dagger.compiler)
    implementation (libs.androidx.hilt.common)
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.androidx.hilt.navigation.compose)

    //Room dependency
    implementation(libs.room.runtime.v261)
    ksp(libs.androidx.room.compiler.v261)
    implementation(libs.androidx.room.ktx.v261)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //mockito
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockk.v400)

    //kotlinx coroutines
    implementation(libs.kotlinx.coroutines.core.v132)
}