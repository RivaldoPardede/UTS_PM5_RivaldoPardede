package com.example.netwise

import BaseActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton

class Result : BaseActivity() {
    private lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 10)

        scoreTextView = findViewById(R.id.score)
        scoreTextView.text = "$score/$totalQuestions"

        // Get the theme toggle button
        val themeToggle = findViewById<ToggleButton>(R.id.themeToggle)
        setupThemeToggle(themeToggle)
    }
}