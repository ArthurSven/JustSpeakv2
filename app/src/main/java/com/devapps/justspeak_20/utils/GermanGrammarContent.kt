package com.devapps.justspeak_20.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak_20.ui.components.PronounRow
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
fun germanPeopleNouns(): Map<String, String> {
    return mapOf(
        "die Mutter" to "Mother",
        "der Vater" to "Father",
        "die Töchter" to "Daughter",
        "der Sohn" to "Son",
        "der Onkel" to "Uncle",
        "die Tante" to "Aunt",
        "der Großvater" to "Grandfather",
        "die Großmutter" to "Grandmother",
        "der Enkel" to "Grandson",
        "die Enkelin" to "Granddaughter",
        "die Cousine" to "Cousin (female)",
        "der Cousin" to "Cousin (male)",
        "der Bruder" to "Brother",
        "die Schwester" to "Sister",
        "der Mann" to "Man",
        "die Frau" to "Woman",
        "der Junge" to "Boy",
        "das Mädchen" to "Girl",
        "der Urgroßvater" to "Great-Grandfather",
        "die Urgroßmutter" to "Great-Grandmother",
        "der Urenkel" to "Great-Grandson",
        "die Urenkelin" to "Great-Granddaughter",
        "der Freund von mir" to "Friend (male)",
        "die Freundin von mir" to "Friend (female)",
        "der Freund" to "Boyfriend",
        "die Freundin" to "Girlfriend",
        "Papa" to "dad",
        "Mama" to "mum",
        "Opa" to "Grandpa",
        "Oma" to "Grandma"
    )
}

@Composable
fun getGermanPlaceNouns(): Map<String, String> {
    return mapOf(
        "das Haus" to "House",
        "die Wohnung" to "Apartment",
        "das Gebäude" to "Building",
        "die Stadt" to "City",
        "das Land" to "Country",
        "das Dorf" to "Village",
        "der See" to "Lake",
        "das Meer" to "Sea",
        "der Berg" to "Mountain",
        "der Strand" to "Beach",
        "der Laden" to "Shop",
        "die Straße" to "Street/Road",
        "die Gemeinde" to "Community",
        "die Kirche" to "Church",
        "die Moschee" to "Mosque"
    )
}

@Composable
fun germanFoodNouns(): Map<String, String> {
    return mapOf(
        "der Apfel" to "Apple",
        "die Banane" to "Banana",
        "der Rindfleisch" to "Beef",
        "das Huhn" to "Chicken",
        "der Schweinfleisch" to "Pork",
        "das Gemüse" to "Vegetables",
        "der Kuchen" to "Cake",
        "die Kartoffeln" to "Potatoes",
        "die Pommes" to "Chips/Fries",
        "das Wasser" to "Water",
        "der Kaffee" to "Coffee",
        "der Tee" to "Tea",
        "die Böhnen" to "Beans",
        "der Reis" to "Rice",
        "der Saft" to "Juice",
        "das Bier" to "Beer",
        "Brot" to "Bread",
        "Frühstück" to "Breakfast",
        "Mittagessen" to "Lunch",
        "Abendessen" to "Dinner",
        "die Teller" to "Plate",
        "die Tasse" to "Cup",
        "die Gabel" to "Fork",
        "der Löffel" to "Spoon",
        "das Messer" to "Knife"
    )
}

@Composable
fun germanBodyPartNouns(): Map<String, String> {
    return mapOf(
        "das Auge" to "Eye",
        "der Kopf" to "Head",
        "der Körper" to "Body",
        "die Nase" to "Nose",
        "der Mund" to "Mouth",
        "das Ohr" to "Ear",
        "die Haare" to "Hair",
        "der Hals" to "Neck",
        "der Arm" to "Arm",
        "der Finger" to "Finger",
        "die Brust" to "Chest",
        "der Ellbogen" to "Elbow",
        "der Knochen" to "Bone",
        "das Bein" to "Leg",
        "der Fuß" to "Foot",
        "das Zeh" to "Toe",
        "der Haut" to "Skin",
        "der Rücken" to "Back"
    )
}

