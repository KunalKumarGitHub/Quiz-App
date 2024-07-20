package com.learning.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val mUserName=intent.getStringExtra(Constants.USER_NAME)
        val mCorrectAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val mTotalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        binding.tvName.text=mUserName
        binding.tvScore.text="Your Score is $mCorrectAnswers out of $mTotalQuestions"
        binding.btnFinish.setOnClickListener{
            val intent= Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}