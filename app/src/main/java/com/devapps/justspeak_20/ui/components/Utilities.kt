package com.devapps.justspeak_20.ui.components

import android.graphics.Bitmap
import android.icu.util.Calendar
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.Airlines
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Cases
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Rocket
import androidx.compose.material.icons.filled.SortByAlpha
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddComment
import androidx.compose.material.icons.outlined.Airlines
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.Cases
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.LockClock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.Rocket
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.devapps.justspeak_20.R
import com.devapps.justspeak_20.data.models.UserData
import com.devapps.justspeak_20.ui.theme.AzureBlue
import com.devapps.justspeak_20.ui.theme.seaBlue
import com.devapps.justspeak_20.ui.theme.teal
import com.devapps.justspeak_20.utils.GermanPronounList
import okhttp3.Route
import kotlin.math.roundToInt

@Composable
fun UserProfileBar(userData: UserData?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 10.dp)
    ) {
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
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
            Column {
                Text(
                    text = "${userData.username}",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${userData.email}",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        } else {
            Image(
                painter = painterResource(R.drawable.no_profile),
                contentDescription = "Arthur's profile picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(
                modifier = Modifier
                    .width(5.dp)
            )
            Column {
                Text(
                    text = "Arthur Msiska",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "arthursvenmsiska@gmail.com",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

fun displayGreeting() : String {
    val calendar = Calendar.getInstance()
    val timeOfTheDay = calendar.get(Calendar.HOUR_OF_DAY)

    return when (timeOfTheDay) {
        in 0..11 -> "Good Morning"
        in 12..16 -> "Good Afternoon"
        in 17..23 -> "Good Evening"
        else -> "Greetings"
    }
}

data class LanguageCardItem(
    val nation: Int,
    val sprache: String,
    val itemRoute: String
)

@Composable
fun LanguageCard(
    selected: Boolean,
    onClick: () -> Unit,
    country: Int,
    language: String
) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            modifier = Modifier
                .height(200.dp)
                .width(320.dp)
                .padding(end = 15.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(country), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                        .height(150.dp)
                   //colorFilter = ColorFilter.tint(Color.DarkGray, blendMode = BlendMode.Hue)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp)
                ) {
                    Spacer(modifier = Modifier
                        .height(40.dp)
                    )
                    Text(text = language,
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier
                        .height(40.dp)
                    )
                    ElevatedButton(
                        onClick = {
                            onClick()
                        },
                        colors = ButtonColors(
                            containerColor = AzureBlue,
                            contentColor = Color.White,
                            disabledContentColor = Color.White,
                            disabledContainerColor = AzureBlue
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Get Started")
                    }
                }
            }
        }
}

@Composable
fun LanguageProgressCard() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = AzureBlue
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            ) {
            Spacer(modifier = Modifier
                .height(30.dp)
            )
            Row(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(R.drawable.wappen),
                    contentDescription = "Arthur's profile picture",
                    modifier = Modifier
                        .size(70.dp)
                        .border(5.dp, Color.White, CircleShape)
                        .clip(RoundedCornerShape(35.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier
                    .width(10.dp)
                )
                Column {
                    Text(text = "German Section",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                    Text(text = "Progress",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier
                        .height(10.dp)
                    )
                    Text(text = "65%",
                        color = Color.White
                    )
                        LinearProgressIndicator(
                            progress = {
                                0.65F
                            },
                            color = Color.White,
                            trackColor = seaBlue
                        )

                }
            }


        }
    }
}

data class TopicItem(
    val topicTitle: String,
    val topicIcon: ImageVector,
    val topicPercent: Float,
    val topicRoute: String
)
@Composable
fun TopicCard(
    selected: Boolean,
    title: String,
    icon: ImageVector,
    percent: Float,
    onClick: () -> Unit,
) {
    val percentage = (percent * 100).roundToInt().toString() + "%"
    ElevatedCard(
        modifier = Modifier
            .width(240.dp)
            .height(130.dp)
            .padding(end = 15.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier
                .height(10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .width(20.dp)
                )
                Icon(imageVector = icon, contentDescription = null,
                    modifier = Modifier
                        .size(40.dp),
                    tint = AzureBlue)
            }
            Spacer(modifier = Modifier
                .height(10.dp)
            )
            Text(text = percentage,
                modifier = Modifier
                    .fillMaxWidth(),
                color = AzureBlue,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                fontSize = 16.sp
            )
            LinearProgressIndicator(progress = {
                percent
            },
                color = AzureBlue,
                trackColor = Color.LightGray)
        }
    }
}


@Composable
fun AlphabetCard(letter : String,textToSpeech: TextToSpeech) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(70.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp
        ),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = letter,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .width(200.dp))
                IconButton(
                    onClick = {
                        textToSpeech.speak(letter, TextToSpeech.QUEUE_FLUSH, null, null)
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Mic, contentDescription = "Microphone",
                        tint = AzureBlue,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun makeBulletedList(items: List<String>): AnnotatedString {
    val bulletString = "\u2022\t\t"
    val textStyle = LocalTextStyle.current
    val textMeasurer = rememberTextMeasurer()
    val bulletStringWidth = remember(textStyle, textMeasurer) {
        textMeasurer.measure(text = bulletString, style = textStyle).size.width
    }
    val restLine = with(LocalDensity.current) { bulletStringWidth.toSp() }
    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = restLine))

    return buildAnnotatedString {
        items.forEach { text ->
            withStyle(style = paragraphStyle) {
                append(bulletString)
                append(text)
            }
        }
    }
}

