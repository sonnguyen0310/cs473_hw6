package com.sng.homework6.ui.work

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.sng.homework6.R
import com.sng.homework6.model.Work
import kotlinx.android.synthetic.main.fragment_work.*


class WorkFragment : Fragment() {
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    private lateinit var workViewModel: WorkViewModel

    var workList = ArrayList<Work>()
    var layoutManager: RecyclerView.LayoutManager? = null
    var madr: WorkRecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fmanager = getActivity()?.getSupportFragmentManager()!!




        workViewModel =
            ViewModelProviders.of(this).get(WorkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_work, container, false)
        return root
    }

    override fun onResume() {
        super.onResume()
        val spf = context?.getSharedPreferences("workFile", Context.MODE_PRIVATE)
        // if list exists, convert shared preferences list to kotlin list
        try {
            val workListString = spf?.getString("workList", "something went wrong!")
            var works = Gson().fromJson(workListString, Array<Work>::class.java).toMutableList()
            for (work in works) {
                workList.add(work)
                madr?.notifyDataSetChanged()
            }
        } catch (exception: Exception) {
            Toast.makeText(
                context, "No work is added yet",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //configure recycler view
        madr = WorkRecyclerViewAdapter(context, workList)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = madr

        fab.setOnClickListener { view ->
            val intent = Intent(context, AddWorkActivity::class.java)
            startActivity(intent)
        }

    }

}

/* Dummy data ready for constructing the initial work list

        workList.add(
            Work(
                "Biozard Gaming Service", "Software Development Intern",
                "AngularJS, CSS, JSON", "Action game development with over hundred thousand of players." +
                        " I was responsible for environment interactions and basic test cases.",
                Date("1/15/2012"), Date("7/15/2012"),
                "I started to contribute the ongoing main project of the company from the second week of my job"
            )
        )
        workList.add(
            Work(
                "TLK Financial Investments",
                "Software Developer"
                ,
                "PHP, Laravel, AngularJS, CSS, JSON",
                "Development of many accounting and financial projects. I mainly worked on interest rates." +
                        "Integrated different regulations from different states.",
                Date("8/15/2012"),
                Date("8/15/2017"),
                "Worked on 15 different state's income tax policies."
            )
        )
        workList.add(
            Work(
                "Arnold Tax Service ", "Project Manager",
                "Java, PHP, Spring-boot, AngularJS, CSS, JSON, C#, .NET, JSP", "Developed tax applications for government." +
                        "Addition to lead my tax team, I also expertised on income tax.",
                Date("10/15/2017"), Date("2/25/2020"),
                "Mentored about two hundred junior developers. Many of them were fresh college graduate."
            )
        )

 */
