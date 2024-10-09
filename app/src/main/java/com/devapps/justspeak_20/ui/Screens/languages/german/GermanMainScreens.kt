package com.devapps.justspeak_20.ui.Screens.languages.german

import android.graphics.Bitmap
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.devapps.justspeak_20.R
import com.devapps.justspeak_20.data.models.UserData
import com.devapps.justspeak_20.ui.ScreenDestinations
import com.devapps.justspeak_20.ui.components.AlphabetCard
import com.devapps.justspeak_20.ui.components.LanguageProgressCard
import com.devapps.justspeak_20.ui.components.TopicCard
import com.devapps.justspeak_20.ui.components.TranslatableItem
import com.devapps.justspeak_20.ui.components.caseTabItems
import com.devapps.justspeak_20.ui.components.nounTabItems
import com.devapps.justspeak_20.ui.components.prepositionTabItems
import com.devapps.justspeak_20.ui.components.pronounTabItems
import com.devapps.justspeak_20.ui.components.sentenceTabItems
import com.devapps.justspeak_20.ui.components.tabItems
import com.devapps.justspeak_20.ui.components.tenseTabItems
import com.devapps.justspeak_20.ui.components.verbTabItems
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.ui.theme.grau
import com.devapps.justspeak_20.utils.GermanDefEndTable
import com.devapps.justspeak_20.utils.GermanIndEndTable
import com.devapps.justspeak_20.utils.GermanVerbList
import com.devapps.justspeak_20.utils.germanAdjectiveQuizQuestions
import com.devapps.justspeak_20.utils.getGermanAdjectives
import com.devapps.justspeak_20.utils.getGermanAlphabetData
import com.devapps.justspeak_20.utils.phraseList
import com.devapps.justspeak_20.utils.topicItem
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanLanguageScreens(justSpeakMainNavController: NavController, userData: UserData?) {
    Scaffold(
        topBar = {
            TopAppBar(title = { /*TODO*/ },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = null, tint = Color.Black)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                actions = {
                    if(userData?.userProfileUrl != null) {
                        val req = ImageRequest.Builder(LocalContext.current)
                            .data(userData.userProfileUrl)
                            .bitmapConfig(Bitmap.Config.RGB_565)
                            .allowHardware(false)
                            .build()
                        AsyncImage(
                            model = req,
                            contentDescription = "${userData.username}'s profile picture",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Image(
                            painter = painterResource(R.drawable.no_profile),
                            contentDescription = "Arthur's profile picture",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }

                })
        }
    ) { it ->
            Column(
                modifier = Modifier
                    .padding(it)
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(grau)) {
                    GermanMainNavigation()
                }
            }
    }
}

@Composable
fun GermanMainNavigation() {

    val germanScreensNavController = rememberNavController()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val textToSpeech = remember {
        var tts: TextToSpeech? = null
       tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
               val result = tts?.setLanguage(Locale.GERMAN)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "German language not supported")
                }
            } else {
                Log.e("TTS", "Initialization failed")
            }
        }
        tts
    }

    DisposableEffect(Unit) {
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }

    NavHost(germanScreensNavController, startDestination = ScreenDestinations.GermanHomeScreen.route) {
        composable(ScreenDestinations.GermanHomeScreen.route) {
            GermanLandingScreen(germanScreensNavController)
        }
        composable(ScreenDestinations.GermanAlphabetScreen.route) {
            GermanAlphabet(textToSpeech)
        }
        composable(ScreenDestinations.GermanAdjectiveScreen.route) {
            GermanAdjectives()
        }
        composable(ScreenDestinations.GermanCaseScreen.route) {
            GermanCases()
        }
        composable(ScreenDestinations.GermanNounScreen.route) {
            GermanNouns()
        }
        composable(ScreenDestinations.GermanPrepositionScreen.route) {
            GermanPrepositions()
        }
        composable(ScreenDestinations.GermanPronounScreen.route) {
            GermanPronouns()
        }
        composable(ScreenDestinations.GermanSentenceStructureScreen.route) {
            GermanSentenceStructure()
        }
        composable(ScreenDestinations.GermanTenseScreen.route) {
            GermanTenses()
        }
        composable(ScreenDestinations.GermanVerbConjugationScreen.route) {
            GermanVerbs()
        }
        //Phrases
        composable(ScreenDestinations.GermanIntroductionScreen.route) {
            GermanIntroduction()
        }
        composable(ScreenDestinations.GermanExpressionScreen.route) {
            GermanExpressions()
        }
        composable(ScreenDestinations.GermanEmergencyScreen.route) {
            GermanEmergencies()
        }
    }
}

