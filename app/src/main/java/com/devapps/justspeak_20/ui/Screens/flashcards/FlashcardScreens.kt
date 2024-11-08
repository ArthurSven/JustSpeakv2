package com.devapps.justspeak_20.ui.Screens.flashcards

import android.graphics.Bitmap
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.devapps.justspeak_20.data.models.UserData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
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
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.devapps.justspeak_20.R
import com.devapps.justspeak_20.auth.GoogleClientAuth
import com.devapps.justspeak_20.data.models.Flashcard
import com.devapps.justspeak_20.ui.ScreenDestinations
import com.devapps.justspeak_20.ui.components.FlashcardItem
import com.devapps.justspeak_20.ui.components.GridItem
import com.devapps.justspeak_20.ui.components.getCurrentDate
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.ui.theme.grau
import com.devapps.justspeak_20.ui.viewmodels.FlashcardViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashcardScreens(
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
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(onClick = {
                                    justSpeakMainNavController.navigate(ScreenDestinations.ChichewaNavigation.route)
                                },
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(35.dp))) {
                                    Icon(painter = painterResource(R.drawable.wappen), contentDescription = "Chichewa")
                                }
                                Spacer(
                                    modifier = Modifier
                                        .width(5.dp)
                                )
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = "Chichewa",
                                            color = Color.Black
                                        )
                                    },
                                    onClick = {
                                        justSpeakMainNavController.navigate(ScreenDestinations.ChichewaNavigation.route)
                                    },
                                    modifier = Modifier
                                        .background(color = Color.White)
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(onClick = {
                                    justSpeakMainNavController.navigate(ScreenDestinations.GermanNavigation.route)
                                },
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(35.dp))) {
                                    Icon(painter = painterResource(R.drawable.wappen), contentDescription = "German")
                                }
                                Spacer(
                                    modifier = Modifier
                                        .width(5.dp)
                                )
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = "German",
                                            color = Color.Black
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

