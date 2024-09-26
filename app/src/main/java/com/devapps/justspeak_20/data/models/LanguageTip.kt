package com.devapps.justspeak_20.data.models

data class LanguageTip(
    val tipTitle: String,
    val languageTip: String
)

fun languageDailyTips() : List<LanguageTip> {
    return listOf(
        LanguageTip(
            "Surround yourself with the language",
            "Listen to music, watch movies, and read books in your target language."
        ),
        LanguageTip(
            "Find a language partner",
            "Practice speaking with a native speaker or someone who is also learning."
        ),
        LanguageTip(
            "Label objects around your home",
            "Write labels in your target language to reinforce vocabulary."
        ),
        LanguageTip(
            "Practice regularly",
            "Even short, daily practice sessions can make a big difference."
        ),
        LanguageTip(
            "Set achievable goals",
            "Break down your learning into smaller, manageable steps."
        ),
        LanguageTip(
            "Use flashcards or apps",
            "These tools can help you memorize vocabulary and grammar."
        ),
        LanguageTip(
            "Create a study schedule",
            "Allocate specific time for language learning."
        ),
        LanguageTip(
            "Review regularly",
            "Reinforce what you've learned by reviewing periodically."
        ),
        LanguageTip(
            "Find a study group or tutor",
            "Learning with others can be motivating and helpful."
        ),
        LanguageTip(
            "Learn through context",
            "Understand how words are used in sentences and phrases."
        ),
        LanguageTip(
            "Use mnemonic devices",
            "Create associations or mental tricks to remember information."
        ),
        LanguageTip(
            "Focus on pronunciation",
            "Practice speaking clearly and correctly."
        ),
        LanguageTip(
            "Stay positive and patient",
            "Learning a new language takes time and effort."
        ),
        LanguageTip(
            "Celebrate your progress",
            "Reward yourself for achieving your goals."
        ),
        LanguageTip(
            "Stay motivated",
            "Find reasons why learning the language is important to you."
        )
    )
}