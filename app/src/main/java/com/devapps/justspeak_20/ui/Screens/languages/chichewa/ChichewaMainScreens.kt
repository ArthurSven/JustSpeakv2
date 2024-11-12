package com.devapps.justspeak_20.ui.Screens.languages.chichewa

import android.graphics.Bitmap
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.SortByAlpha
import androidx.compose.material.icons.filled.Speaker
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.devapps.justspeak_20.R
import com.devapps.justspeak_20.auth.GoogleClientAuth
import com.devapps.justspeak_20.data.models.UserData
import com.devapps.justspeak_20.ui.ScreenDestinations
import com.devapps.justspeak_20.ui.components.ChichewaAlphabetCard
import com.devapps.justspeak_20.ui.components.ChichewaPhraseItem
import com.devapps.justspeak_20.ui.components.ChichewaTranslatableItem
import com.devapps.justspeak_20.ui.components.LanguageProgressCard
import com.devapps.justspeak_20.ui.components.TopicCard
import com.devapps.justspeak_20.ui.components.TopicItem
import com.devapps.justspeak_20.ui.components.chichewaAdjectiveTabItems
import com.devapps.justspeak_20.ui.components.chichewaPronounTabItems
import com.devapps.justspeak_20.ui.components.chichewaVerbTabItems
import com.devapps.justspeak_20.ui.components.nounTabItems
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.ui.theme.grau
import com.devapps.justspeak_20.ui.viewmodels.ProgressViewModel
import com.devapps.justspeak_20.utils.chichewaAlphabetData
import com.devapps.justspeak_20.utils.chichewaNumbers
import com.google.android.gms.auth.api.identity.Identity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChichewaLanguageScreens(
    justSpeakMainNavController: NavController,
    userData: UserData?,
    onSignOut: () -> Unit
) {

    val showMenu = remember { mutableStateOf(false) }
    val changeLanguage = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                navigationIcon = {
                    IconButton(onClick = {
                        changeLanguage.value = !changeLanguage.value
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = null, tint = Color.Black)
                    }
                    DropdownMenu(
                        expanded = changeLanguage.value,
                        onDismissRequest = {
                            changeLanguage.value = false
                        },
                        modifier = Modifier
                            .background(color = Color.White)
                            .width(150.dp)
                    ) {
                        DropdownMenuItem(
                            text = {
                                    Text(
                                        text = "Home",
                                        color = Color.Black
                                    )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Home,
                                    contentDescription = null,
                                    tint = AzureBlue
                                )
                            },
                            onClick = {
                                justSpeakMainNavController.navigate(ScreenDestinations.Start.route)
                            },
                            modifier = Modifier
                                .background(color = Color.White)
                        )
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = "German",
                                        color = Color.Black
                                    )
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Translate,
                                        contentDescription = null,
                                        tint = AzureBlue
                                    )
                                },
                                onClick = {
                                    justSpeakMainNavController.navigate(ScreenDestinations.GermanNavigation.route)
                                },
                                modifier = Modifier
                                    .background(color = Color.White)
                            )
                        }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                actions = {
                    if (userData?.userProfileUrl != null) {
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
                                .clip(CircleShape)
                                .clickable {
                                    showMenu.value = !showMenu.value
                                },
                            contentScale = ContentScale.Crop
                        )
                        DropdownMenu(
                            expanded = showMenu.value,
                            onDismissRequest = {
                                showMenu.value = false
                            },
                            modifier = Modifier
                                .background(color = Color.White)
                                .width(150.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Logout,
                                    contentDescription = "logout",
                                    tint = Color.DarkGray
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(5.dp)
                                )
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = "Logout",
                                            color = Color.Black
                                        )
                                    },
                                    onClick = {
                                        justSpeakMainNavController.navigate(ScreenDestinations.Signout.route)
                                        onSignOut()
                                    },
                                    modifier = Modifier
                                        .background(color = Color.White)
                                )
                            }
                        }
                    } else {
                        Image(
                            painter = painterResource(R.drawable.no_profile),
                            contentDescription = "Arthur's profile picture",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .clickable {
                                    showMenu.value = !showMenu.value
                                },
                            contentScale = ContentScale.Crop
                        )
                        DropdownMenu(
                            expanded = showMenu.value,
                            onDismissRequest = {
                                showMenu.value = false
                            },
                            modifier = Modifier
                                .background(color = Color.White)
                                .width(80.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Logout,
                                    contentDescription = "logout"
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(8.dp)
                                )
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = "Logout",
                                            color = Color.Black
                                        )
                                    },
                                    onClick = {
                                        justSpeakMainNavController.navigate(ScreenDestinations.Signout.route)
                                        onSignOut()
                                    },
                                    modifier = Modifier
                                        .background(color = Color.White)
                                )
                            }
                        }
                    }

                },
            )
        }
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(grau)) {
                ChichewaMainNavigation()
            }
        }
    }
}

