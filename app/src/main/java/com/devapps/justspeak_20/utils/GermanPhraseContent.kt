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
        "Moin" to "Hello (Northern Germany)"
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
        "Bis dann" to "Until then"
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
        "Woher kommst du" to "Where are you from",
        "Ich komme aus ..." to "I come from",
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

@Composable
fun getGermanEatingPhrases(): Map<String, String> {
    return mapOf(
        "Einen Tisch für vier, bitte" to "A table for four, please",
        "Ist dieser Platz frei?" to "Is this seat free?",
        "Die Speiserkarte, bitte" to "Menu, please",
        "Ich möchte bestellen" to "I would like to order",
        "Ich hätte gern..." to "I would like...",
        "Was würden Sie empfehlen?" to "What would you recommend?",
        "Nein, das habe ich nicht bestellt" to "No, I did not order this",
        "Hat es ihnen/dir geschmeckt?" to "Did you enjoy the food?",
        "Noch eins" to "One more",
        "Guten Appetite" to "Have a nice meal",
        "Prost" to "Cheers!",
        "Sonst noch was?" to "Anything else?",
        "Entschuldigen Sie bitte" to "Excuse me",
        "Zahlen, bitte" to "Bill please",
        "Könnte ich das einpacken lassen?" to "Can I have this wrapped?",
        "Ich möchte eine Reservierung machen" to "I would like to make a reservation",
        "an Guadn" to "Have a nice meal (Bavarian)",
        "en Guete" to "Have a nice meal (Switzerland)",
        "Kann ich mit Karte bezahlen?" to "Can I pay with a card?",
        "Kann ich mit Bargeld bezahlen?" to "Can I pay with cash?",
        "Ich bezahle mit Karte" to "I will pay with a card",
        "Ich bezahle mit Bargeld" to "I will pay with cash"
    )
}

@Composable
fun getGermanShoppingPhrases(): Map<String, String> {
    return mapOf(
        "Ich gehe einkaufen" to "I am going shopping",
        "Wo kann ich .. finden?" to "Where can I find...?",
        "Wie viel kostet das?" to "How much does this cost?",
        "der Preis" to "The price",
        "die Kleidung" to "the clothes",
        "das Geschäft" to "the shop",
        "Haben Sie...?" to "Do you have...?",
        "Verkaufen Sie?" to "Do you sell...?",
        "Ich suche..." to "I am looking for...",
        "Ich möchte ..." to "I would like...",
        "Das ist teuer" to "That's expensive",
        "Das ist billig" to "That's cheap",
        "Kann ich eine Quittung haben?" to "Can I have a receipt?",
        "auf welcher Stock kann ich ... finden" to "On which floor can I find...?",
        "Wo finde ich ..." to "Where can I find...?",
        "Das gefällt mir" to "I like that",
        "Das gefällt mir nicht" to "I don't like that",
        "Probier es an" to "Try it on"
    )
}

@Composable
fun getGermanQuestionStarters(): Map<String, String> {
    return mapOf(
        "Was" to "What",
        "Wie" to "How",
        "Wo" to "Where",
        "Wann" to "When",
        "Welche" to "Which",
        "Wer" to "Who",
        "Warum" to "Why",
        "Wieso" to "Why",
        "Woher" to "Where... from",
        "Wohin" to "Where... to",
        "Was für" to "What kind of"
    )
}

@Composable
fun getGermanFormQuestions(): Map<String, String> {
    return mapOf(
        "Was ist das?" to "What's this/that?",
        "Wie komme ich zum Bahnhof?" to "How do I get to the train station?",
        "Wo ist das Badezimmer?" to "Where is the bathroom?",
        "Wann kommt der Bus an?" to "When does the bus arrive?",
        "Welche Mannschaft unterstützen Sie?" to "Which team do you support?",
        "Wer hat mein Pizza gegessen?" to "Who ate my pizza?",
        "Woher kommt er?" to "Where does he come from?",
        "Wohin geht Ihr?" to "Where are you guys going to?",
        "Was für ein Auto ist das?" to "What kind of car is that?"
    )
}

@Composable
fun getGermanVerbQuestions(): Map<String, String> {
    return mapOf(
        "Kannst du mir eine Nachricht schicken?" to "Can you send me a message?",
        "Trinkst du auch Bier?" to "Do you also drink beer?",
        "Kommen Sie zur Party?" to "Are you coming to the party?",
        "Arbeitest du bei IKEA?" to "Do you work at IKEA?",
        "Bist du müde?" to "Are you tired?",
        "Sind sie jetzt besser?" to "Are they better now?"
    )
}

@Composable
fun getGermanTimeEssentialPhrases(): Map<String, String> {
    return mapOf(
        "Entschuldigung, wie viel Uhr ist es?" to "Excuse me, what time is it?",
        "Wie spät ist es?" to "What time is it (How late is it)",
        "Es ist ... Uhr" to "It is ... o'clock",
        "die Zeit" to "The time",
        "Der Tag" to "The day",
        "Das Jahr" to "The year",
        "Gestern" to "Yesterday",
        "Heute" to "Today",
        "Morgen" to "Tomorrow",
        "Mittag" to "Midday",
        "Nachmittag" to "Afternoon",
        "Abend" to "Evening",
        "Nacht" to "Night",
        "Letztes Jahr" to "Last year",
        "Dieses Jahr" to "This year",
        "Nächstes Jahr" to "Next year",
        "Diesen Monat" to "This month",
        "Letzten Monat" to "Last month",
        "Nächstes Jahr" to "Next year",
        "Diesen Monat" to "This month",
        "Letzten Monat" to "Last month",
        "Nächsten Monat" to "Next month"
    )
}

@Composable
fun getGermanTime(): Map<String, String> {
    return mapOf(
        "Es ist ein Uhr" to "01:00",
        "Es ist kurz nach zwei" to "02:03",
        "Fünf nach drei" to "03:05",
        "Zehn nach drei" to "03:10",
        "Viertel nach drei" to "03:15",
        "Zwanzig nach vier" to "04:20",
        "Fünf vor halb sechs" to "05:25",
        "Halb sechs" to "05:30",
        "Fünf nach halb sechs" to "05:35",
        "Zwanzig vor sieben" to "06:40",
        "Viertel vor sieben" to "06:45",
        "Zehn vor sieben" to "06:50",
        "Fünf vor sieben" to "06:55",
        "Kurz vor sieben" to "06:57"
    )
}