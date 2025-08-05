package com.devapps.justspeak_20.ui.Screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.WindowManager
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.FileCopy
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_20.R
import com.devapps.justspeak_20.auth.GoogleClientAuth
import com.devapps.justspeak_20.data.models.UserData
import com.devapps.justspeak_20.data.models.languageDailyTips
import com.devapps.justspeak_20.ui.ScreenDestinations
import com.devapps.justspeak_20.ui.Screens.languages.german.GermanLanguageScreens
import com.devapps.justspeak_20.ui.components.LanguageCard
import com.devapps.justspeak_20.ui.components.LanguageCardItem
import com.devapps.justspeak_20.ui.components.LanguageTipPager
import com.devapps.justspeak_20.ui.components.UserProfileBar
import com.devapps.justspeak_20.ui.components.displayGreeting
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.ui.theme.teal
import com.devapps.justspeak_20.ui.theme.yellow
import com.devapps.justspeak_20.ui.viewmodels.AuthViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    userMainController: NavController,
    userData: UserData?,
    onSignOut: () -> Unit) {

    val greet = displayGreeting()
    val animatedOffsetY = remember { Animatable(0f) }
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }


    val karte = listOf(
        LanguageCardItem(
                Icons.Outlined.Translate,
            "Chichewa",
            ScreenDestinations.ChichewaNavigation.route
        ),
        LanguageCardItem(
            Icons.Outlined.Translate,
            "German",
            ScreenDestinations.GermanNavigation.route
        ),
        LanguageCardItem(
            Icons.Outlined.FileCopy,
            "Flashcards",
            ScreenDestinations.FlashcardStarterScreen.route,
        ),
        LanguageCardItem(
            Icons.Outlined.FileCopy,
            "Homework",
            ScreenDestinations.FlashcardStarterScreen.route,
        )
    )

    LaunchedEffect(key1 = true) {
        while (true) {
            delay(1000) // adjust delay as needed
            animatedOffsetY.animateTo(
                targetValue = 30f.dp.value, // Bounce height
                animationSpec = tween(
                    durationMillis = 500,
                    easing = EaseOutBounce // Bouncy animation
                )
            )
            animatedOffsetY.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = EaseInBounce // Bouncy animation
                )
            )
        }
    }

    BackHandler {
        // Always navigate back to the landing screen
        userMainController.popBackStack(ScreenDestinations.Start.route, false)
    }


    val showMenu = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "JustSpeak",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = AzureBlue)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {
                        showMenu.value = true
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            tint = AzureBlue
                        )
                    }
                    DropdownMenu(
                        expanded = showMenu.value,
                        onDismissRequest = {
                            showMenu.value = false
                        },
                        modifier = Modifier
                            .background(color = Color.White)
                            .width(80.dp)) {
                        DropdownMenuItem(
                            text = {
                                Text(text = "Logout",
                                    color = Color.Black)
                            },
                            onClick = {
                                userMainController.navigate(ScreenDestinations.Signout.route)
                                onSignOut()
                            },
                            modifier = Modifier
                                .background(color = Color.White)
                        )
                    }
                },
            )
        }
    ) { it ->
        Column(modifier = Modifier
            .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(top = 5.dp, start = 10.dp, end = 10.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                UserProfileBar(userData)
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                Text(
                    text = greet,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier
                    .height(30.dp)
                )
                //Add pager Composable here
                LanguageTipPager()
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                Text("Start with...",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(karte.size) {i ->
                        val listItem = karte[i]
                        LanguageCard(
                            selected = selectedItemIndex == i,
                            onClick = {
                                userMainController.navigate(listItem.itemRoute)
                            },
                            icon = listItem.rep,
                            title = listItem.title,
                        )
                    }
                }
            }
        }


    }
}

@Composable
@Preview(showBackground = true)
fun ScreenViewer() {

}