package com.devapps.justspeak_20.ui.Screens.languages.chichewa.chichewa_utility

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ChichewaAdjective(
    val chichewa: String,
    val english: String,
    val adjectiveList: List<String>
)

fun getChichewaAdjectives(): List<ChichewaAdjective> {
    return listOf(
        ChichewaAdjective(
            chichewa = "tsopano",
            english = "new",
            adjectiveList = listOf("Chatsopano-new (thing)", "Zatsopano-new (things)", "Watsopano-new (price)", "Yatsopano-new (prices)", "Latsopano-new (book)", "Atsopano-new (books)")
        ),
        ChichewaAdjective(
            chichewa = "kale",
            english = "old",
            adjectiveList = listOf("Chakale-old (thing)", "Zakale-old (things)", "Wakale-old (price)", "Yakale-old (prices)", "Lakale-old (book)", "Akale-old (books)")
        ),
        ChichewaAdjective(
            chichewa = "tali",
            english = "tall/long",
            adjectiveList = listOf("Chachitali-tall (thing)", "Zazitali-tall (things)", "Wamtali-tall (person)", "Aatali-long (arms)", "Yayitali-long (way)", "Lalitali-long (arm)")
        ),
        ChichewaAdjective(
            chichewa = "onda",
            english = "thin",
            adjectiveList = listOf("Choonda-thin (thing)", "Zoonda-thin (things)", "Woonda-thin (person)", "Oonda-thin (arms)", "Yoonda-thin (animal)")
        ),
        ChichewaAdjective(
            chichewa = "chepa",
            english = "few",
            adjectiveList = listOf("Zochepa-few (things)", "Chochepa-few (maize)")
        ),
        ChichewaAdjective(
            chichewa = "kongola",
            english = "beautiful",
            adjectiveList = listOf("Wokongola-beautiful (person)", "Chokongola-beautiful (thing)", "Zokongola-beautiful (things)", "Okongola-beautiful (people/dresses)", "Yokongola-beautiful (house)", "Lokongola-beautiful (dress)")
        ),
        ChichewaAdjective(
            chichewa = "nyansa",
            english = "ugly",
            adjectiveList = listOf("Wonyansa-ugly (person)", "Chonyansa-ugly (thing)", "Zonyansa-ugly (things)", "Onyansa-ugly (people/dresses)", "Yonyansa-ugly (house)", "Lonyansa-ugly (dress)")
        ),
        ChichewaAdjective(
            chichewa = "chuluka",
            english = "many",
            adjectiveList = listOf("Chochuluka-much (maize)", "Zochuluka-many (things)", "Ochuluka-many (people/dresses)")
        ),
        ChichewaAdjective(
            chichewa = "mbiri",
            english = "many",
            adjectiveList = listOf("Chambiri-much (maize)", "Zambiri-many (things)", "Ambiri-many (people/dresses)")
        ),
        ChichewaAdjective(
            chichewa = "fewa",
            english = "soft",
            adjectiveList = listOf("Chofewa-soft (thing)", "Zofewa-soft (things)")
        ),
        ChichewaAdjective(
            chichewa = "limba",
            english = "hard",
            adjectiveList = listOf("Cholimba-hard (thing)", "Zolimba-hard (things)")
        ),
        ChichewaAdjective(
            chichewa = "phweka",
            english = "easy",
            adjectiveList = listOf("Lophweka-easy (question)", "Zophweka-easy (things)", "Wophweka-easy (person)")
        ),
        ChichewaAdjective(
            chichewa = "vuta",
            english = "difficult/tough",
            adjectiveList = listOf("Lovuta-difficult/tough (question)", "Zovuta-difficult/tough (things)", "Wovuta-difficult (person)")
        )
    )
}


@Composable
fun ChichewaAdjectiveCard(chichewaAdjective: ChichewaAdjective) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    chichewaAdjective.chichewa,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    " - ",
                    color = Color.Black,
                    fontSize = 16.sp,
                )
                Text(
                    chichewaAdjective.english,
                    color = Color.Black,
                    fontSize = 16.sp,
                )
            }
            Spacer(
                modifier = Modifier
                    .height(7.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .height(100.dp)
            ) {
                items(chichewaAdjective.adjectiveList) { item ->
                    Text(
                        text = "- $item",
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp
                        )
                    )
                }
            }
        }
    }
}
