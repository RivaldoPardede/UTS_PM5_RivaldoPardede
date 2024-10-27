package com.example.netwise

import BaseActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import com.example.netwise.data.QuestionsRepository

class Quiz : BaseActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var questionNumTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var option4Button: Button
    private lateinit var nextButton: Button
    private lateinit var previousButton: Button

    private var currentQuestionIndex = 0
    private val questionList = QuestionsRepository.questionList
    private var score = 0
    private lateinit var playerName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        playerName = intent.getStringExtra("PLAYER_NAME") ?: "Player"

        val themeToggle = findViewById<ToggleButton>(R.id.themeToggle)
        setupThemeToggle(themeToggle)

        questionTextView = findViewById(R.id.question_text)
        questionNumTextView = findViewById(R.id.question_num)
        option1Button = findViewById(R.id.option_1)
        option2Button = findViewById(R.id.option_2)
        option3Button = findViewById(R.id.option_3)
        option4Button = findViewById(R.id.option_4)
        nextButton = findViewById(R.id.next_btn)
        previousButton = findViewById(R.id.previous_btn)

        displayQuestion(currentQuestionIndex)

        nextButton.setOnClickListener { goToNextQuestion() }
        previousButton.setOnClickListener { goToPreviousQuestion() }
        option1Button.setOnClickListener { handleOptionSelected(0) }
        option2Button.setOnClickListener { handleOptionSelected(1) }
        option3Button.setOnClickListener { handleOptionSelected(2) }
        option4Button.setOnClickListener { handleOptionSelected(3) }
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
        resetOptionButtons()

        selectedIndex?.let {
            val selectedButton = when (it) {
                0 -> option1Button
                1 -> option2Button
                2 -> option3Button
                3 -> option4Button
                else -> null
            }
            selectedButton?.setBackgroundColor(0xFFEBEBEB.toInt())
        }
    }

    private fun resetOptionButtons() {
        option1Button.setBackgroundColor(0xFFFFFFFF.toInt())
        option2Button.setBackgroundColor(0xFFFFFFFF.toInt())
        option3Button.setBackgroundColor(0xFFFFFFFF.toInt())
        option4Button.setBackgroundColor(0xFFFFFFFF.toInt())
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
            // finish()
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
            selectedQuestion.isAnsweredCorrectly = true // Mark as answered correctly
        }

        highlightSelectedOption(optionIndex)
    }
}
