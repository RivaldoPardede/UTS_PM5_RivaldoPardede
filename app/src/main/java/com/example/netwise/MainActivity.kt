package com.example.netwise

import android.content.res.Configuration
import android.os.Bundle
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the theme toggle button
        val themeToggle = findViewById<ToggleButton>(R.id.themeToggle)

        // Set the initial state of the toggle button based on current theme
        themeToggle.isChecked = isDarkTheme()

        // Set up listener for toggle button
        themeToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Switch to Dark Theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Switch to Light Theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    // Helper function to check if the dark theme is currently active
    private fun isDarkTheme(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }
}
