package com.sng.homework6.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sng.homework6.R
import com.sng.homework6.model.Achievement
import com.sng.homework6.model.Skill
import com.sng.homework6.ui.home.Adapters.MyAdapter
import com.sng.homework6.ui.home.Adapters.MyGridAdapter
import kotlinx.android.synthetic.main.custom_recycler_view.view.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),OnFragmentClickListener {
    lateinit var myAdapter: MyAdapter
    lateinit var myGridaAdapter: MyGridAdapter

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val homeRecyclerview = root.findViewById<RecyclerView>(R.id.home_recyclerview)
        val gridView = root.findViewById<GridView>(R.id.gridViewId)
        homeViewModel.mUser.observe(viewLifecycleOwner, Observer {
            aboutId.text = it.about
            profileId.setImageResource(it.image)
            nameId.text = it.name
            myAdapter.notifyDataSetChanged()
        })

        homeRecyclerview.isNestedScrollingEnabled=false
        homeRecyclerview.setHasFixedSize(true)
        myGridaAdapter =  MyGridAdapter(homeViewModel.getSkills().value!!)
        gridView.adapter = myGridaAdapter
        myAdapter = MyAdapter(homeViewModel.getAchievements().value!!,this)
        homeRecyclerview.adapter = myAdapter
        homeRecyclerview.layoutManager = LinearLayoutManager(activity)

        return root
    }

    override fun onFragmentClick(achievement: Achievement) {}
}






