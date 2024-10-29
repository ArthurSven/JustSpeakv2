package com.devapps.justspeak_20.utils

fun getChichewaGreetings(): Map<String, String> {
    return mapOf(
        "Bho!" to "Hey!",
        "Wadzuka bwanji?" to "How are you? (morning)",
        "Mwadzuka bwanji?" to "How are you? (morning) - formal",
        "Ndadzuka bwino" to "I am doing fine (morning)",
        "Tadzuka bwino" to "We are doing fine (morning)",
        "Uli bwanji" to "How are you? (midday)",
        "Muli bwanji" to "How are you? (midday) - formal",
        "Ndilibwino" to "I am doing fine (midday)",
        "Tilibwino" to "We are doing fine (midday)",
        "Waswera bwanji?" to "How are you? (evening)",
        "Mwaswera bwanji?" to "How are you? (evening) - formal",
        "Ndaswera bwino" to "I am doing good (evening)",
        "Taswera bwino" to "We are doing good (evening)",
        "Chonchobe" to "So and so",
        "Sindilibwino" to "I am not fine",
        "kaya inu?" to "And you? (formal)",
        "Kaya iwe?" to "And you? (informal)",
        "Ugone bwino" to "Goodnight",
        "Mugone bwino" to "Goodnight - formal"
    )
}

fun getChichewaGoodbyes(): Map<String, String> {
    return mapOf(
        "Ndikupita" to "I am going/I am leaving",
        "Ine nde ndikuthaweni" to "I should take leave",
        "Tiwonaneso sabata la mawa" to "See you next week",
        "Tiwonana" to "See you later",
        "Tiwonana mawa" to "See you tomorrow",
        "Ine ndisanzike" to "I should bid farewell"
    )
}

fun getChichewaExpressionList(): Map<String, String> {
    return mapOf(
        "Pepani" to "Sorry/Excuse me",
        "Tifunse nawo" to "May I ask?",
        "Ndimafuna thandizo" to "I need some help",
        "Ndithandizeni" to "Help me",
        "Eya" to "Yes",
        "Ayi" to "No",
        "Mwina" to "Maybe",
        "Zikomo" to "Thank you",
        "Ndathokoza" to "Thank you",
        "Mumanena bwanji ... mchizungu?" to "How do you say... in Chichewa?",
        "Ichi ndi chan?" to "What is this?",
        "Icho ndi chan?" to "What is that?",
        "Lankhulani pang'ono pang'ono, chonde" to "Speak slowly, please",
        "Khalani chete, chonde" to "Keep quiet",
        "Chonde" to "Please",
        "Ndimamva chichewa pangóno" to "I understand little Chichewa",
        "Ndamva" to "I understand",
        "Sindinamvesese" to "I do not understand",
        "Zonse zilibwino" to "Everything's fine",
        "Bwela kuno" to "Come here",
        "Choka" to "Get out!"
    )
}

fun getChichewaShoppingList(): Map<String, String> {
    return mapOf(
        "Kugula" to "To buy",
        "Ndukagula ..." to "I am going to buy...",
        "Ndupita kokashopa" to "I am going shopping",
        "Ntengo" to "Price",
        "Ichi ndibwa?" to "How much is this?",
        "kugulisa" to "To sell",
        "Mukugulisa chan?" to "What are you selling?",
        "Zovala" to "Clothes",
        "Shopu" to "Shop",
        "Muli ndi ...?" to "Do you have...?",
        "Mumagulisa...?" to "Do you sell...?",
        "Ndimafuna..." to "I am looking for...",
        "Chikudhula" to "It's expensive",
        "Chikutchipa" to "It's cheap",
        "Ndipaseni lisiti" to "Give me a receipt",
        "Kodi ndingapeze ... pati?" to "Where can I find...?",
        "Chandisangalasa" to "I like that",
        "Sichinandisangalase" to "I do not like that",
        "Yesani" to "Try it on"
    )
}

