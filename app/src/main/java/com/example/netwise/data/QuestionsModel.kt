package com.example.netwise.data

data class Question(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    var selectedOptionIndex: Int? = null, // Track the selected option
    var isAnsweredCorrectly: Boolean = false // Track if answered correctly
)

