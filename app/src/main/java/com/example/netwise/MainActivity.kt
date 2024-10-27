package com.example.netwise

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    private lateinit var editUsername: EditText
    private lateinit var startBtn: Button
    private lateinit var themeToggle: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editUsername = findViewById(R.id.editUsername)
        startBtn = findViewById(R.id.startBtn)

        startBtn.setOnClickListener {
            validateAndProceed()
        }

        themeToggle = findViewById(R.id.themeToggle)

        val sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE)
        val isNightMode = sharedPreferences.getBoolean("night", false)
        themeToggle.isChecked = isNightMode

        applyThemeMode(isNightMode)

        themeToggle.setOnCheckedChangeListener { _, isChecked ->
            with(sharedPreferences.edit()) {
                putBoolean("night", isChecked)
                apply()
            }
            applyThemeMode(isChecked)
        }
    }

    private fun applyThemeMode(isNightMode: Boolean) {
        if (isNightMode) {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        } else {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        }
    }

    private fun validateAndProceed() {
        val username = editUsername.text.toString().trim()

        if (username.isEmpty()) {
            Toast.makeText(this, "Please enter your username first.", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this@MainActivity, Quiz::class.java)
            intent.putExtra("PLAYER_NAME", username)
            startActivity(intent)
        }
    }

    private fun toggleThemeMode(isChecked: Boolean) {
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        val sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putBoolean("night", isChecked)
            apply()
        }

        recreate()
    }

    private fun setThemeFromPreferences() {
        val sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE)
        val nightMode = sharedPreferences.getBoolean("night", false)

        themeToggle.isChecked = nightMode

        if (nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}
