package com.sng.homework6.manager

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.sng.homework6.model.Contact
import java.util.concurrent.atomic.AtomicBoolean


class CvManager private constructor() {

    companion object {
        @Volatile private var INSTANCE: CvManager ? = null
        fun  getInstance(): CvManager {
            if(INSTANCE == null){
                synchronized(this) {
                    INSTANCE = CvManager()
                }
            }
            return INSTANCE!!
        }
    }

}