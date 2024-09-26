package com.devapps.justspeak_20.ui.components

import android.graphics.Bitmap
import android.icu.util.Calendar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.devapps.justspeak_20.ui.theme.teal

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
@Preview(showBackground = true)
fun ViewComponents() {
}