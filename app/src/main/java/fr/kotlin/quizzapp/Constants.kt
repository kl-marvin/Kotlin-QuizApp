package fr.kotlin.quizzapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val QUESTION = "A quel pays appartient ce drapeau ?"

        // Question 1
        val ques1 = Question(
            1,
            QUESTION,
             R.drawable.ic_flag_of_argentina,
            "Argentine",
            "Australie",
            "Armenie", "Albanie",
            1
        )
        questionsList.add(ques1)


        // Question 2
        val que2 = Question(
            2, QUESTION,
            R.drawable.ic_flag_of_australia,
            "Angola", "Algérie",
            "Australie", "Armenie", 3
        )

        questionsList.add(que2)

        // Question 3
        val que3 = Question(
            3, QUESTION,
            R.drawable.ic_flag_of_brazil,
            "Biélorussie", "Belgique",
            "Brunei", "Brésil", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, QUESTION,
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgique",
            "Bolivie", "Bénin", 2
        )

        questionsList.add(que4)

        // Question 5
        val que5 = Question(
            5,  QUESTION,
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionsList.add(que5)

        // Question 6
        val que6 = Question(
            6, QUESTION,
            R.drawable.ic_flag_of_germany,
            "Allemagne", "Georgie",
            "Grèce", "Aucun", 1
        )

        questionsList.add(que6)

        // Question 7
        val que7 = Question(
            7, QUESTION,
            R.drawable.ic_flag_of_denmark,
            "Dominique", "Egypte",
            "Danemark", "Ethiopie", 3
        )

        questionsList.add(que7)

        // Question 8
        val que8 = Question(
            8, QUESTION,
            R.drawable.ic_flag_of_india,
            "Irelande", "Iran",
            "Italie", "Inde", 4
        )

        questionsList.add(que8)

        // Question 9
        val que9 = Question(
            9, QUESTION,
            R.drawable.ic_flag_of_new_zealand,
            "Australe", "Nouvelle-Zélande",
            "Canada", "Etats-Unis", 2
        )

        questionsList.add(que9)

        // Question 10
        val que10 = Question(
            10, QUESTION,
            R.drawable.ic_flag_of_kuwait,
            "Koweit", "Jordanie",
            "Sudan", "Palestine", 1
        )

        questionsList.add(que10)


        return questionsList
    }

}