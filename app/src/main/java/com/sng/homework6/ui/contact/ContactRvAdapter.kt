package com.sng.homework6.ui.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sng.homework6.R
import com.sng.homework6.model.Contact

class ContactRvAdapter(val list: ArrayList<Contact>?) : RecyclerView.Adapter<Vh>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.contact_item_view, parent, false)
        return Vh(itemView)
    }

    override fun getItemCount(): Int {
        var count = 0
        list?.let {
            count = it.count()
        }
        return count
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
    }

}

class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {

}