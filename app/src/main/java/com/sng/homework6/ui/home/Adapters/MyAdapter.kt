package com.sng.homework6.ui.home.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sng.homework6.R
import com.sng.homework6.model.Achievement
import com.sng.homework6.ui.home.OnFragmentClickListener
import kotlinx.android.synthetic.main.custom_recycler_view.view.*

class MyAdapter(val alist :List<Achievement>, private val clickListener: OnFragmentClickListener):
    RecyclerView.Adapter<MyAdapter.ViewHolder>(){
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



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private  var topic = itemView.topicId
        private  var content =itemView.contentId

        fun loadView(achievement: Achievement, action: OnFragmentClickListener){
            topic?.text = achievement.topic
            content?.text = achievement.desc
            itemView.setOnClickListener {
                action.onFragmentClick(achievement)
            }
        }

    }


}