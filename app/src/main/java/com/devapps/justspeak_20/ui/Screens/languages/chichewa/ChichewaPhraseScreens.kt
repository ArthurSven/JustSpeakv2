package com.devapps.justspeak_20.ui.Screens.languages.chichewa

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.devapps.justspeak_20.ui.Screens.languages.german.GermanGastronomyQuiz
import com.devapps.justspeak_20.ui.components.chichewaIntroductionTabItems
import com.devapps.justspeak_20.ui.components.emergencyTabItems
import com.devapps.justspeak_20.ui.components.expressionTabItems
import com.devapps.justspeak_20.ui.components.gastronomyTabItems
import com.devapps.justspeak_20.ui.components.introductionTabItems

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