@Composable
fun ChichewaMainNavigation() {

    val chichewaScreensNavController = rememberNavController()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val progressViewModel: ProgressViewModel = hiltViewModel()

    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    BackHandler {
        // Always navigate back to the landing screen
        chichewaScreensNavController.popBackStack(ScreenDestinations.ChichewaHomeScreen.route, false)
    }

    NavHost(chichewaScreensNavController, startDestination = ScreenDestinations.ChichewaHomeScreen.route) {
        composable(ScreenDestinations.ChichewaHomeScreen.route) {
            GermanLandingScreen(
                chichewaScreensNavController ,
                googleClientAuth.getSignedInUser()
            )
        }
        composable(ScreenDestinations.ChichewaAlphabetScreen.route) {
            ChichewaAlphabet()
        }
        composable(ScreenDestinations.ChichewaAdjectiveScreen.route) {
            ChichewaAdjectives()
        }
        composable(ScreenDestinations.ChichewaNounScreen.route) {
            ChichewaNouns()
        }
        composable(ScreenDestinations.ChichewaNumbersScreen.route) {
            ChichewaNumbers()
        }
        composable(ScreenDestinations.ChichewaPronounScreen.route) {
            ChichewaPronouns()
        }
        composable(ScreenDestinations.ChichewaVerbScreen.route) {
            ChichewaVerbs()
        }
        composable(ScreenDestinations.ChichewaIntroductionScreen.route) {
            ChichewaIntroductions()
        }
        composable(ScreenDestinations.ChichewaExpressionScreen.route) {
            ChichewaExpressions()
        }
        composable(ScreenDestinations.ChichewaEatingScreen.route) {
            ChichewaGastronomy()
        }
        composable(ScreenDestinations.ChichewaEmergencyScreen.route) {
            ChichewaEmergency()
        }
        composable(ScreenDestinations.ChichewaQuestionScreen.route) {
            ChichewaQuestion()
        }
        composable(ScreenDestinations.ChichewaTimeScreen.route) {
            ChichewaTime()
        }
    }
}

