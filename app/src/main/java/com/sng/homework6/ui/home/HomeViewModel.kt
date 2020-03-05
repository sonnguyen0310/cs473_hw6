package com.sng.homework6.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sng.homework6.model.Achievement
import com.sng.homework6.model.User
import com.sng.homework6.repository.DataRepository

class HomeViewModel : ViewModel() {
   private var user:MutableLiveData<User> = MutableLiveData()
    private var dataRepository: DataRepository = DataRepository().getInstance()

    init {
        dataRepository.createUser()
        user = dataRepository.user
    }

    val mUser:LiveData<User> = user
}