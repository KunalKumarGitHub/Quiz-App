package com.learning.quizapp

object Constants {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val ques1 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,"Argentina","Australia",
            "Ghana","Switzerland",1
            )
        val ques2 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_australia,"Japan","Australia",
            "United Kingdom","Switzerland",2
        )
        val ques3 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium,"Germany","Denmark",
            "New Zealand","Belgium",4
        )
        val ques4 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil,"Uganda","Ghana",
            "Brazil","Cameroon",3
        )
        val ques5 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_fiji,"Botswana","Djibouti",
            "Fiji","Ethiopia",3
        )
        val ques6 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark,"Singapore","Denmark",
            "Ghana","Switzerland",2
        )
        val ques7 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_india,"India","Sri Lanka",
            "Bhutan","Nepal",1
        )
        val ques8 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_kuwait,"Qatar","Saudi Arabia",
            "Lebanon","Kuwait",4
        )
        val ques9 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand,"Austria","Iceland",
            "New Zealand","Sweden",3
        )
        val ques10 = Question(1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_germany,"Italy","Poland",
            "Germany","France",3
        )
        questionList.addAll(listOf(ques1,ques2,ques3,ques4,ques5,ques6,ques7,ques8,ques9,ques10))
        return questionList

    }
}