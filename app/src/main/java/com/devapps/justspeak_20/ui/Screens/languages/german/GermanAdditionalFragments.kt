package com.devapps.justspeak_20.ui.Screens.languages.german

import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak_20.ui.components.CaseParagraph
import com.devapps.justspeak_20.ui.components.GermanDefiniteArticleTable
import com.devapps.justspeak_20.ui.components.GermanIndefiniteArticleTable
import com.devapps.justspeak_20.ui.components.GrammarRow
import com.devapps.justspeak_20.ui.components.TranslatableItem
import com.devapps.justspeak_20.ui.components.bestimmteArtikeln
import com.devapps.justspeak_20.ui.components.bestimmteArtikelnExamples
import com.devapps.justspeak_20.ui.components.makeBulletedList
import com.devapps.justspeak_20.ui.components.unbestimmteArtikeln
import com.devapps.justspeak_20.ui.components.unbestimmteArtikelnExamples
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.utils.germanAccusativePrepositions
import com.devapps.justspeak_20.utils.germanAdjectiveQuizQuestions
import com.devapps.justspeak_20.utils.germanBodyPartNouns
import com.devapps.justspeak_20.utils.germanCaseQuizQuestions
import com.devapps.justspeak_20.utils.germanDativePrepositions
import com.devapps.justspeak_20.utils.germanFoodNouns
import com.devapps.justspeak_20.utils.germanGenitivePrepositions
import com.devapps.justspeak_20.utils.germanNounQuizQuestions
import com.devapps.justspeak_20.utils.germanPeopleNouns
import com.devapps.justspeak_20.utils.germanPrepositionQuestions
import com.devapps.justspeak_20.utils.getGermanPlaceNouns
import java.util.Locale

