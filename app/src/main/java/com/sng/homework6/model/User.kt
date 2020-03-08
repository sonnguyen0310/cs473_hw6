package com.sng.homework6.model

import androidx.lifecycle.MutableLiveData

data class User(var name:String,var image:Int,var about:String){
    var achievements:MutableLiveData<MutableList<Achievement>> = MutableLiveData()
    var blogs:MutableList<Blog> = mutableListOf()
}