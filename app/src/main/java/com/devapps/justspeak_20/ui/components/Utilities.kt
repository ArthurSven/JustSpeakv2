package com.devapps.justspeak_20.ui.components

import android.graphics.Bitmap
import android.icu.util.Calendar
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
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.SortByAlpha
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
@Preview(showBackground = true)
fun ViewComponents() {

}