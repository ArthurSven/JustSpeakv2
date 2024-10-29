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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak_20.ui.components.ChichewaPhraseItem
import com.devapps.justspeak_20.ui.components.ChichewaTranslatableItem
import com.devapps.justspeak_20.ui.components.PhraseItem
import com.devapps.justspeak_20.utils.getChichewaCrimeEmergency
import com.devapps.justspeak_20.utils.getChichewaDiningPhrases
import com.devapps.justspeak_20.utils.getChichewaExpressionList
import com.devapps.justspeak_20.utils.getChichewaGeneralEmergencies
import com.devapps.justspeak_20.utils.getChichewaGoodbyes
import com.devapps.justspeak_20.utils.getChichewaGreetings
import com.devapps.justspeak_20.utils.getChichewaIntroductionPhrases
import com.devapps.justspeak_20.utils.getChichewaMedicalEmergency
import com.devapps.justspeak_20.utils.getChichewaQuestionKeyWords
import com.devapps.justspeak_20.utils.getChichewaQuestionPhrases
import com.devapps.justspeak_20.utils.getChichewaShoppingList
import com.devapps.justspeak_20.utils.getGermanEatingPhrases
import com.devapps.justspeak_20.utils.getGermanGoodbyes
import com.devapps.justspeak_20.utils.getGermanGreetingExpressions
import com.devapps.justspeak_20.utils.getGermanIntroductions

@Composable
fun ChichewaIntroHome() {

    val chichewaIntro = getChichewaGreetings()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
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
                    text = "In Malawian culture, politeness and courtesy is important. Learn key " +
                            "introduction phrases as ice breakers:",
                    fontSize = 14.sp,
                    color = Color.Black
                )

            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Text(text = "Greetings",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(500.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaIntro.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaGoodbyes() {

    val chichewaGoodByes = getChichewaGoodbyes()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Goodbyes",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaGoodByes.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaIntroExpressions() {

    val chichewaIntroExpressionPhrase = getChichewaIntroductionPhrases()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Expressions",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaIntroExpressionPhrase.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaExpressionHome() {

    val chichewaExpression = getChichewaExpressionList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
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
                    text = "Expressions help us form common sentences we use in a language, below you " +
                            "will find a list of common basic phrases you will often hear in your chichewa" +
                            "learning journey:",
                    fontSize = 14.sp,
                    color = Color.Black
                )

            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(400.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaExpression.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaGastronomyHome() {

    val chichewaEatingPhrases = getChichewaDiningPhrases()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Dining",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
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
                    text = "Learn key phrases which can come in handy when you either go shopping or" +
                            " dining in chichewa speaking areas:",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaEatingPhrases.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaShopping() {

    val chichewaShopping = getChichewaShoppingList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Shopping",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaShopping.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaEmergencyHome() {
    val chichewaEmergencyPhrases = getChichewaGeneralEmergencies()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Emergencies",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
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
                    text = "Emergencies can occur without warning, however you should not be caught " +
                            "off guard when it happens. Below you will learn general emergency " +
                            "phrases as well as medical and crime related",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaEmergencyPhrases.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaMedicalEmergencyScreen() {

    val chichewaMedicalEmergency = getChichewaMedicalEmergency()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Medical Emergency",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaMedicalEmergency.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaCrimeEmergencyScreen() {

    val chichewaCrimeEmergency = getChichewaCrimeEmergency()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Crime Emergency",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaCrimeEmergency.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaQuestionHome() {
    val chichewaKeyWords = getChichewaQuestionKeyWords()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Questions",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
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
                    text = "Questions form an essential part of a language. They allow people to " +
                            "acquire pieces of information from others. This section focuses on how " +
                            "questions are formed and example questions in chichewa",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Text(text = "Question Key words",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
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
                    text = "In chichewa, questions can be formulated in different ways, below" +
                            " is a list of words to look out for to be able to tell if it is a question" +
                            " or not. Many of these can be added as prefixes to verbs:",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            items(chichewaKeyWords.entries.toList()) { entry ->
                ChichewaTranslatableItem(entry.key, entry.value)
            }
        }
    }
}

@Composable
fun ChichewaQuestionExample() {
    val chichewaExample = getChichewaQuestionPhrases()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Question Examples",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaExample.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }
    }
}