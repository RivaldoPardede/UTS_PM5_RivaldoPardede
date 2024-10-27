package com.example.netwise

import BaseActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : BaseActivity() {

    private lateinit var editUsername: EditText
    private lateinit var startBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editUsername = findViewById(R.id.editUsername)
        startBtn = findViewById(R.id.startBtn)

        startBtn.setOnClickListener {
            validateAndProceed()
        }

        // Theme Toggle Logic
        val themeToggle = findViewById<ToggleButton>(R.id.themeToggle)
        setupThemeToggle(themeToggle)
    }

    private fun validateAndProceed() {
        val username = editUsername.text.toString().trim()

        if (username.isEmpty()) {
            Toast.makeText(this, "Please enter your username first.", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, Quiz::class.java)
            intent.putExtra("PLAYER_NAME", username)
            startActivity(intent)
        }
    }
}
