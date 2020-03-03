package com.sng.homework6.ui.aboutMe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sng.homework6.R

class AboutMeFragment : Fragment() {

    private lateinit var aboutMeViewModel: AboutMeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        aboutMeViewModel =
                ViewModelProviders.of(this).get(AboutMeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about_me, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        aboutMeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