@Composable
fun GermanLandingScreen(germanScreensNavController: NavController) {
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 10.dp, end = 10.dp)
    ) {
        Spacer(
            modifier = Modifier
            .height(50.dp)
        )
            LanguageProgressCard()
        Spacer(
            modifier = Modifier
                .height(30.dp)
        )
        Text(text = "Grammar",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
            )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        LazyRow{
            items(topicItem.size) { i ->
                val listItem = topicItem[i]
                TopicCard(
                    selected = selectedItemIndex == i,
                    title = listItem.topicTitle,
                    icon = listItem.topicIcon,
                    percent = listItem.topicPercent,
                    onClick = {
                        germanScreensNavController.navigate(listItem.topicRoute)
                    }
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(40.dp)
        )
        Text(text = "Phrases",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        LazyRow{
            items(phraseList.size) { i ->
                val listItem = phraseList[i]
                TopicCard(
                    selected = selectedItemIndex == i,
                    title = listItem.topicTitle,
                    icon = listItem.topicIcon,
                    percent = listItem.topicPercent,
                    onClick = {
                        germanScreensNavController.navigate(listItem.topicRoute)
                    })
            }
        }
    }
}

@Composable
fun GermanAlphabet(textToSpeech: TextToSpeech) {
    // Dispose the TextToSpeech instance when no longer needed
    DisposableEffect(Unit) {
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }

    val germanAlphabetData = getGermanAlphabetData()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Alphabet - Das Alphabet",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(
            text = "This section takes you through the German alphabet. There ae German letters and" +
                " audio for you to practice listening.",
            fontSize = 14.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        //add lazy column here
        LazyColumn {
            items(germanAlphabetData) { letter ->
                AlphabetCard(letter = letter, textToSpeech = textToSpeech)
            }
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GermanAdjectives() {

    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        tabItems.size
    }

    val textToSpeech = remember {
        var tts: TextToSpeech? = null
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale.GERMAN)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "German language not supported")
                }
            } else {
                Log.e("TTS", "Initialization failed")
            }
        }
        tts
    }

    DisposableEffect(Unit) {
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
        .fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White
            ) {
            tabItems.fastForEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                            item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when(page) {
                0 -> GermanAdjectiveHome(textToSpeech)
                1 -> GermanAdjectiveEndings()
                2 -> GermanAdjectiveQuiz()
            }
        }
    }
}

@Composable
fun GermanAdjectiveHome(textToSpeech: TextToSpeech) {

    val adjectives = getGermanAdjectives()
    val germanAdjectives = adjectives["German"] ?: emptyList()
    val englishAdjectives = adjectives["English"] ?: emptyList()


    // Ensure both lists are of the same size to avoid index out of bounds
    val maxSize = minOf(germanAdjectives.size, englishAdjectives.size)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(text = "Ajektive - Adjectives",
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
                    text = "Adjectives like in any other language are used for description of nouns" +
                            ". German adjectives are dependent on the gender and case of the nouns." +
                            " Below are common adjectives you will encounter:",
                    color = Color.Black,
                    fontSize = 14.sp,

                    )
            }

        }

        Spacer(modifier = Modifier
            .height(15.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(germanAdjectives.take(maxSize)) { index, germanAdjective ->
                val englishAdjective = englishAdjectives.getOrNull(index) ?: ""

                // Pass German and English adjectives and the TextToSpeech object to the TranslatableItem
                TranslatableItem(deu = germanAdjective, eng = englishAdjective, textToSpeech = textToSpeech)
            }
        }
    }
}

