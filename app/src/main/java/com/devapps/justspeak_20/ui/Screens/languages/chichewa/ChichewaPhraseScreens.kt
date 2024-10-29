package com.devapps.justspeak_20.ui.Screens.languages.chichewa

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import com.devapps.justspeak_20.ui.Screens.languages.german.GermanGastronomyQuiz
import com.devapps.justspeak_20.ui.components.ChichewaPhraseItem
import com.devapps.justspeak_20.ui.components.ChichewaTranslatableItem
import com.devapps.justspeak_20.ui.components.chichewaIntroductionTabItems
import com.devapps.justspeak_20.ui.components.chichewaQuestionTabItems
import com.devapps.justspeak_20.ui.components.emergencyTabItems
import com.devapps.justspeak_20.ui.components.expressionTabItems
import com.devapps.justspeak_20.ui.components.gastronomyTabItems
import com.devapps.justspeak_20.ui.components.introductionTabItems
import com.devapps.justspeak_20.utils.getChichewaDays
import com.devapps.justspeak_20.utils.getChichewaQuestionKeyWords
import com.devapps.justspeak_20.utils.getChichewaQuestionPhrases

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaIntroductions() {

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        chichewaIntroductionTabItems.size
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
            chichewaIntroductionTabItems.fastForEachIndexed { index, item ->
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
            when (page) {
                0 -> ChichewaIntroHome()
                1 -> ChichewaGoodbyes()
                2 -> ChichewaIntroExpressions()
                3 -> ChichewaIntroductionQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaExpressions() {

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        expressionTabItems.size
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
            expressionTabItems.fastForEachIndexed { index, item ->
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
            when (page) {
                0 -> ChichewaExpressionHome()
                1 -> ChichewaExpressionQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaGastronomy() {

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        gastronomyTabItems.size
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
            gastronomyTabItems.fastForEachIndexed { index, item ->
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
            when (page) {
                0 -> ChichewaGastronomyHome()
                1 -> ChichewaShopping()
                2 -> GermanGastronomyQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaEmergency() {

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        emergencyTabItems.size
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
            emergencyTabItems.fastForEachIndexed { index, item ->
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
            when (page) {
                0 -> ChichewaEmergencyHome()
                1 -> ChichewaMedicalEmergencyScreen()
                2 -> ChichewaCrimeEmergencyScreen()
                3 -> ChichewaEmergencyQuiz()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChichewaQuestion() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        chichewaQuestionTabItems.size
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
            chichewaQuestionTabItems.fastForEachIndexed { index, item ->
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
            when (page) {
                0 -> ChichewaQuestionHome()
                1 -> ChichewaQuestionExample()
            }
        }
    }
}

@Composable
fun ChichewaTime() {
    val chichewaDays = getChichewaDays()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        Text(text = "Time",
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
                    text = "This section covers on time related vocabulary in chichewa, below you will" +
                            " find lists of days, months and a few phrases on telling the time.",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Text(text = "Days",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(10.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
        ) {
            items(chichewaDays.entries.toList()) { entry ->
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
                    "Months in Chichewa are the same as in English, sometimes they are " +
                    "pronounced with a corruption but generally the same as english, thus no months" +
                            " list.",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

        }
    }
}