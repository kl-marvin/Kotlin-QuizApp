package fr.kotlin.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = userName


        val score = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalAnswers = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        tv_score.text = "Ton score est ${score}/${totalAnswers}"

        btn_finish.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}
