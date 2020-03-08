package com.sng.homework6.ui.work

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sng.homework6.R
import com.sng.homework6.model.Work
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class WorkRecyclerViewAdapter(var context: Context?, var workList: ArrayList<Work>) :
    RecyclerView.Adapter<WorkRecyclerViewAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.t1.text = "COMPANY: ${workList.get(position).company}"
        holder.t2.text = "TITLE: ${workList.get(position).title}"
        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val startDate: String = simpleDateFormat.format(workList.get(position).startDate)
        val endDate: String = simpleDateFormat.format(workList.get(position).endDate)
        holder.t3.text = "START DATE: ${startDate}"
        holder.t4.text = "END DATE: ${endDate}"
        holder.t5.text = "TECHNOLOGIES: ${workList.get(position).technologies}"
        holder.t6.text = "PROJECTS: ${workList.get(position).projects}"
        holder.t7.text = "DETAILS: ${workList.get(position).additionalDetails}"

        holder.parentlayout.setOnClickListener {
            // do nothing for now
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v =
            LayoutInflater.from(parent?.context).inflate(R.layout.work_recyclerview, parent, false)
        return MyViewHolder(v);
    }

    override fun getItemCount(): Int {
        return workList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var t1: TextView = itemView.findViewById<TextView>(R.id.tv1)
        var t2: TextView = itemView.findViewById<TextView>(R.id.tv2)
        var t3: TextView = itemView.findViewById<TextView>(R.id.tv3)
        var t4: TextView = itemView.findViewById<TextView>(R.id.tv4)
        var t5: TextView = itemView.findViewById<TextView>(R.id.tv5)
        var t6: TextView = itemView.findViewById<TextView>(R.id.tv6)
        var t7: TextView = itemView.findViewById<TextView>(R.id.tv7)
        var parentlayout: LinearLayout = itemView.findViewById(R.id.playout) as LinearLayout
    }

}