package com.devapps.justspeak_20.utils

// Data class to hold a question and its options
data class Question(
    val number: String,
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)

fun germanAdjectiveQuizQuestions() : List<Question> {
    return listOf(
        Question(
            "1.",
            "What's the German word for beautiful?",
            listOf(
                "Schon", "Schön", "Gut"
            ),
            "Schön",
        ),
        Question(
            "2.",
            "Der Hals ist ... (The neck ist long)",
            listOf(
                "Klein", "groß", "lang"
            ),
            "lang"
        ),
        Question(
            "3.",
            "Das ... Auto (The red car)",
            listOf(
                "roter", "rote", "rot"
            ),
            "rote"
        ),
        Question(
            "4.",
            "Hast du den ... Mann gesehen? (Have you seen the short man?)",
            listOf(
                "kleinen", "klein", "kleiner"
            ),
            "kleinen"
        ),
        Question(
            "5.",
            "What's the german word for slow",
            listOf(
                "Langsam", "Schnell", "Schlow"
            ),
            "Langsam"
        )
    )
}