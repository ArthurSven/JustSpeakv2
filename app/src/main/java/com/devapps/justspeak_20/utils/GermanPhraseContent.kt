package com.devapps.justspeak_20.utils

import androidx.compose.runtime.Composable

@Composable
fun getGermanIntroductions(): Map<String, String> {
    return mapOf(
        "Guten Tag" to "Good day",
        "Guten Morgen" to "Good morning",
        "Guten Abend" to "Good evening",
        "Gute Nacht" to "Good night",
        "Hallo" to "Hello",
        "Grüß Gott" to "Hello (Austria)",
        "Servus" to "Hello (Bavaria",
        "Grüezi" to "Hello (Switzerland)",
        "Moin" to "Hello (Northern Germany)",
        "Guete Morge" to "Good morning (Switzerland)",
        "Guete Abig" to "Good evening (Switzerland)",
        "Grias di" to "Hello (Bavaria)"
    )
}

@Composable
fun getGermanGoodbyes(): Map<String, String> {
    return mapOf(
        "Tschüss" to "Bye",
        "Tschau" to "Bye",
        "Auf Wiedersehen" to "See you again",
        "Auf Wiederhören" to "See you later (phone)",
        "Bis bald" to "See you soon",
        "Bis später" to "See you later",
        "Bis dann" to "Until then",
        "Pfiad di" to "Bye (Bavaria/Austria)",
        "Ade" to "Bye (Switzerland)",
        "Uf Wiederluege" to "See you again (Switzerland)"
    )
}

@Composable
fun getGermanGreetingExpressions(): Map<String, String> {
    return mapOf(
        "Wie geht es dir/Ihnen?" to "How are you (informal/formal)",
        "Mir geht es gut" to "I am doing well",
        "und dir/Ihnen?" to "And you?",
        "auch gut danke" to "Good too, thanks",
        "Mir geht es nicht gut" to "I am not doing well",
        "so lala" to "So and so",
        "Mir geht es schlecht" to "I am not well",
        "Mir geht es besser" to "I am doing better",
        "Wie göht's dr/ine?" to "How are you - inf/formal (Switzerland)",
        "Mir gaihts guet" to "I am doing well (Switzerland)",
        "wia gehd's/ wia gehd's eana" to "How are you - inf/formal (Bavaria)",
        "guad und dir/eana" to "Good and you? - inf/formal (Bavaria)",
        "Alles gut bei dir?" to "Everything alright?",
        "Alles in Ordnung?" to "Everything in order?",
        "Na?" to "How's it going"
    )
}

@Composable
fun getGermanIntroductoryPhrases(): Map<String, String> {
    return mapOf(
        "Darf ich ... vorstellen?" to "May I introduce...",
        "Das ist" to "This is",
        "Wie heißt du/heißen Sie?" to "What's your name - inf/formal",
        "Ich heiße" to "I am called",
        "Wie ist dein/Ihr Name?" to "What's your name",
        "Mein Name ist" to "My name is",
        "Ich bin ..." to "I am ...",
        "Wia hoaßt du" to "What's your name (Bavarian)",
        "Wie heissisch du" to "What's your name (Switzerland)",
        "Woher kommst du" to "Where are you from",
        "Ich komme aus ..." to "I come from",
        "Wohar chunsch" to "Where are you from (Switzerland)",
        "Ich chume us" to "I come from (Switzerland)",
        "Wo wohnst du" to "Where do you live",
        "Ich wohne in..." to "I live in..."
    )
}

