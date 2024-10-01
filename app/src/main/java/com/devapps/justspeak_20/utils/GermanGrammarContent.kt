package com.devapps.justspeak_20.utils

import androidx.compose.runtime.Composable

@Composable
fun getGermanAlphabetData(): List<String> {
    return listOf(
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Ä", "Ö", "Ü", "ß"
    )
}

@Composable
fun getGermanAdjectives(): Map<String, List<String>> {
    return mapOf(
        "German" to listOf("Alt", "Neu", "Jung", "Groß", "Klein", "Schön", "Hässlich", "Früh", "Spät", "Leicht",
            "Schwierig", "Langsam", "Schnell", "Lang", "Kurz", "Dick", "Dünn"),
        "English" to listOf("Old", "New", "Young", "Tall", "Short/Small", "Beautiful", "Ugly", "Early", "Late",
            "Easy", "Hard", "Slow", "Fast", "Long", "Short", "Fat", "Thin")
    )
}


