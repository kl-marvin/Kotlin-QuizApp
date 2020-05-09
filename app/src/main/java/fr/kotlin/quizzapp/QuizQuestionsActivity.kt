package fr.kotlin.quizzapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import org.w3c.dom.Text


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)


    }

    private fun setQuestion(){
        mCurrentPosition = 1
        val question  = mQuestionList!![mCurrentPosition - 1] //-1 cause arrays starts at 0

        defaultOptionView()

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
        }

    }

}