fun germanNumbersTo10() : Map<String, String> {
    return mapOf(
        "eins" to "one",
        "zwei" to "two",
        "drei" to "three",
        "vier" to "four",
        "fünf" to "five",
        "sechs" to "six",
        "sieben" to "seven",
        "acht" to "eight",
        "neun" to "nine",
        "zehn" to "ten"
    )
}

fun germanNumbersTo20() : Map<String, String> {
    return mapOf(
        "elf" to "eleven",
        "zwölf" to "twelve",
        "dreizehn" to "thirteen",
        "vierzehn" to "fourteen",
        "fünfzehn" to "fifteen",
        "sechzehn" to "sixteen",
        "siebzehn" to "seventeen",
        "achtzehn" to "eighteen",
        "neunzehn" to "nineteen",
        "zwanzig" to "twenty"
    )
}

fun germanNumbersTo29() : Map<String, String> {
    return mapOf(
        "einundzwanzig" to "twenty-one",
        "zweiundzwanzig" to "twenty-two",
        "dreiundzwanzig" to "twenty-three",
        "vierundzwanzig" to "twenty-four",
        "fünfundzwanzig" to "twenty-five",
        "sechsundzwanzig" to "twenty-six",
        "siebenundzwanzig" to "twenty-seven",
        "achtundzwanzig" to "twenty-eight",
        "neunundzwanzig" to "twenty-nine"
    )
}

fun germanNumbersTo129(): Map<String, String> {
    return mapOf(
        "einhunderteinundzwanzig" to "121",
        "einhundertzweiundzwanzig" to "122",
        "einhundertdreiundzwanzig" to "123",
        "einhundertvierundzwanzig" to "124",
        "einhundertfünfundzwanzig" to "125",
        "einhundertsechsundzwanzig" to "126",
        "einhundertsiebenundzwanzig" to "127",
        "einhundertachtundzwanzig" to "128",
        "einhundertneunundzwanzig" to "129"
    )
}


fun germanNumbers30To90() : Map<String, String> {
    return mapOf(
        "dreißig" to "thirty",
        "vierzig" to "forty",
        "fünfzig" to "fifty",
        "sechzig" to "sixty",
        "siebzig" to "seventy",
        "achtzig" to "eighty",
        "neunzig" to "ninety"
    )
}

fun germanNumbersTo120(): Map<String, String> {
    return mapOf(
        "einhundert" to "100",
        "einhunderteins" to "101",
        "einhundertzwei" to "102",
        "einhundertdrei" to "103",
        "einhundertvier" to "104",
        "einhundertfünf" to "105",
        "einhundertsechs" to "106",
        "einhundertsieben" to "107",
        "einhundertacht" to "108",
        "einhundertneun" to "109",
        "einhundertzehn" to "110",
        "einhundertelf" to "111",
        "einhundertzwölf" to "112",
        "einhundertdreizehn" to "113",
        "einhundertvierzehn" to "114",
        "einhundertfünfzehn" to "115",
        "einhundertsechzehn" to "116",
        "einhundertsiebzehn" to "117",
        "einhundertachtzehn" to "118",
        "einhundertneunzehn" to "119",
        "einhundertzwanzig" to "120"
    )
}

@Composable
fun germanAccusativePrepositions(): Map<String, String> {
    return mapOf(
        "für" to "for",
        "um" to "around",
        "bis" to "until",
        "gegen" to "against",
        "durch" to "through",
        "entlang" to "along",
        "ohne" to "without",
        "wider" to "against (opposition)"
    )
}

@Composable
fun germanDativePrepositions(): Map<String, String> {
    return mapOf(
        "mit" to "with",
        "aus" to "out of",
        "außer" to "except for/apart from",
        "bei" to "at",
        "nach" to "after",
        "seit" to "since",
        "von" to "from",
        "zu" to "to, at",
        "gegenüber (von)" to "opposite of"
    )
}

@Composable
fun germanGenitivePrepositions(): Map<String, String> {
    return mapOf(
        "innerhalb" to "within/inside of",
        "außerhalb" to "outside of",
        "anstatt/statt" to "instead of",
        "trotz" to "despite",
        "während" to "during",
        "wegen" to "because of"
    )
}

@Composable
fun germanTwoWayPrepositions(): Map<String, String> {
    return mapOf(
        "an" to "on",
        "auf" to "on top of",
        "hinter" to "behind",
        "neben" to "next to",
        "in" to "in",
        "über" to "above",
        "unter" to "under",
        "vor" to "in front of"
    )
}

