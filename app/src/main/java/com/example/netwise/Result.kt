package com.example.netwise

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat

class Result : AppCompatActivity() {
    private lateinit var scoreTextView: TextView
    private lateinit var finalMessageTextView: TextView
    private lateinit var congratulationsTextView: TextView
    private lateinit var themeToggle: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 10)
        val playerName = intent.getStringExtra("PLAYER_NAME") ?: "Player"

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

        scoreTextView = findViewById(R.id.score)
        finalMessageTextView = findViewById(R.id.final_message)
        congratulationsTextView = findViewById(R.id.congratulations_text)

        scoreTextView.text = "$score/$totalQuestions"
        congratulationsTextView.text = "Congratulations, $playerName!"

        when (score) {
            in 1..4 -> {
                scoreTextView.setTextColor(ContextCompat.getColor(this, R.color.red))
                finalMessageTextView.text = "Well, well, well… it seems like the network just toyed with you! Were you trying to hack or just giving the firewall a light tickle? With skills like these, maybe stick to playing Minesweeper? Don’t worry; even the best hackers start somewhere... usually a bit further along, but hey, you'll get there someday!"
            }
            in 5..7 -> {
                scoreTextView.setTextColor(ContextCompat.getColor(this, R.color.yellow))
                finalMessageTextView.text = "Not too shabby! You managed to rattle a few circuits, but the network still kept most of its secrets safe. You’re like a junior spy in training – all the potential, but still tripping on the lasers! Keep at it, and soon you’ll be hacking with the best (or at least not setting off every alarm in sight)!"
            }
            in 8..10 -> {
                scoreTextView.setTextColor(ContextCompat.getColor(this, R.color.green))
                finalMessageTextView.text = "Bow before the master! You’ve sliced through the network like a hot knife through butter, leaving the firewalls cowering in awe. Legends will be written, songs sung of this day: the day you showed the system who’s boss. Take a bow, oh mighty conqueror of the code – the network is yours!"
            }
        }
    }

    private fun applyThemeMode(isNightMode: Boolean) {
        if (isNightMode) {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        } else {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        }
    }

    private fun setupThemeToggle(themeToggle: ToggleButton) {
        // Get SharedPreferences to store the theme setting
        val sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Set the initial state of the toggle button based on SharedPreferences
        themeToggle.isChecked = sharedPreferences.getBoolean("night", false)

        themeToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("night", true).apply() // Save preference
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("night", false).apply() // Save preference
            }
            recreate() // Recreate activity for the theme change
        }
    }

    private fun setThemeFromPreferences(themeToggle: ToggleButton) {
        // Check the saved preference and set the theme accordingly
        val sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE)
        val nightMode = sharedPreferences.getBoolean("night", false)

        if (nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            themeToggle.isChecked = true
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            themeToggle.isChecked = false
        }
    }
}