@Composable
fun GermanLandingScreen(
    chichewaNavController: NavController,
    userData: UserData?
) {

    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val chichewaTopicItem = mutableListOf(
        TopicItem(
            "Alphabet",
            Icons.Filled.SortByAlpha,
            0.0F,
            ScreenDestinations.ChichewaAlphabetScreen.route
        ),
        TopicItem(
            "Adjectives",
            Icons.Filled.Album,
            0.0F,
            ScreenDestinations.ChichewaAdjectiveScreen.route
        ),
        TopicItem(
            "Nouns",
            Icons.Filled.Badge,
            0.0F,
            ScreenDestinations.ChichewaNounScreen.route
        ),
        TopicItem(
            "Numbers",
            Icons.Filled.Numbers,
            0.0F,
            ScreenDestinations.ChichewaNumbersScreen.route
        ),
        TopicItem(
            "Pronouns",
            Icons.Filled.Album,
            0.0F,
            ScreenDestinations.ChichewaPronounScreen.route
        ),
        TopicItem(
            "Verbs",
            Icons.Filled.Height,
            0.0F,
            ScreenDestinations.ChichewaVerbScreen.route
        )
    )

    val chichewaPhraseList = listOf(
        TopicItem(
            "Introductions",
            Icons.Filled.Groups,
            0.0F,
            ScreenDestinations.ChichewaIntroductionScreen.route
        ),
        TopicItem(
            "Expressions",
            Icons.Filled.Speaker,
            0.0F,
            ScreenDestinations.ChichewaExpressionScreen.route
        ),
        TopicItem(
            "Emergencies",
            Icons.Filled.Emergency,
            0.0F,
            ScreenDestinations.ChichewaEmergencyScreen.route
        ),
        TopicItem(
            "Gastronomy",
            Icons.Filled.Fastfood,
            0.0F,
            ScreenDestinations.ChichewaEatingScreen.route
        ),
        TopicItem(
            "Questions",
            Icons.Filled.QuestionMark,
            0.0F,
            ScreenDestinations.ChichewaQuestionScreen.route
        ),
        TopicItem(
            "Tell the time",
            Icons.Filled.Watch,
            0.0F,
            ScreenDestinations.ChichewaTimeScreen.route
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 10.dp, end = 10.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(50.dp)
        )
        LanguageProgressCard(
            R.drawable.nyasaflag,
            "Chichewa Section",
            "Bhobho!"
        )
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
            items(chichewaTopicItem.size) { i ->
                val listItem = chichewaTopicItem[i]
                TopicCard(
                    selected = selectedItemIndex == i,
                    title = listItem.topicTitle,
                    icon = listItem.topicIcon,
                    percent = listItem.topicPercent,
                    onClick = {
                        chichewaNavController.navigate(listItem.topicRoute)
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
            items(chichewaPhraseList.size) { i ->
                val listItem = chichewaPhraseList[i]
                TopicCard(
                    selected = selectedItemIndex == i,
                    title = listItem.topicTitle,
                    icon = listItem.topicIcon,
                    percent = listItem.topicPercent,
                    onClick = {
                        chichewaNavController.navigate(listItem.topicRoute)
                    })
            }
        }
    }
}

@Composable
fun ChichewaAlphabet() {

    val chichewaAlphabetData = chichewaAlphabetData()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Alphabet - Afabeti",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(
            text = "The following is an alphabet list in chichewa together with how each letter " +
                    "is pronounced.",
            fontSize = 14.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        //add lazy column here
        LazyColumn {
            items(chichewaAlphabetData.entries.toList()) { entry ->
                ChichewaAlphabetCard(entry.key, entry.value)
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaAdjectives() {

    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        chichewaAdjectiveTabItems.size
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White
        ) {
            chichewaAdjectiveTabItems.fastForEachIndexed { index, item ->
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
                0 -> ChichewaAdjectiveHome()
                1 -> ChichewaAdjectiveQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaNouns() {
    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        nounTabItems.size
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
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
                0 -> ChichewaNounHome()
                1 -> ChichewaPlaceNouns()
                2 -> ChichewaFoodNouns()
                3 -> ChichewaBodyNouns()
                4 -> ChichewaNounQuiz()
            }
        }
    }
}

@Composable
fun ChichewaNumbers() {
    val chichewaNumbers = chichewaNumbers()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Numbers - ma Nambala",
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
                    text = "Numbers in chichewa are not too complex to understand, many of the numbers" +
                            " here are used in spoken form. However the arabic numerals and the english numbers" +
                            " are understood throughout Malawi.",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        //add lazy column here
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chichewaNumbers.entries.toList()) { entry ->
                ChichewaPhraseItem(entry.key, entry.value)
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaPronouns() {
    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        chichewaPronounTabItems.size
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White
        ) {
            chichewaPronounTabItems.fastForEachIndexed { index, item ->
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
                0 -> ChichewaPronounHome()
                1 -> ChichewaPronounQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaVerbs()  {
    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        chichewaVerbTabItems.size
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White
        ) {
            chichewaVerbTabItems.fastForEachIndexed { index, item ->
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
                0 -> ChichewaVerbHome()
                1 -> ChichewaVerbConjugation()
                2 -> ChichewaVerbQuiz()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ChichewaPreview() {
    ChichewaNumbers()
}