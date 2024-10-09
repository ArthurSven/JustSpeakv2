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

@Composable
fun getGermanExpressions(): Map<String, String> {
    return mapOf(
        "Entschuldigung" to "Excuse me",
        "Sprechen Sie Englisch/Sprichst du Englisch" to "Do you speak English",
        "Ja" to "Yes",
        "Nein" to "No",
        "Bitte" to "Please",
        "Danke" to "Thanks",
        "Gern geschehen" to "Pleasure",
        "Wie sagt man... auf deutsch" to "How do you say... in German",
        "Was ist das?" to "What is that?",
        "Sprechen Sie bitte langsamer" to "Speak slowly please",
        "Leise bitte!" to "Keep quiet!",
        "Mein Deutsch ist begrenzt" to "My German is limited",
        "Ich verstehe nicht" to "I do not understand",
        "Ich verstehe" to "I understand",
        "Wie kann ich..." to "How can I...",
        "Alles in Ordnung" to "Everything's alright",
        "Komm her" to "Come here",
        "Hau ab" to "Get out!"
    )
}

@Composable
fun getGermanEmergencyPhrases(): Map<String, String> {
    return mapOf(
        "Hilfe!" to "Help",
        "Achtung!" to "Attention!",
        "Beeilen Sie sich" to "Hurry up (formal)",
        "Beeil dich" to "Hurry up (informal)",
        "Sei Vorsichtig!" to "Be careful",
        "Pass auf!" to "Take care",
        "Können Sie mir helfen?" to "Can you help me? (formal)",
        "Kannst du mir helfen?" to "Can you help me? (informal)",
        "Wie kann ich Ihnen helfen?" to "How can I help you? (formal)",
        "Wie kann ich dir helfen?" to "How can I help you? (informal)",
        "Was ist passiert?" to "What happened?",
        "Ich habe einen Notfall" to "I have an emergency",
        "Es gab einen Unfall" to "There was an accident"
    )
}

fun getGermanMedicalEmergencyPhrases(): Map<String, String> {
    return mapOf(
        "Ich bin krank" to "I am sick",
        "Bring mich zum Krankenhaus" to "Take me to the hospital",
        "Ich bin verletzt" to "I am injured",
        "Ruf den KrankenWagen" to "Call the ambulance",
        "Feuer!" to "Fire!",
        "Ich habe eine Erkältung" to "I have a cold",
        "Sie ist in Ohnmacht gefallen" to "She fainted",
        "Er ist tot" to "He is dead",
        "Ich brauche einen Arzt" to "I need a doctor",
        "Ich habe mich verbrannt" to "I burned myself",
        "Ich habe mich geschnitten" to "I cut myself",
        "Ist alles in Ordnung?" to "Is everything alright?"
    )
}

@Composable
fun getGermanCrimeEmergencyPhrases(): Map<String, String> {
    return mapOf(
        "Ich wurde beraubt" to "I was robbed",
        "Mein Gepäck wurde gestohlen" to "My backpack was stolen",
        "Ruf die Polizei" to "Call the police",
        "Haltet den Dieb!" to "Stop the thief!",
        "Meine Wohnung wurde eingebrochen" to "My apartment was broken into",
        "Ich möchte ein Verbrechen melden" to "I would like to report a crime",
        "Ich habe meinen Pass verloren" to "I lost my passport",
        "Ich wurde angegriffen" to "I was assaulted",
        "Wo ist die nächste Polizeistation?" to "Where is the nearest police station?",
        "Jemand hat mich betrogen" to "Someone cheated me",
        "Mein Auto wurde gestohlen" to "My car was stolen",
        "Ich habe einen Verdächtigen gesehen" to "I saw a suspect",
        "Ich bin in Gefahr" to "I am in danger",
        "Ich brauche Schutz" to "I need protection",
        "Gibt es Zeugen?" to "Are there any witnesses?",
        "Haben Sie den Täter gesehen?" to "Did you see the perpetrator?"
    )
}