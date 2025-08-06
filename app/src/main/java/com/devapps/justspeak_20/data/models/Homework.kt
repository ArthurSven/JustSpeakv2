package com.devapps.justspeak_20.data.models

import kotlinx.serialization.Serializable


@Serializable
data class Homework(
    val title: String,
    val assignment: String,
    val submitDate: String,
    val level: String,
    val submittedBy: String,
    val userid: String
)

@Serializable
data class HomeworkResponse(
    val homeworkid: String,
    val title: String,
    val assignment: String,
    val submitDate: String,
    val level: String,
    val submittedBy: String,
    val feedback: String,
    val grade: Int,
    val userid: String
)

