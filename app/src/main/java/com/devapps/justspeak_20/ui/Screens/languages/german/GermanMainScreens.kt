package com.devapps.justspeak_20.ui.Screens.languages.german

import android.graphics.Bitmap
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.devapps.justspeak_20.ui.theme.grau
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
                    })
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
@Composable
@Preview(showBackground = true)
fun GermanScreens() {

}
