package com.sng.homework6.ui.home.Adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ProgressBar
import android.widget.TextView
import com.sng.homework6.R
import com.sng.homework6.model.Skill


class MyGridAdapter (private val myList:List<Skill>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder

        if(convertView==null){
            view = LayoutInflater.from(container?.context).inflate(R.layout.skills_custom_layout,container,false)
            viewHolder  = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var skill:Skill  = getItem(position)

        viewHolder.skill?.text =skill.skill
        viewHolder.progress?.progress = skill.progress
        return view as View
    }

    override fun getItem(p0: Int): Skill {
        return myList[p0]
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getCount(): Int {
       return myList.size
    }

    private class ViewHolder(view:View?){
        var skill: TextView?=null
        var progress: ProgressBar?=null
        init {
            skill = view?.findViewById(R.id.skillId)
            progress = view?.findViewById(R.id.progressBarId)

        }
    }
}