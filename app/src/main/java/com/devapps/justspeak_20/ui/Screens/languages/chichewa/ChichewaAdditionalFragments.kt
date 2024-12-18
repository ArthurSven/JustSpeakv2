package com.devapps.justspeak_20.ui.Screens.languages.chichewa

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak_20.ui.Screens.languages.chichewa.chichewa_utility.ChichewaAdjectiveCard
import com.devapps.justspeak_20.ui.Screens.languages.chichewa.chichewa_utility.getChichewaAdjectives
import com.devapps.justspeak_20.ui.components.ChichewaAlphabetCard
import com.devapps.justspeak_20.ui.components.ChichewaTranslatableItem
import com.devapps.justspeak_20.ui.components.ChichewaVerbTranslatableItem
import com.devapps.justspeak_20.ui.components.TranslatableItem
import com.devapps.justspeak_20.utils.chichewaBodyPartsNouns
import com.devapps.justspeak_20.utils.chichewaFoodAndDrinkNouns
import com.devapps.justspeak_20.utils.chichewaPeopleNouns
import com.devapps.justspeak_20.utils.chichewaPlaceNouns
import com.devapps.justspeak_20.utils.chichewaPronouns
import com.devapps.justspeak_20.utils.chichewaToEnglishAdjectives
import com.devapps.justspeak_20.utils.chichewaToEnglishPrefixes
import com.devapps.justspeak_20.utils.germanBodyPartNouns
import com.devapps.justspeak_20.utils.germanFoodNouns
import com.devapps.justspeak_20.utils.germanPeopleNouns
import com.devapps.justspeak_20.utils.getChichewaEatingConjugation
import com.devapps.justspeak_20.utils.getChichewaSayingConjugations
import com.devapps.justspeak_20.utils.getChichewaVerbs
import com.devapps.justspeak_20.utils.getGermanAdjectives
import com.devapps.justspeak_20.utils.getGermanPlaceNouns

@Composable
fun ChichewaAdjectiveHome() {

    val adjectives = getChichewaAdjectives()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(text = "Adjectives",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Adjectives are used to describe nouns. The adjective always follows the " +
                            "noun that it is describing. In Chichewa, adjectives are formed by " +
                            "adding a prefix to an adjectival stem. The prefix changes according to " +
                            "the class of the noun it is describing. Below is a list of adjectives " +
                            "commonly used in Chichewa:",
                    color = Color.Black,
                    fontSize = 14.sp
                    )
            }

        }

        Spacer(modifier = Modifier
            .height(30.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(350.dp)
        ) {
            items(adjectives) { adjective ->
                ChichewaAdjectiveCard(adjective)
            }
        }
    }
}

@Composable
fun ChichewaNounHome() {

    val nouns = chichewaPeopleNouns()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(text = "Nouns",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Nouns are basically objects and things that we see, know and interact with. ",
                    color = Color.Black,
                    fontSize = 14.sp
                )

            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )

        Text(text = "People nouns",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(450.dp)
        ) {
            items(nouns.entries.toList()) { entry ->
                ChichewaTranslatableItem(entry.key, entry.value)
            }
        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
    }
}

@Composable
fun ChichewaPlaceNouns() {

    val nouns = chichewaPlaceNouns()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Place nouns",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        LazyColumn {
            items(nouns.entries.toList()) { entry ->
                ChichewaTranslatableItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaFoodNouns() {

    val nouns = chichewaFoodAndDrinkNouns()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Food nouns",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        LazyColumn {
            items(nouns.entries.toList()) { entry ->
                ChichewaTranslatableItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaBodyNouns() {

    val nouns = chichewaBodyPartsNouns()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Body part nouns",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        LazyColumn {
            items(nouns.entries.toList()) { entry ->
                ChichewaTranslatableItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaPronounHome() {

    val pronouns = chichewaPronouns()
    val prefixes = chichewaToEnglishPrefixes()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(text = "Pronouns",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Pronouns are used in chichewa to replace the nouns used in sentences. " +
                            "They show who or what the subject, object and indirect object is.",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
                LazyColumn(
                    modifier = Modifier
                        .height(400.dp)
                ) {
                    items(pronouns.entries.toList()) { entry ->
                        ChichewaTranslatableItem(entry.key, entry.value)
                    }
                }

        Spacer(modifier = Modifier
            .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Prefixes",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Prefixes are used to show subject of the sentence. Prefixes regularly " +
                            "are positioned a the beginning of the verb to show what the subject of " +
                            "the sentence e.g. \n \nNdikubwera which means I am coming. Ndi is a prefix " +
                            "that matches I while kubwera is the verb for to come",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(300.dp)
        ) {
            items(prefixes.entries.toList()) { entry ->
                ChichewaTranslatableItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaVerbHome() {
    val verbs = getChichewaVerbs()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(text = "Verbs",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Verbs are words that describe the action being done by a subject of a " +
                            "sentence. Below is a list of commonly used verbs in Chichewa",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }

        }
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(450.dp)
        ) {
            items(verbs.entries.toList()) { entry ->
                ChichewaTranslatableItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaVerbConjugation() {
    val eating = getChichewaEatingConjugation()
    val saying = getChichewaSayingConjugations()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(text = "Verb Conjugation",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Verb conjugation shows how verbs are used with pronouns. This section " +
                            "will show you how to apply chichewa verbs with pronouns in sentences " +
                            "using verb kudya (to eat) and kunena (to say)",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Text(
            text = "Kudya (to eat)",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(450.dp)
        ) {
            items(eating.entries.toList()) { entry ->
                ChichewaVerbTranslatableItem(entry.key, entry.value)
            }
        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Text(
            text = "Kunena (to say)",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(450.dp)
        ) {
            items(saying.entries.toList()) { entry ->
                ChichewaVerbTranslatableItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewTheseFragments() {
    ChichewaPronounHome()
}