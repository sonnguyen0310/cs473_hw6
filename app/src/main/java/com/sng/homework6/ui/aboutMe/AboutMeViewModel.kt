package com.sng.homework6.ui.aboutMe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sng.homework6.model.Achievement
import com.sng.homework6.model.Skill
import com.sng.homework6.model.User
import com.sng.homework6.repository.DataRepository

class AboutMeViewModel : ViewModel() {
    private var user:MutableLiveData<User> = MutableLiveData()
    private var dataRepository: DataRepository = DataRepository().getInstance()

    init {
        dataRepository.createUser()
        user = dataRepository.user

    }

    val mUser:LiveData<User> = user

    fun getAchievements():LiveData<List<Achievement>>{
        return  dataRepository.getAchievements()
    }

    fun getSkills():LiveData<List<Skill>>{
        return dataRepository.getSkills()
    }

    fun getStrengths():LiveData<List<Skill>>{
        return dataRepository.getStrengths()
    }

    fun getWeaknesses():LiveData<List<Skill>>{
        return dataRepository.getWeaknesses()
    }


}