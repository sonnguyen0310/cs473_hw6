package com.sng.homework6.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sng.homework6.R

class WorkFragment : Fragment() {

    private lateinit var workViewModel: WorkViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        workViewModel =
                ViewModelProviders.of(this).get(WorkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_work, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        workViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
