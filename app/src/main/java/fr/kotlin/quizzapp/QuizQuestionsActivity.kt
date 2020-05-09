package fr.kotlin.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class QuizQuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()
        Log.i("TEST", questionsList.toString())
    }
}
