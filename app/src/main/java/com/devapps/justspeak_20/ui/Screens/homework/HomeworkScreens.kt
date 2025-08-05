package com.devapps.justspeak_20.ui.Screens.homework

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.devapps.justspeak_20.R
import com.devapps.justspeak_20.data.models.UserData
import com.devapps.justspeak_20.ui.ScreenDestinations
import com.devapps.justspeak_20.ui.Screens.flashcards.FlashcardNavigation
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.ui.theme.grau

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHomeworkScreen(
    justSpeakMainNavController: NavController,
    userData: UserData?,
    onSignOut: () -> Unit
) {
    val showMenu = remember { mutableStateOf(false) }
    val changeLanguage = remember { mutableStateOf(false) }

    val currentDestination = justSpeakMainNavController.currentBackStackEntryAsState().value?.destination?.route
    val showFloatingActionButton = currentDestination == ScreenDestinations.FlashcardListScreen.route

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
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
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
                                        text = "Chichewa",
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
                                    justSpeakMainNavController.navigate(ScreenDestinations.ChichewaNavigation.route)
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
        },
        floatingActionButton = {
            if (showFloatingActionButton) {
                ExtendedFloatingActionButton(
                    onClick = {
                        justSpeakMainNavController.navigate(ScreenDestinations.AddFlashcardScreen.route)
                    },
                    contentColor = Color.White,
                    containerColor = AzureBlue
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Create a flashcard"
                    )
                    Text(text = "Create Flashcard")
                }
            }
        }
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(grau)) {
                FlashcardNavigation(justSpeakMainNavController)
            }
        }
    }
}
}