@Composable
fun FlashcardNavigation(justSpeakMainNavController: NavController) {
    val flashcardNavController = rememberNavController()
    val flashcardViewModel: FlashcardViewModel = hiltViewModel()

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val googleAuthClient by lazy {
        GoogleClientAuth(
            context = context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    NavHost(navController = flashcardNavController, startDestination = ScreenDestinations.FlashcardListScreen.route) {
        composable(ScreenDestinations.FlashcardListScreen.route) {
            FlashcardList(
                justSpeakMainNavController = justSpeakMainNavController,
                flashcardNavController = flashcardNavController,
                flashcardViewModel = flashcardViewModel,
                userData = googleAuthClient.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleAuthClient.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(ScreenDestinations.AddFlashcardScreen.route) {
            AddFlashcard(
                flashcardNavController,
                googleAuthClient.getSignedInUser(),
                flashcardViewModel)
        }
        composable(ScreenDestinations.EditFlashcardScreen.route+"/{flashcardId}",
            arguments = listOf(navArgument("flashcardId") { type = NavType.IntType})
        ) { navBackStackEntry ->
            val flashcardId = navBackStackEntry.arguments?.getInt("flashcardId") ?: 0
            EditFlashcard(
                flashcardNavController,
                googleAuthClient.getSignedInUser(),
                flashcardId,
                flashcardViewModel
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashcardList(
    justSpeakMainNavController: NavController,
    flashcardNavController: NavController,
    flashcardViewModel: FlashcardViewModel,
    userData: UserData?,
    onSignOut: () -> Unit
) {
    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val showMenu = remember { mutableStateOf(false) }
    val changeLanguage = remember { mutableStateOf(false) }
    val flashcardState by remember { flashcardViewModel.userFlashcards }.collectAsState(emptyList())
    var flashcardToDelete by remember { mutableStateOf<Flashcard?>(null) }
    val showDeleteDialog = remember { mutableStateOf(false) }
    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }
    val userId = googleClientAuth.getSignedInUser()?.userId
    LaunchedEffect(userId) {
                if (userId != null) {
                    flashcardViewModel.setCreatedBy(userId)
                }
    }
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(grau)) {
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                Text(
                    text = "Your Flashcards",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                if(flashcardState.isEmpty()) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                    ) {
                        Text(text = "No flashcards available",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Button(
                            onClick = {
                                flashcardNavController.navigate(ScreenDestinations.AddFlashcardScreen.route)
                            },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                containerColor = AzureBlue
                            ),
                            modifier = Modifier
                                .width(200.dp)
                                .height(50.dp)
                                .align(Alignment.BottomEnd),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Icon(imageVector = Icons.Default.Add, contentDescription = "create flashcard")
                                Spacer(modifier = Modifier
                                    .width(7.dp))
                                Text(text = "Create Flashcard")
                            }

                        }
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        LazyVerticalStaggeredGrid(
                            columns = StaggeredGridCells.Fixed(2),
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalItemSpacing = 16.dp
                        ) {
                            itemsIndexed(flashcardState) { index, flashcard ->

                                val randomColor = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)

                                FlashcardItem(
                                    GridItem(
                                        flashcard.german,
                                        flashcard.english,
                                        randomColor
                                    ) ,
                                    onEdit = {
                                        flashcardNavController.navigate(ScreenDestinations.EditFlashcardScreen.route+"/${flashcard.flashCardId}")
                                    },
                                    onDelete = {
                                        flashcardToDelete = flashcard
                                        showDeleteDialog.value = true
                                    })
                            }
                        }
                        if (showDeleteDialog.value) {
                            AlertDialog(
                                onDismissRequest = { showDeleteDialog.value = false },
                                title = { Text("Delete Flashcard",
                                    color = Color.Black
                                ) },
                                containerColor = Color.White,
                                text = { Text("Are you sure you want to delete this flashcard?",
                                    color = Color.Black
                                ) },
                                confirmButton = {
                                    Button(
                                        onClick = {
                                            flashcardToDelete?.let { flashcard ->
                                                coroutineScope.launch {
                                                    flashcardViewModel.deleteFlashcard(flashcard)
                                                    flashcardToDelete = null
                                                }
                                            }
                                            showDeleteDialog.value = false
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.Red,
                                            contentColor = Color.White
                                        )
                                    ) {
                                        Text("Delete",
                                            color = Color.White)
                                    }
                                },
                                dismissButton = {
                                    Button(
                                        onClick = { showDeleteDialog.value = false },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.White,
                                            contentColor = AzureBlue
                                        )) {
                                        Text("No",
                                            color = AzureBlue
                                        )
                                    }
                                }
                            )
                        }
                        Button(
                            onClick = {
                            flashcardNavController.navigate(ScreenDestinations.AddFlashcardScreen.route)
                        },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                containerColor = AzureBlue
                            ),
                            modifier = Modifier
                                .width(200.dp)
                                .height(50.dp)
                                .align(Alignment.BottomEnd),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Icon(imageVector = Icons.Default.Add, contentDescription = "create flashcard")
                                Spacer(modifier = Modifier
                                    .width(7.dp))
                                Text(text = "Create Flashcard")
                            }

                        }
                    }
                }
            }
}


