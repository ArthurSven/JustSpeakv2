package com.devapps.justspeak_20.ui.Screens

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_20.R
import com.devapps.justspeak_20.data.models.languageDailyTips
import com.devapps.justspeak_20.ui.ScreenDestinations
import com.devapps.justspeak_20.ui.components.LanguageCard
import com.devapps.justspeak_20.ui.components.LanguageCardItem
import com.devapps.justspeak_20.ui.components.displayGreeting
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.ui.theme.teal
import com.devapps.justspeak_20.ui.theme.yellow
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun UserMainNavigation(mainUserNavController: NavController) {
    val userMainNavController = rememberNavController()

    NavHost(navController = userMainNavController, startDestination = ScreenDestinations.Home.route) {
        composable(ScreenDestinations.Home.route) {
            MainScreen(userMainNavController)
        }
    }
}
@SuppressLint()
@Composable
fun MainScreen(userMainController: NavController) {

    val greet = displayGreeting()
    var randomTipIndex by remember { mutableIntStateOf(Random.nextInt(languageDailyTips().size)) }
    val animatedOffsetY = remember { Animatable(0f) }
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val karte = listOf(
        LanguageCardItem(
            R.drawable.nyasaflag,
            "Learn Chichewa",
            ScreenDestinations.ChichewaNavigation.route
        ),
        LanguageCardItem(
            R.drawable.wappen,
            "Learn German",
            ScreenDestinations.GermanNavigation.route
        )
    )



    randomTipIndex = Random.nextInt(languageDailyTips().size)

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

    val currentTip = languageDailyTips()[randomTipIndex]

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 10.dp, end = 10.dp)
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
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
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = yellow
                ),
                shape = RoundedCornerShape(10.dp)
            ) {

                Spacer(modifier = Modifier
                    .height(10.dp)
                )

                Box(modifier = Modifier
                    .fillMaxWidth()) {
                    Column(modifier = Modifier
                        .fillMaxWidth()) {

                        Spacer(
                            modifier = Modifier
                                .height(60.dp)
                        )
                        Text(
                            text = currentTip.tipTitle,
                            color = AzureBlue,
                            fontSize = 26.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .height(5.dp)
                        )
                        Text(
                            text = currentTip.languageTip,
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp)
                        )
                    }
                }
            }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Text("Select a language",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyRow(

        ) {
            items(karte.size) {i ->
                val listItem = karte[i]
                LanguageCard(
                    selected = selectedItemIndex == i,
                    onClick = {
                        userMainController.navigate(listItem.itemRoute)
                        // Handle navigation or other actions here
                    },
                    country = listItem.nation,
                    language = listItem.sprache
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenViewer() {
    val userMainNavController = rememberNavController()
    MainScreen(userMainNavController)
}