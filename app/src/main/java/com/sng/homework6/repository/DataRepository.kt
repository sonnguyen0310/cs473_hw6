package com.sng.homework6.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sng.homework6.R
import com.sng.homework6.model.Achievement
import com.sng.homework6.model.Blog
import com.sng.homework6.model.Skill
import com.sng.homework6.model.User
import kotlinx.android.synthetic.main.contact_item_view.view.*

class DataRepository {
  var dataRepository:DataRepository?=null
  var user: MutableLiveData<User> = MutableLiveData()
    var achievements:MutableLiveData<MutableList<Achievement>> = MutableLiveData()
    var skills:MutableLiveData<MutableList<Skill>> = MutableLiveData()
    var strengths:MutableLiveData<MutableList<Skill>> = MutableLiveData()
    var weaknesses:MutableLiveData<MutableList<Skill>> = MutableLiveData()

    fun getInstance():DataRepository{
        if(dataRepository==null){
            dataRepository = DataRepository()
            return dataRepository as DataRepository
        }
        return dataRepository as DataRepository
    }

     fun createUser(){
        Log.d("myuser","creating new user")
        var muser = User("Nwogbo Bernard Chikwado",R.drawable.profile,"I am a person who is positive about every aspect of life. " +
                "There are many things I like to do, to see, and to experience. I like to read, I like to write; " +
                "I like to think, I like to dream; I like to talk, I like to listen. I like to see the sunrise in the morning, " +
                "I like to see the moonlight at night; I like to feel the music flowing on my face, I like to smell the wind coming from the ocean. " +
                "I like to look at the clouds in the sky with a blank mind, I like to do thought experiment when I cannot sleep in the middle of the night. " +
                "I like flowers in spring, rain in summer, leaves in autumn, and snow in winter. I like to sleep early, I like to get up late; " +
                "I like to be alone, I like to be surrounded by people. I like country’s peace, I like metropolis’ noise; I like the beautiful west lake in Hangzhou," +
                " I like the flat cornfield in Champaign. I like delicious food and comfortable shoes; I like good books and romantic movies. I like the land and the nature, " +
                "I like people. And, I like to laugh.")
         populateAchievements()
         addSkills()
         addStrengths()
         addWeaknesses()
        user.value = muser
    }


    private fun addStrengths(){
        val clist = mutableListOf(
            Skill("Advanced analytical skills",false,progress = 98),
            Skill("Awesome ninja coders",false,progress = 90),
            Skill("Debugging Skill",false,progress = 89),
            Skill("Skillful Polyglot",false,progress = 95),
            Skill("Versatility",false,progress = 80)
        )
        strengths.value = clist
    }

    private fun addWeaknesses(){
        val clist = mutableListOf(
            Skill("Awareness",false,progress = 10),
            Skill("Taking any risk.",false,progress = 25),
            Skill("Taking any initiative",false,progress = 15),
            Skill("Soft Skills",false,progress = 30)
        )
        weaknesses.value = clist
    }


    private fun addSkills(){
        val clist = mutableListOf(
           Skill("Java developer",false,progress = 98),
            Skill("Kotlin developer",false,progress = 90),
            Skill("Javascript developer",false,progress = 89),
            Skill("Typescript developer",false,progress = 95),
            Skill("C# developer",false,progress = 80),
            Skill("C developer",false,progress = 75)
        )
        skills.value = clist
    }

    private fun populateAchievements(){
        var mList = mutableListOf(
            Achievement("I was awarded the Eclipse Award in 2018 for Best Java Application.\n" +
                    "Supervise a team of Java Developers, motivate them to meet team goals, collaborate to improve user experiences and provide training to new employees and interns","Team Lead"),
            Achievement("Develop customized, interactive user interfaces using JavaScript, HTML and CSS. Merge my" +
                    " Java-based code and the code created by other Java " +
                    "Developers with applications written in C++ and HTML5. " +
                    "Built, integrated and modified web applications according to client specifications" +
                    "Used JavaScript to develop interactive user interfaces (UIs) that provided user experiences that exceeded client expectations" +
                    " and met key performance indicators (KPIs)","Web Applications(HTML,CSS,JAVASCRIPT"),
            Achievement("Used Enterprise JavaBeans (EJB) to create large applications for key company clients. I received several commendations from the management for my web applications","Enterprise JavaBeans (EJB)"),
            Achievement("Worked in a team of web developers, designers and other IT personnel to meet team goals and improve business outcomes","Team Achievement"),
            Achievement("I've built 150 android mobile apps and counting","Mobile App Development"),
            Achievement("Developed complete enterprise software with spring framework","Enterprise Software development"),
            Achievement("Developed complete angular application","Web Applications"),
            Achievement("I developed 3D first shooter game for up to 30 companies","Game Application development")
        )
        achievements.value = mList

    }

    fun getAchievements():LiveData<List<Achievement>>{
        return  achievements as LiveData<List<Achievement>>
    }

    fun getSkills():LiveData<List<Skill>>{
        return skills as LiveData<List<Skill>>
    }

    fun getStrengths():LiveData<List<Skill>>{
        return strengths as LiveData<List<Skill>>
    }

    fun getWeaknesses():LiveData<List<Skill>>{
        return weaknesses as LiveData<List<Skill>>
    }

}