package com.devapps.justspeak_20.ui.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.devapps.justspeak_20.R
import com.devapps.justspeak_20.data.models.UserData

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