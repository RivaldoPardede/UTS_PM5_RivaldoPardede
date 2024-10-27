package com.example.netwise

import BaseActivity
import android.os.Bundle
import android.widget.ToggleButton

class Quiz : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Get the theme toggle button
        val themeToggle = findViewById<ToggleButton>(R.id.themeToggle)

        // Call the setupThemeToggle with the toggle button reference
        setupThemeToggle(themeToggle)
    }
}