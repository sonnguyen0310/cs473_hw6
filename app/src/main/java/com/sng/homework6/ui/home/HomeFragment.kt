package com.sng.homework6.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sng.homework6.R
import com.sng.homework6.model.Achievement
import kotlinx.android.synthetic.main.custom_recycler_view.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),OnFragmentClickListener {
    lateinit var myAdapter: MyAdapter

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
        homeViewModel.mUser.observe(viewLifecycleOwner, Observer {
            aboutId.text = it.about
            profileId.setImageResource(it.image)
            nameId.text = it.name
            myAdapter.notifyDataSetChanged()
        })



        homeRecyclerview.hasFixedSize()
        homeRecyclerview.isNestedScrollingEnabled=false
        myAdapter = MyAdapter(homeViewModel.getAchievements().value!!,this)
        homeRecyclerview.adapter = myAdapter
        homeRecyclerview.layoutManager = LinearLayoutManager(activity)
        return root
    }

    override fun onFragmentClick(achievement: Achievement) {}
}

class MyAdapter(val alist :List<Achievement>,private val clickListener: OnFragmentClickListener):RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_recycler_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return alist.size
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
       holder.loadView(alist[position],clickListener)
    }



    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
       private  var topic = itemView.topicId
       private  var content =itemView.contentId

        fun loadView(achievement: Achievement,action:OnFragmentClickListener){
            topic?.text = achievement.topic
            content?.text = achievement.desc
            itemView.setOnClickListener {
                action.onFragmentClick(achievement)
            }
        }

    }


}