val bestimmteArtikeln = listOf(
"Der",
"Die",
"Das",
    "Die"
)

val bestimmteArtikelnExamples = listOf(
    "Der Junge singt - The boy is singing.",
    "Die Frau tanzt  - The woman is dancing.",
    "Das Kind weint  - The child is crying.",
    "Die Frauen lachen - The women are laughing"
)

val unbestimmteArtikeln = listOf(
    "Ein",
    "Eine",
    "Ein"
)

val unbestimmteArtikelnExamples = listOf(
    "Ein Junge singt - A boy is singing.",
    "Eine Frau tanzt  - A woman is dancing.",
    "Eine Kind weint  - A child is crying."
)
data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)

val tabItems = listOf(
    TabItem(
        title = "Adjectives",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Endings",
        Icons.Outlined.Article,
        Icons.Filled.Article
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    )
)

val caseTabItems = listOf(
    TabItem(
        title = "Articles",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Cases",
        Icons.Outlined.Cases,
        Icons.Filled.Cases
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    )
)

val nounTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Place",
        Icons.Outlined.LocationOn,
        Icons.Filled.LocationOn
    ),
    TabItem(
        title = "Food",
        Icons.Outlined.Fastfood,
        Icons.Filled.Fastfood
    ),
    TabItem(
        title = "Body",
        Icons.Outlined.AccountCircle,
        Icons.Filled.AccountCircle
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    )
)

val prepositionTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Dative",
        Icons.Outlined.Badge,
        Icons.Filled.Badge
    ),
    TabItem(
        title = "Two-Way",
        Icons.Outlined.Airlines,
        Icons.Filled.Airlines
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)

val pronounTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)

val sentenceTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Sub",
        Icons.Outlined.AddComment,
        Icons.Filled.AddComment
    ),
    TabItem(
        title = "conjunc",
        Icons.Outlined.Add,
        Icons.Filled.Add
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)

val tenseTabItems = listOf(
    TabItem(
        title = "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TabItem(
        title = "Past",
        Icons.Outlined.LockClock,
        Icons.Filled.LockClock
    ),
    TabItem(
        title = "Future",
        Icons.Outlined.Rocket,
        Icons.Filled.Rocket
    ),
    TabItem(
        title = "Quiz",
        Icons.Outlined.Quiz,
        Icons.Filled.Quiz
    ),
)

@Composable
fun TranslatableItem(deu: String, eng: String, textToSpeech: TextToSpeech) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = deu,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = eng,
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                IconButton(
                    onClick = {
                        textToSpeech.speak(deu, TextToSpeech.QUEUE_FLUSH, null, null)
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Mic, contentDescription = "Microphone",
                        tint = AzureBlue,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GrammarRow(german: String, english: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = german,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(0.50f)
                .padding(start = 5.dp),
            color = Color.Black
        )
        Text(
            text = english,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(0.50f)
                .padding(start = 5.dp),
            color = Color.Black
        )
    }
}

@Composable
fun CaseParagraph(
    case: String,
    description: String,
    example: String) {
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
                text = case,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier
                    .height(3.dp)
            )
            Text(text = description,
                color = Color.Black)
            Spacer(
                modifier = Modifier
                    .height(3.dp)
            )
            Text(text = "e.g. $example",
                color = Color.Black)
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
        }
    }
}

@Composable
fun GermanDefiniteArticleTable() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(color = AzureBlue)
        ) {
            Text(text = "Case",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "Masc",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "Fem",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "Neu",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "Plu",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(text = "Nom",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "der",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "die",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "das",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "die",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(text = "Acc",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "den",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "die",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "das",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "die",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(text = "Dat",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "dem",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "der",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "dem",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "den",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(text = "Gen",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "des",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "der",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "des",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "der",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
    }
}

@Composable
fun GermanIndefiniteArticleTable() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(color = AzureBlue)
        ) {
            Text(text = "Case",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "Masc",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "Fem",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "Neu",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "Plu",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(text = "Nom",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "ein",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "eine",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "ein",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "-",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(text = "Acc",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "einen",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "eine",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "ein",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "-",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(text = "Dat",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "einem",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "einer",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "einem",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "-",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Text(text = "Gen",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "eines",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "einer",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "eines",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "-",
                color = Color.Black,
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
    }
}

@Composable
fun PronounRow(nominative: String, accusative: String, dative: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Text(
            text = nominative,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = accusative,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = dative,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun GermanPronounTable() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(color = Color(0xFF007FFF)) // AzureBlue color
        ) {
            Text(
                text = "Nominative",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
            Text(
                text = "Accusative",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
            Text(
                text = "Dative",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
        }
        GermanPronounList()
    }
}

@Composable
@Preview(showBackground = true)
fun ViewComponents() {
    CaseParagraph(case = "Nominative", description = "sdfsdfsfs", example = "sfafsVSDBDAFBANDNH")
}