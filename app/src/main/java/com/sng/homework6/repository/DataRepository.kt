package com.sng.homework6.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sng.homework6.R
import com.sng.homework6.model.Achievement
import com.sng.homework6.model.Blog
import com.sng.homework6.model.User
import kotlinx.android.synthetic.main.contact_item_view.view.*

class DataRepository {
  var dataRepository:DataRepository?=null
  var user: MutableLiveData<User> = MutableLiveData()

    fun getInstance():DataRepository{
        if(dataRepository==null){
            Log.d("CALLED","I'm called")
            dataRepository = DataRepository()
            return dataRepository as DataRepository
        }
        return dataRepository as DataRepository
    }

     fun createUser(){
        Log.d("myuser","creating new user")
        var muser = User("Nwogbo Bernard Chikwado",R.drawable.profile,"I am a person who is positive about every aspect of life. There are many things I like to do, to see, and to experience. I like to read, I like to write; I like to think, I like to dream; I like to talk, I like to listen. I like to see the sunrise in the morning, I like to see the moonlight at night; I like to feel the music flowing on my face, I like to smell the wind coming from the ocean. I like to look at the clouds in the sky with a blank mind, I like to do thought experiment when I cannot sleep in the middle of the night. I like flowers in spring, rain in summer, leaves in autumn, and snow in winter. I like to sleep early, I like to get up late; I like to be alone, I like to be surrounded by people. I like country’s peace, I like metropolis’ noise; I like the beautiful west lake in Hangzhou, I like the flat cornfield in Champaign. I like delicious food and comfortable shoes; I like good books and romantic movies. I like the land and the nature, I like people. And, I like to laugh.")
        addUserAchievement(muser)
        addUserBlogs(muser )
        getUserAchievements(muser)
        user.value = muser
    }

    private fun getUserAchievements(user: User){
        user.achievements.forEach {
            Log.d("myuser","$it")
        }
    }

    private fun addUserBlogs(user: User){
        val blogs :List<Blog> = mutableListOf(
            Blog("About me","I'm a developer"),
            Blog("My Vacation","I love Milan"),
            Blog("My Life in Maharishi","We all love Anapuna")
        )
        user.blogs.addAll(blogs)
    }

//    private fun addUsersSkill(user: User){
//        val skills = mutableListOf(
//            Skill("I play basket ball"),
//            Skill("Proficient in Java"),
//            Skill("Proficient in Kotlin"),
//            Skill("Profificent in Dart"),
//            Skill("Fullstack web and mobile developer")
//
//        )
//
//        user.skills.addAll(skills)
//    }

    private fun addUserAchievement(user: User){
        val achievements = mutableListOf(
            Achievement("I've built 150 android mobile apps and counting","Mobile App Development"),
            Achievement("Developed complete enterprise software with spring framework","Enterprise Software development"),
            Achievement("Developed complete angular application","Web Applications"),
            Achievement("I developed 3D first shooter game for up to 30 companies","Game Application development")
        )
        user.achievements.addAll(achievements)
    }

}