package com.sng.homework6.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sng.homework6.model.Achievement
import com.sng.homework6.model.Skill
import com.sng.homework6.model.User
import com.sng.homework6.repository.DataRepository

class HomeViewModel : ViewModel() {
   private var user:MutableLiveData<User> = MutableLiveData()
    private var dataRepository: DataRepository = DataRepository().getInstance()

    init {
        dataRepository.createUser()
        user = dataRepository.user
        displayAchievements(dataRepository.achievements.value)
    }

    val mUser:LiveData<User> = user

    fun displayAchievements(list:List<Achievement>?){
        Log.d("puser","$list")
        list?.forEach{
            Log.d("puser","$it")
        }?:Log.d("puser","achievemnt is null")
    }

    fun getAchievements():LiveData<List<Achievement>>{
        return  dataRepository.getAchievements()
    }

   fun getSkills():LiveData<List<Skill>>{
       return dataRepository.getSkills()
   }




}