fun getChichewaDiningPhrases(): Map<String, String> {
    return mapOf(
        "Kudya" to "To eat",
        "Ndimafuna tebulo la anthu awiri" to "A table for two",
        "Tikhoza kukhala apa?" to "Can we sit here?",
        "Ndiwone nawo menu" to "May I see the menu?",
        "Muli ndi chan?" to "What do you have?",
        "Mudya chan?" to "What will you eat?",
        "Mumwa chan?" to "What will you drink?",
        "Ine ndufuna ..." to "I want ...",
        "Ndidya..." to "I will eat...",
        "Ndimwa..." to "I will drink ...",
        "Apapa chabwino ndi chiti?" to "What can you recommend here?",
        "Iyayi sindinayitanise izi" to "No, I didn't order this",
        "Zilibwino?" to "Is everything good?",
        "Onjezelani" to "Add more",
        "Chiliponso china ngati?" to "Anything else?",
        "Ndufuna ndilipile" to "I would like to pay",
        "Ndilipila ndi card" to "I will pay with a card",
        "Ndilipila ndi cash" to "I will pay with cash",
        "Mundibwelesele billu" to "Bring me the bill"
    )
}

fun getChichewaGeneralEmergencies(): Map<String, String> {
    return mapOf(
        "Ndithandizeni!" to "Help me!",
        "Bwino!" to "Careful!",
        "Samalani!" to "Take care!",
        "Changu!" to "Hurry up!",
        "Fulumilani!" to "Hurry up!",
        "Mungandithandizeko?" to "May you please help me?",
        "Ungandithandizeko?" to "Can you please help me? (informal)",
        "Ndikuthandizeni bwanji?" to "How may I help you?",
        "Chachitika ndi chan?" to "What happened?",
        "Kwachitika ngozi" to "An accident happened",
        "Kwachitika zadzidzidzi" to "An emergency happened"
    )
}

fun getChichewaMedicalEmergency(): Map<String, String> {
    return mapOf(
        "Ndadwala" to "I am sick",
        "Kandisiyeni ku chipatala" to "Take me to the hospital",
        "Ndapwetekeka" to "I am injured",
        "Imbilani amblansi" to "Call an ambulance",
        "Moto!" to "Fire!",
        "Ndili ndi chinfine" to "I have a cold",
        "Wakomoka" to "She/He has fainted",
        "Wamwalira" to "He/She has died",
        "Ndufuna dotolo/dokotala" to "I need a doctor",
        "Ndaziwotcha" to "I have burned myself",
        "Ndazicheka" to "I have cut myself",
        "Muli bwino bwino?" to "Are you alright?"
    )
}

fun getChichewaCrimeEmergency(): Map<String, String> {
    return mapOf(
        "Ndabeledwa" to "I have been robbed",
        "Chikwama changa chabedwa" to "My bag has been stolen",
        "Imbilani apolisi" to "Call the police",
        "Mugwireni wakubayo!" to "Catch that thief",
        "Nyumba yanga yabeledwa" to "My house has been broken into",
        "Ndufuna ndizapange lipoti m'landu" to "I would like to report a crime"
    )
}

fun getChichewaQuestionPhrases(): Map<String, String> {
    return mapOf(
        "Mwapanga chani?" to "What have you done?",
        "Mwawonako munthu atadusa apa?" to "Have you seen anyone pass by here?",
        "Wabwera nthawi yanji?" to "What time did you arrive?",
        "Umaphika Nsima?" to "Do you cook Nsima?",
        "Kodi munayamba ntchito liti?" to "So when did you start working?",
        "Munyamuka liti?" to "When are you starting off?",
        "Zatheka bwanji?" to "How did that happen?",
        "Chifukwa chani mwapanga zimenezo?" to "Why did you do that?",
        "Si choncho?" to "Isn't that so?",
        "Ukupita kuti?" to "Where are you going to?"
    )
}

fun getChichewaDays(): Map<String, String> {
    return mapOf(
        "Tsiku" to "Day",
        "Lolemba" to "Monday",
        "Lachiwiri" to "Tuesday",
        "Lachitatu" to "Wednesday",
        "Lachinayi" to "Thursday",
        "Lachisanu" to "Friday",
        "Loweluka" to "Saturday",
        "Lamulungu" to "Sunday"
    )
}
















fun getChichewaIntroductionPhrases(): Map<String, String> {
    return mapOf(
        "Awa ndi a ..." to "This is ...(formal/plural)",
        "Uyu ndi ..." to "This is ...",
        "Ine, dzina langa ndi..." to "My name is...",
        "Dzina lanu ndi ndani?" to "What is your name? (formal)",
        "Dzina lako ndi ndani?" to "What is your name? (informal)",
        "M'machokela kuti?" to "Where do you come from? (formal)",
        "Umachokela kuti?" to "Where do you come from? (informal)",
        "Mumakhala kuti?" to "Where do you stay? (formal)",
        "Umakhala kuti?" to "Where do you stay? (informal)"
    )
}
