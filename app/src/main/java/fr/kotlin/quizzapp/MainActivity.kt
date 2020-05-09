package fr.kotlin.quizzapp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Removing the status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        btn_start.setOnClickListener {

            if(et_pseudo.text.toString().isEmpty()){
                val toast = Toast.makeText(this, "Merci d'ajouter votre pseudo.", Toast.LENGTH_LONG)
                toast.show()

            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}
