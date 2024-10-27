package com.example.netwise

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.netwise.data.QuestionsRepository

class Quiz : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var questionNumTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var option4Button: Button
    private lateinit var nextButton: Button
    private lateinit var previousButton: Button
    private lateinit var exitButton: TextView
    private lateinit var themeToggle: ToggleButton

    private var currentQuestionIndex = 0
    private val questionList = QuestionsRepository.questionList
    private var score = 0
    private lateinit var playerName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        playerName = intent.getStringExtra("PLAYER_NAME") ?: "Player"

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

        questionTextView = findViewById(R.id.question_text)
        questionNumTextView = findViewById(R.id.question_num)
        option1Button = findViewById(R.id.option_1)
        option2Button = findViewById(R.id.option_2)
        option3Button = findViewById(R.id.option_3)
        option4Button = findViewById(R.id.option_4)
        nextButton = findViewById(R.id.next_btn)
        previousButton = findViewById(R.id.previous_btn)
        exitButton = findViewById(R.id.exit_btn)

        displayQuestion(currentQuestionIndex)

        nextButton.setOnClickListener { goToNextQuestion() }
        previousButton.setOnClickListener { goToPreviousQuestion() }
        option1Button.setOnClickListener { handleOptionSelected(0) }
        option2Button.setOnClickListener { handleOptionSelected(1) }
        option3Button.setOnClickListener { handleOptionSelected(2) }
        option4Button.setOnClickListener { handleOptionSelected(3) }

        exitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun applyThemeMode(isNightMode: Boolean) {
        if (isNightMode) {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        } else {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        }
    }

    private fun displayQuestion(index: Int) {
        val question = questionList[index]
        questionNumTextView.text = "Question ${index + 1}/${questionList.size}"
        questionTextView.text = question.text
        option1Button.text = question.options[0]
        option2Button.text = question.options[1]
        option3Button.text = question.options[2]
        option4Button.text = question.options[3]

        nextButton.text = if (index == questionList.size - 1) "Submit" else "Next"

        highlightSelectedOption(question.selectedOptionIndex)
    }

    private fun highlightSelectedOption(selectedIndex: Int?) {
        val backgroundColor = ContextCompat.getColor(this, R.color.radioBtn_bg_selected)
        resetOptionButtons()

        selectedIndex?.let {
            val selectedButton = when (it) {
                0 -> option1Button
                1 -> option2Button
                2 -> option3Button
                3 -> option4Button
                else -> null
            }
            selectedButton?.setBackgroundColor(backgroundColor)
        }
    }

    private fun resetOptionButtons() {
        val backgroundColor = ContextCompat.getColor(this, R.color.radioBtn_bg)

        option1Button.setBackgroundColor(backgroundColor)
        option2Button.setBackgroundColor(backgroundColor)
        option3Button.setBackgroundColor(backgroundColor)
        option4Button.setBackgroundColor(backgroundColor)
    }

    private fun goToNextQuestion() {
        if (currentQuestionIndex < questionList.size - 1) {
            currentQuestionIndex++
            displayQuestion(currentQuestionIndex)
        } else {
            Toast.makeText(this, "Quiz Completed!", Toast.LENGTH_SHORT).show()
             val intent = Intent(this, Result::class.java)
             intent.putExtra("SCORE", score)
             intent.putExtra("TOTAL_QUESTIONS", questionList.size)
             intent.putExtra("PLAYER_NAME", playerName)
             startActivity(intent)
        }
    }

    private fun goToPreviousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--
            displayQuestion(currentQuestionIndex)
        }
    }

    private fun handleOptionSelected(optionIndex: Int) {
        val selectedQuestion = questionList[currentQuestionIndex]
        selectedQuestion.selectedOptionIndex = optionIndex

        val correctAnswerIndex = selectedQuestion.correctAnswerIndex
        if (optionIndex == correctAnswerIndex && !selectedQuestion.isAnsweredCorrectly) {
            score++
            selectedQuestion.isAnsweredCorrectly = true
        }

        highlightSelectedOption(optionIndex)
    }
}
