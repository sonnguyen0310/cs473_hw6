package com.sng.homework6.model

data class User(var name:String,var image:Int,var about:String){
    var achievements:MutableList<Achievement> = mutableListOf()
    var blogs:MutableList<Blog> = mutableListOf()
}