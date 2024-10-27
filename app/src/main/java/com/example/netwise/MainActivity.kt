package com.example.netwise

import BaseActivity
import android.content.res.Configuration
import android.os.Bundle
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_page)

        // Get the theme toggle button
        val themeToggle = findViewById<ToggleButton>(R.id.themeToggle)

        // Call the setupThemeToggle with the toggle button reference
        setupThemeToggle(themeToggle)
    }
}
