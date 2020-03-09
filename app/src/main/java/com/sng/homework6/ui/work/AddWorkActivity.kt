package com.sng.homework6.ui.work

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.gson.Gson
import com.sng.homework6.R
import com.sng.homework6.model.Work
import kotlinx.android.synthetic.main.activity_add_work.*
import java.util.*

class AddWorkActivity : AppCompatActivity() {
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)

        submitButton.setOnClickListener {
            //Construct new work
            var startDate: Date
            var endDate: Date
            try {
                startDate = Date((sss.text).toString())
                endDate = Date((eee.text).toString())
            } catch (exception: Exception) {
                startDate = Date("1/1/2000")
                endDate = Date("1/1/2001")
            }
            var newWork = Work(
                etCompany.text.toString(), etTitle.text.toString(),
                etTechnologies.text.toString(), etProjects.text.toString(),
                startDate, endDate,
                etDetails.text.toString()
            )

            //read work list
            val spf = getSharedPreferences("workFile", Context.MODE_PRIVATE)
            val spe = spf?.edit()
            try {
                val workListString = spf?.getString("workList", "something went wrong!")
                var works = Gson().fromJson(workListString, Array<Work>::class.java).toMutableList()
                //add new work to the worklist
                works.add(newWork)
                //write updated workList
                val workListJson = Gson().toJson(works)
                spe?.putString("workList", workListJson)
            } catch (exception: Exception) {
                var works = mutableListOf<Work>()
                works.add(newWork)
                val workListJson = Gson().toJson(works)
                spe?.putString("workList", workListJson)
            }
            spe?.apply()

            finish()
            fmanager = getSupportFragmentManager()
            tx = fmanager.beginTransaction()
            tx.replace(
                R.id.frameLayout, WorkFragment()
            )
            tx.commit()
        }
    }
}
