package com.sng.homework6.ui.contact

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sng.homework6.R
import com.sng.homework6.model.Contact

class ContactRvAdapter(private val list: ArrayList<Contact>, private val callback: ContactCallBack, private val context: Context?) :
    RecyclerView.Adapter<Vh>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.contact_item_view, parent, false)
        return Vh(itemView)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], callback, context)
    }

}

class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(data: Contact?, callback: ContactCallBack?, context: Context?) {
        data?.let {
            val pro = it
            val title = itemView.findViewById<TextView>(R.id.tvTitle)
            val img = itemView.findViewById<ImageView>(R.id.imageView)
            title.text = it.description
            img.setImageDrawable(context?.resources?.getDrawable(data.img))
            itemView.setOnClickListener {
                callback?.onItemCLick(pro)
            }
        }

    }
}