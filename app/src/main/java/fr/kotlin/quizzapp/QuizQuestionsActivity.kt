package fr.kotlin.quizzapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import org.w3c.dom.Text


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var userName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionList = Constants.getQuestions() // return an arrayList of Questions used later on

        // on récupère l'user name de l'activité Main
        userName = intent.getStringExtra(Constants.USER_NAME)

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    private fun setQuestion(){

        val question  = mQuestionList!![mCurrentPosition - 1] //-1 cause arrays starts at 0

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "Terminer"
        }else{
            btn_submit.text = "Envoyer"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_flag.setImageResource(question.image)
        tv_option_one.text = question.option1
        tv_option_two.text = question.option2
        tv_option_three.text = question.option3
        tv_option_four.text = question.option4
    }


    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)


        for (option in options){
            option.setTextColor(Color.parseColor("#30383B"))
            option.typeface = Typeface.DEFAULT // not bold
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectionOptionNumber : Int){
        defaultOptionView() // reset default option view

        mSelectedOptionPosition = selectionOptionNumber
        tv.setTextColor(Color.parseColor("#6200EE"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)

    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        // tant qu'il reste des questions on actualise l'écran
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion() // avec une nouvelle quesion
                        } else -> { // quand il n'y a plus de question on démarre ResultActivity
                         var intent = Intent(this, ResultActivity::class.java)
                         intent.putExtra(Constants.USER_NAME, userName)
                         intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                         intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                         startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.CorrectAnswer != mSelectedOptionPosition){ // if we select the incorect option
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border) // bg get red
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.CorrectAnswer, R.drawable.correct_option_border)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "Terminer"
                    }else {
                        btn_submit.text = "Question suivante"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

}