@Composable
fun GermanAdjectiveEndings() {
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

                Text(text = "Adjective declension",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Text(
                    text = "Adjectives in german have different endings. This is determined by the case" +
                            " of the sentence or the gender of a noun.",
                    color = Color.Black,
                    fontSize = 14.sp,

                    )
            }

        }
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        //card start
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
                    text = "Definite Articles - Bestimmte Artikeln",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "These correspond to definite articles (der, die, das) or the in english",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanDefEndTable()
            }
        }
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        //card start
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
                    text = "Indefinite Articles - Unbestimmte Artikeln",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "These correspond to indefinite articles (ein, eine, ein) or a in english",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanIndEndTable()
            }
        }
    }
}

@Composable
fun GermanAdjectiveQuiz() {

    val germanAdjectiveQuestions = germanAdjectiveQuizQuestions()

    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanAdjectiveQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanAdjectiveQuestions.size) { null })
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
                    text = "Adjective Quiz",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                score?.let {

                    if (it == germanAdjectiveQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanAdjectiveQuestions.size}",
                            color = Color.Magenta,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    } else if (it != germanAdjectiveQuestions.size) {
                        Text(
                            text = "Your Score: $it/${germanAdjectiveQuestions.size}",
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

                    items(germanAdjectiveQuestions.size) { j ->
                        val adjectiveQuizList = germanAdjectiveQuestions[j]
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
                        for (i in germanAdjectiveQuestions.indices) {
                            if (selectedOptions[i] == germanAdjectiveQuestions[i].correctAnswer) {
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GermanCases() {
    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        caseTabItems.size
    }

    val textToSpeech = remember {
        var tts: TextToSpeech? = null
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale.GERMAN)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "German language not supported")
                }
            } else {
                Log.e("TTS", "Initialization failed")
            }
        }
        tts
    }

    DisposableEffect(Unit) {
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White
        ) {
            caseTabItems.fastForEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when(page) {
                0 -> GermanArticleHome()
                1 -> GermanCaseHome()
                2 -> GermanCaseQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GermanNouns() {
    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        nounTabItems.size
    }

    val textToSpeech = remember {
        var tts: TextToSpeech? = null
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale.GERMAN)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "German language not supported")
                }
            } else {
                Log.e("TTS", "Initialization failed")
            }
        }
        tts
    }

    DisposableEffect(Unit) {
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
            edgePadding = 0.dp
        ) {
            nounTabItems.fastForEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when(page) {
                0 -> GermanNounHome(textToSpeech)
                1 -> GermanPlaceNouns(textToSpeech)
                2 -> GermanFoodNouns(textToSpeech)
                3 -> GermanBodyNouns(textToSpeech)
                4 -> GermanNounQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GermanPrepositions() {
    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        prepositionTabItems.size
    }


    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
            edgePadding = 0.dp
        ) {
            prepositionTabItems.fastForEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when(page) {
                0 -> GermanPrepositionHome()
                1 -> GermanDativePreposition()
                2 -> GermanTwoWayPreposition()
                3 -> GermanPrepositionQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GermanPronouns() {
    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        pronounTabItems.size
    }


    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
        ) {
            pronounTabItems.fastForEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when(page) {
                0 -> GermanPronounHome()
                1 -> GermanPronounQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GermanSentenceStructure() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        sentenceTabItems.size
    }


    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
        ) {
            sentenceTabItems.fastForEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when(page) {
                0 -> GermanSentenceStructureHome()
                1 -> GermanSubordinateSentences()
                2 -> GermanConjunctionScreen()
                3 -> GermanSentenceQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GermanTenses() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        tenseTabItems.size
    }


    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
        ) {
            tenseTabItems.fastForEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when(page) {
                0 -> GermanTenseHome()
                1 -> GermanPastTense()
                2 -> GermanFutureTense()
                3 -> GermanTenseQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GermanVerbs() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        verbTabItems.size
    }


    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
            edgePadding = 0.dp
        ) {
            verbTabItems.fastForEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon, contentDescription = item.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when(page) {
                0 -> GermanVerbHome()
                1 -> GermanTopVerbs()
                2 -> GermanHabenVerb()
                3 -> GermanSeinVerb()
                4 -> GermanKannVerb()
                5 -> GermanVerbQuiz()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GermanScreens() {
    GermanSentenceStructure()
}