@Composable
fun AddFlashcard(
    flashcardNavController: NavController,
    userData: UserData?,
    flashcardViewModel: FlashcardViewModel
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val googleAuthUiClient by lazy {
        GoogleClientAuth(
            context = context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }
    val userId = googleAuthUiClient.getSignedInUser()?.userId
    val insetResultState by flashcardViewModel.upsertFlashcardResultState.collectAsState()
    var insertionAttempted by remember {
        mutableStateOf(false)
    }

    var germanFlashcard by rememberSaveable {
        mutableStateOf("")
    }
    var englishTranslation by rememberSaveable {
        mutableStateOf("")
    }
    var currentDate = getCurrentDate()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(grau)
    ) {
        Spacer(
            modifier = Modifier
            .height(50.dp)
        )
        Text(
            text = "Create a flashcard",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .height(40.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                OutlinedTextField(
                    value = germanFlashcard,
                    onValueChange = {
                        germanFlashcard = it
                    },
                    label = { Text(text = "German")},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.DarkGray,
                        focusedBorderColor = AzureBlue,
                        unfocusedLabelColor = Color.DarkGray,
                        focusedLabelColor = AzureBlue,
                        unfocusedTextColor = Color.DarkGray,
                        focusedTextColor = Color.Black
                    )
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                OutlinedTextField(
                    value = englishTranslation,
                    onValueChange = {
                        englishTranslation = it
                    },
                    label = { Text(text = "English translation")},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.DarkGray,
                        focusedBorderColor = AzureBlue,
                        unfocusedLabelColor = Color.DarkGray,
                        focusedLabelColor = AzureBlue,
                        unfocusedTextColor = Color.DarkGray,
                        focusedTextColor = Color.Black
                    )
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Button(
                    onClick = {
                        if(germanFlashcard.isNotEmpty() && englishTranslation.isNotEmpty()) {
                            val flashcardLocal = Flashcard(
                               german = germanFlashcard,
                              english =  englishTranslation,
                                date = currentDate,
                                createdBy = userId
                            )
                            coroutineScope.launch {
                                flashcardViewModel.upsertFlashcard(flashcardLocal)
                            }
                            insertionAttempted = true
                        } else {
                            // Display a message if either of the fields is empty
                            Toast.makeText(context, "Please fill in both German and English " +
                                    "translations.", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzureBlue,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Create flashcard")
                }
                LaunchedEffect(insetResultState) {
                    if (insertionAttempted) {
                        if (insetResultState.isSuccessful) {
                            Toast.makeText(context, "Flashcard has successfully created",
                                Toast.LENGTH_LONG)
                                .show()
                            flashcardViewModel.resetState()
                            germanFlashcard = ""
                            englishTranslation = ""
                            delay(2000)
                            flashcardNavController.navigate(ScreenDestinations.FlashcardListScreen.route)
                        } else if (insetResultState.error != null){

                            Toast.makeText(context, "Failed to create flashcard: " +
                                    "${insetResultState.error}",
                                Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun EditFlashcard(
    flashcardNavController: NavController,
    userData: UserData?,
    flashcardId: Int,
    flashcardViewModel: FlashcardViewModel
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val googleAuthUiClient by lazy {
        GoogleClientAuth(
            context = context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    val flashcard by remember {
        flashcardViewModel.getFlashcardById(flashcardId)
    }.collectAsState(initial = null)

    val userId = googleAuthUiClient.getSignedInUser()?.userId
    val insetResultState by flashcardViewModel.upsertFlashcardResultState.collectAsState()
    var insertionAttempted by remember {
        mutableStateOf(false)
    }

    var germanFlashcard by rememberSaveable {
        mutableStateOf("")
    }
    var englishTranslation by rememberSaveable {
        mutableStateOf("")
    }
    var currentDate = getCurrentDate()

    LaunchedEffect(flashcard) {
        flashcard?.let {
            germanFlashcard = it.german
            englishTranslation = it.english
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(grau)
    ) {
        Spacer(
            modifier = Modifier
                .height(50.dp)
        )
        Text(
            text = "Update flashcard",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .height(40.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                OutlinedTextField(
                    value = germanFlashcard,
                    onValueChange = {
                        germanFlashcard = it
                    },
                    label = { Text(text = "German")},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.DarkGray,
                        focusedBorderColor = AzureBlue,
                        unfocusedLabelColor = Color.DarkGray,
                        focusedLabelColor = AzureBlue,
                        unfocusedTextColor = Color.DarkGray,
                        focusedTextColor = Color.Black
                    )
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                OutlinedTextField(
                    value = englishTranslation,
                    onValueChange = {
                        englishTranslation = it
                    },
                    label = { Text(text = "English translation")},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.DarkGray,
                        focusedBorderColor = AzureBlue,
                        unfocusedLabelColor = Color.DarkGray,
                        focusedLabelColor = AzureBlue,
                        unfocusedTextColor = Color.DarkGray,
                        focusedTextColor = Color.Black
                    )
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Button(
                    onClick = {
                        if(germanFlashcard.isNotEmpty() && englishTranslation.isNotEmpty()) {
                            val flashcardLocal = Flashcard(
                                flashCardId = flashcardId,
                                german = germanFlashcard,
                                english =  englishTranslation,
                                date = currentDate,
                                createdBy = userId
                            )
                            coroutineScope.launch {
                                flashcardViewModel.upsertFlashcard(flashcardLocal)
                            }
                            insertionAttempted = true
                        } else {
                            // Display a message if either of the fields is empty
                            Toast.makeText(context, "Please fill in both German and English " +
                                    "translations.", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzureBlue,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Update flashcard")
                }
                LaunchedEffect(insetResultState) {
                    if (insertionAttempted) {
                        if (insetResultState.isSuccessful) {
                            Toast.makeText(context, "Flashcard has successfully updated",
                                Toast.LENGTH_LONG)
                                .show()
                            flashcardViewModel.resetState()
                            germanFlashcard = ""
                            englishTranslation = ""
                        } else if (insetResultState.error != null){

                            Toast.makeText(context, "Failed to create flashcard: " +
                                    "${insetResultState.error}",
                                Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

        }
    }
}
