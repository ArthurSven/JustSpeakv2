package com.devapps.justspeak_20.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devapps.justspeak_20.ui.theme.AzureBlue

@Composable
fun getGermanAlphabetData(): List<String> {
    return listOf(
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Ä", "Ö", "Ü", "ß"
    )
}

@Composable
fun getGermanAdjectives(): Map<String, List<String>> {
    return mapOf(
        "German" to listOf("Alt", "Neu", "Jung", "Groß", "Klein", "Schön", "Hässlich", "Früh", "Spät", "Leicht",
            "Schwierig", "Langsam", "Schnell", "Lang", "Kurz", "Dick", "Dünn"),
        "English" to listOf("Old", "New", "Young", "Tall", "Short/Small", "Beautiful", "Ugly", "Early", "Late",
            "Easy", "Hard", "Slow", "Fast", "Long", "Short", "Fat", "Thin")
    )
}

@Composable
fun GermanDefEndTable() {
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
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "e",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Acc",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black,)
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Dat",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Gen",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black)
    }
}

@Composable
fun GermanIndEndTable() {
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
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold)
        Text(text = "er",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "es",
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
        Text(text = "en",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "es",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
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
                .padding(start = 5.dp))
        Text(text = "en",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
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
        Text(text = "en",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            color = Color.Black,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
}