@Composable
fun getGermanPronouns(): Map<String, Triple<String, String, String>> {
    return mapOf(
        "Ich" to Triple("Ich (I)", "mich (me)", "mir (to me)"),
        "Du" to Triple("Du (you)", "dich (you)", "dir (to you)"),
        "Er" to Triple("Er (he)", "ihn (him)", "ihm (to him/it)"),
        "Sie" to Triple("Sie (she)", "sie (her)", "ihr (to her/it)"),
        "Es" to Triple("Es (it)", "es (it)", "ihm (to it)"),
        "Wir" to Triple("Wir (we)", "uns (us)", "uns (to us)"),
        "Ihr" to Triple("Ihr (you plural)", "euch (you plural)", "euch (to you plural)"),
        "Sie formal" to Triple("Sie (You formal)", "sie (you)", "Ihnen (to you formal)"),
        "sie" to Triple("sie (they)", "sie (them)", "ihnen (to them)")
    )
}

@Composable
fun GermanPronounList() {
    val pronouns = getGermanPronouns()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        pronouns.forEach { (key, value) ->
            item {
                PronounRow(
                    nominative = value.first,
                    accusative = value.second,
                    dative = value.third
                )
            }
        }
    }
}

fun germanConjunctions() : Map<String, String> {
    return mapOf(
        "und" to "and",
        "aber" to "but",
        "oder" to "or",
        "denn" to "because (since)",
        "sondern" to "but rather/instead"
    )
}

fun germanConjunctionsAffectWordOrder() : Map<String, String> {
    return mapOf(
        "weil" to "because",
        "dass" to "that",
        "wenn" to "if/when",
        "ob" to "whether/if",
        "obwohl" to "although",
        "damit" to "so that",
        "nachdem" to "after",
        "bevor" to "before",
        "während" to "while/during",
        "sobald" to "as soon as",
        "seit" to "since (time)",
        "falls" to "in case",
        "indem" to "by doing something",
        "trotzdem" to "nevertheless",
        "sobald" to "as soon as",
        "sowohl ... als auch" to "both ... and",
    )
}

fun germanConjunctionsTwoPart() : Map<String, String> {
    return mapOf(
        "entweder ... oder" to "either ... or",
        "weder ... noch" to "neither ... nor",
        "sowohl ... als auch" to "both ... and",
        "nicht nur ... sondern auch" to "not only ... but also"
    )
}

@Composable
fun germanCommonVerbs() : List<String> {
    return listOf(
        "haben", "sein", "werden", "können", "machen", "gehen", "sollen", "kommen", "geben", "sagen",
        "müssen", "sehen", "finden", "mögen", "dürfen", "fahren", "liegen", "lassen", "stehen",
        "heißen"
    )
}

@Composable
fun englishCommonVerbs() : List<String> {
    return listOf(
        "to have", "to be", "to become", "to be able to", "to do", "to go", "should", "to come",
        "to give", "to say", "must", "to see", "to find", "to like", "to be allowed to", "to drive",
        "to lay", "to let", "to stand", "to be called"
    )
}

@Composable
fun GermanVerbList() {
    val verb = germanCommonVerbs()
    val translation = englishCommonVerbs()

    LazyColumn(
        modifier = Modifier
            .height(400.dp)
    ) {
        items(verb) { germanVerbs ->
            val index = verb.indexOf(germanVerbs)
            val translatedVerbs = if (index < translation.size) translation[index] else ""

            VerbRow(verbs = germanVerbs, translations = translatedVerbs)
        }
    }
}

@Composable
fun VerbRow(verbs: String, translations: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Text(
            text = verbs,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(0.50f)
                .padding(start = 5.dp)
        )
        Text(
            text = translations,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(0.50f)
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun VerbTable() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(color = AzureBlue)
        ) {
            Text(
                text = "Verb",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.50f)
                    .padding(start = 5.dp)
            )
            Text(
                text = "Translation",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.50f)
                    .padding(start = 5.dp)
            )
        }
        Spacer(modifier = Modifier
            .height(5.dp))
        GermanVerbList()
    }
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