@Composable
fun GermanArticleHome() {
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

        Text(text = "Articles - Artikeln",
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
                    text = "We need to understand that german nouns have genders. " +
                        " They can either be Masculine (der), Feminine (die) and neutral (das)." +
                        " These are also known as articles. There ae two types of articles:",
                    color = Color.Black,
                    fontSize = 14.sp
                    )

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
                Text(text = "Definite Articles - Bestimmte Artikeln",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(5.dp)
                )
                Text(
                    text = "These are the articles that correspond to english (the). They fall in 4 " +
                            "categories namely masculine, feminine, neutral and plural:",
                    color = Color.Black,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier
                    .height(5.dp)
                )
                Text(
                    text = makeBulletedList(bestimmteArtikeln),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                Text(
                    text = "Below are example sentences with definite articles:",
                    color = Color.Black,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                Text(
                    text = makeBulletedList(bestimmteArtikelnExamples),
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(15.dp)
                )
                GermanDefiniteArticleTable()
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
                Text(text = "Indefinite Articles - Unbestimmte Artikeln",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(5.dp)
                )
                Text(
                    text = "These are the articles that correspond to english (a). They fall in 3 " +
                            "categories namely masculine, feminine and neutral:",
                    color = Color.Black,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier
                    .height(5.dp)
                )
                Text(
                    text = makeBulletedList(unbestimmteArtikeln),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                Text(
                    text = "Below are example sentences with indefinite articles:",
                    color = Color.Black,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                Text(
                    text = makeBulletedList(unbestimmteArtikelnExamples),
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(15.dp)
                )
                GermanIndefiniteArticleTable()
            }

        }
    }
}

@Composable
fun GermanCaseHome() {
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

        Text(
            text = "Cases - Fälle",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
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
                    text = "Cases are the four groups in which German sentences fall under. Each " +
                            "case has a different emphasis on the sentence. A case can determine the" +
                            " article a noun takesBelow are the cases explained:",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        CaseParagraph(
            "Nominativ (Nominative)",
            "This case shows the subject of the sentence or who the sentence is about.",
            "Die Sonne scheint (The sun shines)\n \n - Die Sonne is the subject as the " +
                    "sentence is about the sun."
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        CaseParagraph(
            "Akkusativ (Accusative)",
            "This case shows the direct object of the sentence or what is directly " +
                    "affected by the verb.",
            "Ich kaufe einen neuen Computer (I am buying a new computer)\n \n - den Computer is " +
                    "the object as it is being bought. Ich is the subject."
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        CaseParagraph(
            "Dativ (Dative)",
            "This case shows the indirect object of a sentence or the item which is" +
                    "indirectly affected.",
            "Ich habe dem Mann den Ball geworfen (I threw the ball to the man)\n \n - dem Mann" +
                    " is the indirect object as the ball was thrown to him, den Ball was thrown " +
                    "making the ball an object and I threw the ball making Ich the subject."
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        CaseParagraph(
            "Genitiv (Genitive)",
            "This case shows possession of something in a sentence",
            "Das Auto der Frau ist Kaputt (The woman's car is broken)\n \n - der Frau shows " +
                    "ownership. The car belongs to the woman"
        )
    }
}

@Composable
fun GermanCaseQuiz() {

    val germanCaseQuestions = germanCaseQuizQuestions()

    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanCaseQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanCaseQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
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
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Cases and Articles Quiz",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                score?.let {

                    if (it == germanCaseQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanCaseQuestions.size}",
                            color = Color.Magenta,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanCaseQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanCaseQuestions.size}",
                            fontSize = 20.sp,
                            color = Color.Red,
                            fontWeight = FontWeight.Bold

                        )
                    }
                }
                // LazyColumn to display questions
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    items(germanCaseQuestions.size) { j ->
                        val adjectiveQuizList = germanCaseQuestions[j]
                        // Display the current question
                        Text(
                            text = "${adjectiveQuizList.number} ${adjectiveQuizList.question}",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )

                        // Display the options as radio buttons
                        adjectiveQuizList.options.forEach { option ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedOptions[j] == option,
                                    onClick = {
                                        selectedOptions[j] = option
                                        // Reset score and showCorrectAnswers state when an option is changed
                                        score = null
                                        showCorrectAnswers = false
                                    },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Black,
                                        unselectedColor = Color.Gray
                                    )
                                )
                                Text(text = option,
                                    color = Color.Black
                                )
                            }
                        }
                        if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                            Text(
                                text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                // Submit Button
                Button(
                    onClick = {
                        var tempScore = 0
                        for (i in germanCaseQuestions.indices) {
                            if (selectedOptions[i] == germanCaseQuestions[i].correctAnswer) {
                                tempScore++
                            }
                        }
                        score = tempScore
                        showCorrectAnswers = true
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzureBlue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(text = "Submit",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun GermanNounHome(textToSpeech: TextToSpeech) {

    val germanPeopleNouns = germanPeopleNouns()

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

        Text(text = "Nouns - Substansive",
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
                    text = "Nouns are basically objects and things that we see and know. In German " +
                            "nouns have genders which can get tricky for many english speakers as english " +
                            "words do not have genders. It is important to learn each German noun with its" +
                            " gender in oder to learn the genders easily. \n \nAnother tip is to capitalise nouns." +
                            " In this chapter, you will learn about significant nouns as well as tips and " +
                            "tricks to remembering some noun genders.",
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
                        .height(300.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(germanPeopleNouns.entries.toList()) { entry ->
                        TranslatableItem(entry.key ,entry.value,textToSpeech)
                    }
                }
        Spacer(modifier = Modifier
            .height(20.dp)
        )

    }
}

@Composable
fun GermanPlaceNouns(textToSpeech: TextToSpeech) {

    val germanPlaceNouns = getGermanPlaceNouns()
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
        LazyColumn(
            modifier = Modifier
                .height(400.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanPlaceNouns.entries.toList()) { entry ->
                TranslatableItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanFoodNouns(textToSpeech: TextToSpeech) {

    val germanFoodNouns = germanFoodNouns()
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
        LazyColumn(
            modifier = Modifier
                .height(400.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanFoodNouns.entries.toList()) { entry ->
                TranslatableItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanBodyNouns(textToSpeech: TextToSpeech) {

    val germanBodyNouns = germanBodyPartNouns()
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
        LazyColumn(
            modifier = Modifier
                .height(400.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanBodyNouns.entries.toList()) { entry ->
                TranslatableItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanNounQuiz() {

    val germanCaseQuestions = germanNounQuizQuestions()

    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanCaseQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanCaseQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
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
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Noun Quiz",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                score?.let {

                    if (it == germanCaseQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanCaseQuestions.size}",
                            color = Color.Magenta,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanCaseQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanCaseQuestions.size}",
                            fontSize = 20.sp,
                            color = Color.Red,
                            fontWeight = FontWeight.Bold

                        )
                    }
                }
                // LazyColumn to display questions
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    items(germanCaseQuestions.size) { j ->
                        val adjectiveQuizList = germanCaseQuestions[j]
                        // Display the current question
                        Text(
                            text = "${adjectiveQuizList.number} ${adjectiveQuizList.question}",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )

                        // Display the options as radio buttons
                        adjectiveQuizList.options.forEach { option ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedOptions[j] == option,
                                    onClick = {
                                        selectedOptions[j] = option
                                        // Reset score and showCorrectAnswers state when an option is changed
                                        score = null
                                        showCorrectAnswers = false
                                    },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Black,
                                        unselectedColor = Color.Gray
                                    )
                                )
                                Text(text = option,
                                    color = Color.Black
                                )
                            }
                        }
                        if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                            Text(
                                text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                // Submit Button
                Button(
                    onClick = {
                        var tempScore = 0
                        for (i in germanCaseQuestions.indices) {
                            if (selectedOptions[i] == germanCaseQuestions[i].correctAnswer) {
                                tempScore++
                            }
                        }
                        score = tempScore
                        showCorrectAnswers = true
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzureBlue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(text = "Submit",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun GermanPrepositionHome() {
    val germaAccusativePrepositions = germanAccusativePrepositions()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Prepositions - Präpositionen",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
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
                    text = "Prepositions connect a noun to the sentence body, they also determine the case" +
                            " of the noun, article and can equally signal whether a noun is stationery " +
                            "or moving. \n \n There are 4 groups of prepositions namely accusative, " +
                            "dative, genitive and two-way:",
                    color = Color.Black,
                    fontSize = 14.sp
                )

            }

        }
        Spacer(
            modifier = Modifier
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
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Accusative prepositions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "These are the prepositions that go with accusative case only. They usually" +
                            "signal something is moving:",
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                LazyColumn(
                    modifier = Modifier
                        .height(420.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(germaAccusativePrepositions.entries.toList()) { entry ->
                        GrammarRow(entry.key , entry.value)
                    }
                }
            }
        }
    }
}

@Composable
fun GermanDativePreposition() {
    val germanDativePrepositions = germanDativePrepositions()
    val germanGenitivePrepositions = germanGenitivePrepositions()
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
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Dative prepositions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(text = "These are the prepositions that go with dative case only. They usually" +
                        "signal something is stationary or not moving:",
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                LazyColumn(
                    modifier = Modifier
                        .height(400.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(germanDativePrepositions.entries.toList()) { entry ->
                        GrammarRow(entry.key , entry.value)
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
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
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Genitive prepositions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text( text = "These are the prepositions that go with genitive case only, " +
                        "genitive only shows ownership:",
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                LazyColumn(
                    modifier = Modifier
                        .height(400.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(germanGenitivePrepositions.entries.toList()) { entry ->
                        GrammarRow(entry.key , entry.value)
                    }
                }
            }
        }
    }
}

@Composable
fun GermanPrepositionQuiz() {

    val germanPrepositionQuestions = germanPrepositionQuestions()

    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanPrepositionQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanPrepositionQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
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
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Noun Quiz",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                score?.let {

                    if (it == germanPrepositionQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanPrepositionQuestions.size}",
                            color = Color.Magenta,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanPrepositionQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanPrepositionQuestions.size}",
                            fontSize = 20.sp,
                            color = Color.Red,
                            fontWeight = FontWeight.Bold

                        )
                    }
                }
                // LazyColumn to display questions
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    items(germanPrepositionQuestions.size) { j ->
                        val adjectiveQuizList = germanPrepositionQuestions[j]
                        // Display the current question
                        Text(
                            text = "${adjectiveQuizList.number} ${adjectiveQuizList.question}",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )

                        // Display the options as radio buttons
                        adjectiveQuizList.options.forEach { option ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedOptions[j] == option,
                                    onClick = {
                                        selectedOptions[j] = option
                                        // Reset score and showCorrectAnswers state when an option is changed
                                        score = null
                                        showCorrectAnswers = false
                                    },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Black,
                                        unselectedColor = Color.Gray
                                    )
                                )
                                Text(text = option,
                                    color = Color.Black
                                )
                            }
                        }
                        if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                            Text(
                                text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                // Submit Button
                Button(
                    onClick = {
                        var tempScore = 0
                        for (i in germanPrepositionQuestions.indices) {
                            if (selectedOptions[i] == germanPrepositionQuestions[i].correctAnswer) {
                                tempScore++
                            }
                        }
                        score = tempScore
                        showCorrectAnswers = true
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzureBlue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(text = "Submit",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CheckFragments() {
    GermanPrepositionHome()
}