package com.devapps.justspeak_20

import android.app.Activity.RESULT_OK
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_20.auth.GoogleClientAuth
import com.devapps.justspeak_20.data.models.UserData
import com.devapps.justspeak_20.ui.ScreenDestinations
import com.devapps.justspeak_20.ui.Screens.MainScreen
import com.devapps.justspeak_20.ui.Screens.languages.chichewa.ChichewaLanguageScreens
import com.devapps.justspeak_20.ui.Screens.languages.german.GermanLanguageScreens
import com.devapps.justspeak_20.ui.components.UserProfileBar
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.ui.theme.JustSpeak_20Theme
import com.devapps.justspeak_20.ui.viewmodels.AuthViewModel
import com.google.android.gms.auth.api.identity.Identity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JustSpeak_20Theme() {
                JustSpeakMainNavigation()
            }
        }
    }
}

@Composable
fun JustSpeakMainNavigation() {
    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val authViewModel: AuthViewModel = hiltViewModel()
    val state by authViewModel.state.collectAsStateWithLifecycle()

    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    val justSpeakMainNavController = rememberNavController()
    NavHost(navController = justSpeakMainNavController, startDestination = ScreenDestinations.SplashScreen.route) {
        composable(ScreenDestinations.SplashScreen.route) {
            SplashScreen(justSpeakMainNavController)
        }
        composable(ScreenDestinations.Check.route) {
            LaunchedEffect(key1 = Unit) {
                if(googleClientAuth.getSignedInUser() != null) {
                    if (state.isSignInSuccessful) {

                    }
                    justSpeakMainNavController.navigate(ScreenDestinations.Start.route)
                } else {
                    justSpeakMainNavController.navigate(ScreenDestinations.Signup.route)
                }
            }
        }
        composable(ScreenDestinations.Signup.route) {
            GetStartedScreen(justSpeakMainNavController)
        }
        composable(ScreenDestinations.Start.route) {
            MainScreen(
                justSpeakMainNavController,
                userData = googleClientAuth.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(ScreenDestinations.GermanNavigation.route) {
            GermanLanguageScreens(
                justSpeakMainNavController,
                googleClientAuth.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(ScreenDestinations.ChichewaNavigation.route) {
            ChichewaLanguageScreens(
                justSpeakMainNavController,
                googleClientAuth.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(ScreenDestinations.Signout.route) {
            LaunchedEffect(Unit) {
                googleClientAuth.signOut()
                justSpeakMainNavController.navigate(ScreenDestinations.Signup.route)
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000)
        navController.navigate(ScreenDestinations.Check.route)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzureBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.justspeaklogo),
            contentDescription = null)
    }
}

@Composable
fun GetStartedScreen(justSpeakMainNavController: NavController) {

    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val authViewModel: AuthViewModel = hiltViewModel()
    val state by authViewModel.state.collectAsStateWithLifecycle()

    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AzureBlue)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(400.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier
                    .height(80.dp)
                )
                Text(text = "JUSTSPEAK \n    TODAY",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier
                    .height(30.dp)
                )
                Text(text = "Do you ever dream of speaking German or Chichewa in the streets flawlessly",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
                    .height(450.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        if(result.resultCode == RESULT_OK) {
                            coroutineScope.launch {
                                val signInResult = googleClientAuth.signInWithIntent(
                                    intent = result.data ?: return@launch
                                )
                                authViewModel.onSignInResult(signInResult)
                            }
                        }
                    }
                )

                Button(
                    onClick = {
                        coroutineScope.launch {
                            val signInIntentSender = googleClientAuth.signIn()
                            launcher.launch(
                                IntentSenderRequest.Builder(
                                    signInIntentSender ?: return@launch
                                ).build()
                            )
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzureBlue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(300.dp)
                ) {
                    Text(text = "Get Started",
                        fontSize = 20.sp)
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier
                .height(325.dp))
            Image(
                painter = painterResource(id = R.drawable.justspeaklogo),
                contentDescription = null,
                alignment = Alignment.Center
            )
        }
        LaunchedEffect(key1 = state.isSignInSuccessful) {
            if (state.isSignInSuccessful) {
                Toast.makeText(
                    context,
                    "Sign in successful",
                    Toast.LENGTH_LONG
                ).show()
                justSpeakMainNavController.navigate(ScreenDestinations.Start.route)
                authViewModel.resetState()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JustSpeak_20Theme {
        val justSpeakMainNavController = rememberNavController()
        SplashScreen(justSpeakMainNavController)
    }
}