@Composable
fun ConjugationTableRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(color = AzureBlue)
    ) {
        Text(
            text = "Pronoun",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = "Conj",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = "Transl",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun ConjugationTableItem(pron: String, conj: String, trans: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = pron,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = conj,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = trans,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun getHabenConjugation() : List<String> {
    return listOf(
        "Ich habe", "Du hast (informal)", "Er hat", "Sie hat", "Es hat", "Wir haben",
        "Ihr habt (informal)", "Sie haben (formal)", "Sie haben"
    )
}

@Composable
fun getHaveTranslation() : List<String> {
    return listOf(
        "I have", "You have", "He has", "She has", "It has", "We have", "You have", "You have",
        "They have"
    )
}

@Composable
fun getNominativePronouns() : List<String> {
    return listOf(
        "Ich (I)", "Du (you)", "Er (he)", "Sie (she)", "Es (it)", "Wir (we)", "Ihr (you plural)",
        "Sie (You formal)", "sie (they)"
    )
}

@Composable
fun getAccusativePronouns() : List<String> {
    return listOf(
        "mich (me)", "dich (you)", "ihn (him)", "sie(her)", "es (it)", "uns (us)", "euch (you)",
        "sie (you)", "sie (them)"
    )
}

@Composable
fun getDativePronouns() : List<String> {
    return listOf(
        "mir (to me)", "dir (to you)", "ihm (to him/it)", "ihr (to her/it)", "ihm (to it)",
        "uns (to us)", "euch (to you)", "Ihnen (to you)", "ihnen (to them)"
    )
}

@Composable
fun HabenList() {
    val pro = getNominativePronouns()
    val conjugator = getHabenConjugation()
    val habeTranslate = getHaveTranslation()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(pro) { habeConj ->
            val index = pro.indexOf(habeConj)
            val conjugation = if (index < conjugator.size) conjugator[index] else ""
            val translation = if (index < habeTranslate.size) habeTranslate[index] else ""

            ConjugationTableItem(habeConj, conjugation, translation)
        }
    }
}

@Composable
fun HabenConjugationTable() {
    Column {
        ConjugationTableRow()
        HabenList()
    }
}

@Composable
fun SeinConjugationTable() {
    Column {
        ConjugationTableRow()
        SeinList()
    }
}

@Composable
fun KannConjugationTable() {
    Column {
        ConjugationTableRow()
        KannList()
    }
}

@Composable
fun SeinList() {
    val pro = getNominativePronouns()
    val conjugator = getSeinConjugation()
    val habeTranslate = getSeinTranslated()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(pro) { seinConj ->
            val index = pro.indexOf(seinConj)
            val conjugation = if (index < conjugator.size) conjugator[index] else ""
            val translation = if (index < habeTranslate.size) habeTranslate[index] else ""

            ConjugationTableItem(seinConj, conjugation, translation)
        }
    }
}

@Composable
fun KannList() {
    val pro = getNominativePronouns()
    val conjugator = getKannConjugation()
    val habeTranslate = getKannTranslated()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(pro) { kannConj ->
            val index = pro.indexOf(kannConj)
            val conjugation = if (index < conjugator.size) conjugator[index] else ""
            val translation = if (index < habeTranslate.size) habeTranslate[index] else ""

            ConjugationTableItem(kannConj, conjugation, translation)
        }
    }
}

@Composable
fun getSeinConjugation() : List<String> {
    return listOf(
        "Ich bin", "Du bist (informal)", "Er ist", "Sie ist", "Es ist", "Wir sind", "Ihr seid  (informal)",
        "Sie haben (formal)", "Sie haben"
    )
}

@Composable
fun getSeinTranslated() : List<String> {
    return listOf(
        "I am", "You are", "He is", "She is", "It is", "We are", "You are", "You are", "They are"
    )
}

fun getKannConjugation() : List<String> {
    return listOf(
        "Ich kann", "Du kannst (informal)", "Er kann", "Sie kann", "Es kann", "Wir können", "Ihr könnt (informal)",
        "Sie können (formal)", "Sie können"
    )
}

fun getKannTranslated() : List<String> {
    return listOf(
        "I can", "You can", "He can", "She can", "It can", "We can", "You can", "You can", "They can"
    )
}