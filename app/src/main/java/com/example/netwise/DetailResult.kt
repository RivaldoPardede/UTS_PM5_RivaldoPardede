package com.example.netwise

import BaseActivity
import android.os.Bundle
import android.widget.ToggleButton

class DetailResult : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_result)

        // Get the theme toggle button
        val themeToggle = findViewById<ToggleButton>(R.id.themeToggle)

        // Call the setupThemeToggle with the toggle button reference
        setupThemeToggle(themeToggle)
    }
}