package com.learning.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.learning.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionBinding
    @SuppressLint("SetTextI18n")
    private var mUserName:String?=null
    private var mCurrentPosition:Int=1
    private var madeChoice:Boolean=false
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOption:Int=-1
    private var mCorrectAnswers:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mUserName=intent.getStringExtra(Constants.USER_NAME)

        mQuestionList=Constants.getQuestions()
        setQuestion()
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }
    private fun setQuestion(){
        madeChoice=false
        val question=mQuestionList!![mCurrentPosition-1]
        binding.btnSubmit.text="SUBMIT"
        defaultOptionsView()

        binding.progressBar.progress=mCurrentPosition

        binding.tvProgress.text="$mCurrentPosition"+"/"+binding.progressBar.max

        binding.tvQuestion.text=question!!.question

       binding.ivImage.setImageResource(question.image)

       binding.tvOptionOne.text=question.option1
       binding.tvOptionTwo.text=question.option2
       binding.tvOptionThree.text=question.option3
       binding.tvOptionFour.text=question.option4
    }
    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one->{
                selectedOptionView(binding.tvOptionOne,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(binding.tvOptionTwo,2)
            }
            R.id.tv_option_three->{
                selectedOptionView(binding.tvOptionThree,3)
            }
            R.id.tv_option_four->{
                selectedOptionView(binding.tvOptionFour,4)
            }
            R.id.btn_submit->{
                if(mSelectedOption==0) {
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            mSelectedOption=-1
                            setQuestion()
                        }else->{
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else if(mSelectedOption==1||mSelectedOption==2||mSelectedOption==3||mSelectedOption==4){
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOption){
                        answerView(mSelectedOption,R.drawable.incorrect_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question!!.correctAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionList?.size){
                        binding.btnSubmit.text="FINISH"
                    }else{
                        madeChoice=true
                        binding.btnSubmit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOption=0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                binding.tvOptionOne.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2->{
                binding.tvOptionTwo.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3->{
                binding.tvOptionThree.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4->{
                binding.tvOptionFour.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }
    private fun selectedOptionView(textView: TextView,selectedOptionNum:Int){
        if(!madeChoice) {
            defaultOptionsView()
            mSelectedOption = selectedOptionNum
            textView.setTextColor(Color.parseColor("#363A43"))
            textView.setTypeface(textView.typeface, Typeface.BOLD)
            textView.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_border_bg
            )
        }
    }
}