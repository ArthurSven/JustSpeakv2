package com.devapps.justspeak_20.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Emergency
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.SortByAlpha
import androidx.compose.material.icons.filled.Speaker
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.material.icons.filled.Watch
import com.devapps.justspeak_20.ui.ScreenDestinations
import com.devapps.justspeak_20.ui.components.TopicItem

val topicItem = listOf(
    TopicItem(
        "Alphabet",
        Icons.Filled.SortByAlpha,
        0.0F,
        ScreenDestinations.GermanAlphabetScreen.route
    ),
    TopicItem(
        "Adjectives",
        Icons.Filled.Album,
        0.0F,
        ScreenDestinations.GermanAdjectiveScreen.route
    ),
    TopicItem(
        "Cases",
        Icons.Filled.BarChart,
        0.0F,
        ScreenDestinations.GermanCaseScreen.route
    ),
    TopicItem(
        "Nouns",
        Icons.Filled.Badge,
        0.0F,
        ScreenDestinations.GermanNounScreen.route
    ),
    TopicItem(
        "Prepositions",
        Icons.Filled.EditNote,
        0.0F,
        ScreenDestinations.GermanPrepositionScreen.route
    ),
    TopicItem(
        "Pronouns",
        Icons.Filled.Album,
        0.0F,
        ScreenDestinations.GermanPronounScreen.route
    ),
    TopicItem(
        "Sentences",
        Icons.Filled.Build,
        0.0F,
        ScreenDestinations.GermanSentenceStructureScreen.route
    ),
    TopicItem(
        "Tenses",
        Icons.Filled.Terrain,
        0.0F,
        ScreenDestinations.GermanTenseScreen.route
    ),
    TopicItem(
        "Verbs",
        Icons.Filled.Height,
        0.0F,
        ScreenDestinations.GermanVerbConjugationScreen.route
    )
)

val phraseList = listOf(
    TopicItem(
        "Introductions",
        Icons.Filled.Groups,
        0.0F,
        ScreenDestinations.GermanIntroductionScreen.route
    ),
    TopicItem(
        "Expressions",
        Icons.Filled.Speaker,
        0.0F,
        ScreenDestinations.GermanExpressionScreen.route
    ),
    TopicItem(
        "Emergencies",
        Icons.Filled.Emergency,
        0.0F,
        ScreenDestinations.GermanEmergencyScreen.route
    ),
    TopicItem(
        "Gastronomy",
        Icons.Filled.Fastfood,
        0.0F,
        ScreenDestinations.GermanEatingScreen.route
    ),
    TopicItem(
        "Questions",
        Icons.Filled.QuestionMark,
        0.0F,
        ScreenDestinations.GermanQuestionsScreen.route
    ),
    TopicItem(
        "Tell the time",
        Icons.Filled.Watch,
        0.0F,
        ScreenDestinations.GermanTimeScreen.route
    )
)

