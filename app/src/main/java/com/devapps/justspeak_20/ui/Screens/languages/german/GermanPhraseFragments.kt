package com.devapps.justspeak_20.ui.Screens.languages.german

import android.speech.tts.TextToSpeech
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak_20.ui.components.PhraseItem
import com.devapps.justspeak_20.ui.components.TranslatableItem
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.utils.germanDiningQuestions
import com.devapps.justspeak_20.utils.germanEmergencyQuestions
import com.devapps.justspeak_20.utils.germanExpressionQuestions
import com.devapps.justspeak_20.utils.germanIntroductionQuestions
import com.devapps.justspeak_20.utils.germanNounQuizQuestions
import com.devapps.justspeak_20.utils.germanPeopleNouns
import com.devapps.justspeak_20.utils.getGermanCrimeEmergencyPhrases
import com.devapps.justspeak_20.utils.getGermanEatingPhrases
import com.devapps.justspeak_20.utils.getGermanEmergencyPhrases
import com.devapps.justspeak_20.utils.getGermanExpressions
import com.devapps.justspeak_20.utils.getGermanGoodbyes
import com.devapps.justspeak_20.utils.getGermanGreetingExpressions
import com.devapps.justspeak_20.utils.getGermanIntroductions
import com.devapps.justspeak_20.utils.getGermanIntroductoryPhrases
import com.devapps.justspeak_20.utils.getGermanMedicalEmergencyPhrases
import com.devapps.justspeak_20.utils.getGermanShoppingPhrases


@Composable
fun GermanPhraseIntroHome(textToSpeech: TextToSpeech) {

    val germanIntroPhrase = getGermanIntroductions()

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
                    text = "In German culture, it is important to introduce yourself when you arrive" +
                            "at a place where there's people. This section will take you through " +
                            "introductions and greetings used in the German speaking world:",
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
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .height(300.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanIntroPhrase.entries.toList()) { entry ->
                PhraseItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanGoodbyes(textToSpeech: TextToSpeech) {

    val germanGoodbyePhrase = getGermanGoodbyes()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
            modifier = Modifier
                .height(450.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanGoodbyePhrase.entries.toList()) { entry ->
                PhraseItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanIntroExpressions(textToSpeech: TextToSpeech) {

    val germanIntroExpressionPhrase = getGermanGreetingExpressions()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
            modifier = Modifier
                .height(450.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanIntroExpressionPhrase.entries.toList()) { entry ->
                PhraseItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanIntroPhrases(textToSpeech: TextToSpeech) {

    val germanIntroPhrase = getGermanIntroductoryPhrases()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
            modifier = Modifier
                .height(450.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanIntroPhrase.entries.toList()) { entry ->
                PhraseItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanIntroductionQuiz() {

    val germanCaseQuestions = germanIntroductionQuestions()

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
                    text = "Introduction Quiz",
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
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanCaseQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanCaseQuestions.size}",
                            fontSize = 18.sp,
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
                            fontSize = 14.sp,
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
                                    color = Color.Black,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                            Text(
                                text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.Red,
                                fontSize = 14.sp,
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
fun GermanExpressionHome(textToSpeech: TextToSpeech) {

    val germanExpressions = getGermanExpressions()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Expressions",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanExpressions.entries.toList()) { entry ->
                PhraseItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanExpressionQuiz() {

    val germanCaseQuestions = germanExpressionQuestions()

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
                    text = "Expression Quiz",
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
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanCaseQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanCaseQuestions.size}",
                            fontSize = 18.sp,
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
                            fontSize = 14.sp,
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
                                    color = Color.Black,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                            Text(
                                text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.Red,
                                fontSize = 14.sp,
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
fun GermanEmergencyHome(textToSpeech: TextToSpeech) {

    val germanEmergency = getGermanEmergencyPhrases()

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
                            "off guard when it happens in the German speaking world. Below you will " +
                            "learn general emergency phrases as well as medical and crime related",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

        }
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanEmergency.entries.toList()) { entry ->
                PhraseItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanMedicalEmergency(textToSpeech: TextToSpeech) {

    val germanMedicalEmergency = getGermanMedicalEmergencyPhrases()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Medical Emergencies",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(germanMedicalEmergency.entries.toList()) { entry ->
                        PhraseItem(entry.key ,entry.value,textToSpeech)
                    }
                }
            }
    }
}

@Composable
fun GermanCrimeEmergency(textToSpeech: TextToSpeech) {

    val germanCrimeEmergency = getGermanCrimeEmergencyPhrases()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Crime Emergencies",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(germanCrimeEmergency.entries.toList()) { entry ->
                        PhraseItem(entry.key ,entry.value,textToSpeech)
                    }
                }
            }
    }
}

@Composable
fun GermanEmergencyQuiz() {

    val germanCaseQuestions = germanEmergencyQuestions()

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
                    text = "Emergency Quiz",
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
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanCaseQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanCaseQuestions.size}",
                            fontSize = 18.sp,
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
                            fontSize = 14.sp,
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
                                    color = Color.Black,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                            Text(
                                text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.Red,
                                fontSize = 14.sp,
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
fun GermanGastronomyHome(textToSpeech: TextToSpeech) {

    val germanEatingPhrases = getGermanEatingPhrases()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Dining and Shopping",
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
                    text = "Dining and shopping are essential part of modern day life. Perhaps you" +
                            " fancy a good dinner or a shopping spree in the German speaking world, this" +
                            " section covers both dining out and shopping:",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

        }
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(germanEatingPhrases.entries.toList()) { entry ->
                PhraseItem(entry.key ,entry.value,textToSpeech)
            }
        }
    }
}

@Composable
fun GermanShopping(textToSpeech: TextToSpeech) {

    val germanShoppingPhrases = getGermanShoppingPhrases()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Shopping",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(germanShoppingPhrases.entries.toList()) { entry ->
                    PhraseItem(entry.key ,entry.value,textToSpeech)
                }
            }
        }
    }
}

@Composable
fun GermanGastronomyQuiz() {

    val germanCaseQuestions = germanDiningQuestions()

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
                    text = "Gastronomy Quiz",
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
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanCaseQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanCaseQuestions.size}",
                            fontSize = 18.sp,
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
                            fontSize = 14.sp,
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
                                    color = Color.Black,
                                    fontSize = 14.sp
                                )
                            }
                        }
                        if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                            Text(
                                text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.Red,
                                fontSize = 14.sp,
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