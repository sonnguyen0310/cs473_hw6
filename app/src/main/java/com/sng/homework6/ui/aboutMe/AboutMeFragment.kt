package com.sng.homework6.ui.aboutMe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sng.homework6.R
import com.sng.homework6.model.Achievement
import com.sng.homework6.ui.home.Adapters.MyAdapter
import com.sng.homework6.ui.home.Adapters.MyGridAdapter
import com.sng.homework6.ui.home.OnFragmentClickListener

class AboutMeFragment : Fragment(),OnFragmentClickListener {

    private lateinit var aboutMeViewModel: AboutMeViewModel
    lateinit var myAdapter: MyAdapter
    lateinit var myGridaAdapter: MyGridAdapter
    lateinit var myGridaAdapterWeakness: MyGridAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        aboutMeViewModel =
                ViewModelProviders.of(this).get(AboutMeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about_me, container, false)

    val aboutRecylerView = root.findViewById<RecyclerView>(R.id.about_recycleview)
        val title: TextView = root.findViewById(R.id.titleId)
        var image = root.findViewById<ImageView>(R.id.imageView2)
        var badId = root.findViewById<TextView>(R.id.strength)
        var gridView = root.findViewById<GridView>(R.id.aboutGridId)
        var weaknessGrid = root.findViewById<GridView>(R.id.weaknessGridId)

        aboutMeViewModel.mUser.observe(viewLifecycleOwner, Observer {
//           title.text = it.about
            image.setImageResource(it.image)
//            nameId.text = it.name
            myAdapter.notifyDataSetChanged()
        })


        aboutRecylerView.isNestedScrollingEnabled=false
        aboutRecylerView.setHasFixedSize(true)
        myAdapter = MyAdapter(aboutMeViewModel.getAchievements().value!!,this)
        aboutRecylerView.adapter = myAdapter
        aboutRecylerView.layoutManager = LinearLayoutManager(activity)
        myGridaAdapter =  MyGridAdapter(aboutMeViewModel.getStrengths().value!!)
        myGridaAdapterWeakness =  MyGridAdapter(aboutMeViewModel.getWeaknesses().value!!)
        gridView.adapter = myGridaAdapter
        weaknessGrid.adapter = myGridaAdapterWeakness
        return root
    }

    override fun onFragmentClick(achievement: Achievement) {}
}
