package com.sng.homework6

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.sng.homework6.ui.aboutMe.AboutMeFragment
import com.sng.homework6.ui.contact.ContactFragment
import com.sng.homework6.ui.home.HomeFragment
import com.sng.homework6.ui.work.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val fragments =
        arrayListOf(HomeFragment(), AboutMeFragment(), WorkFragment(),  ContactFragment())

    var mPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter = TabAdapter(supportFragmentManager, fragments, arrayListOf(
            getString(R.string.title_home),
            getString(R.string.title_about_me),
            getString(R.string.title_work),
            getString(R.string.title_contact)
        ))
        pager.adapter = adapter

    }

    class TabAdapter internal constructor(
        fm: FragmentManager,
        list: ArrayList<Fragment>,
        titles: ArrayList<String>
    ) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val mFragmentList = list
        private val mFragmentTitleList = titles

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        /**
         * If you want to only show icons, return null from this method.
         * @param position
         * @return
         */
        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }
    }

     override fun onCreateOptionsMenu(menu: Menu?):Boolean {
        super.onCreateOptionsMenu(menu)
         menuInflater.inflate(R.menu.bottom_nav_menu,menu)
         return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.navigation_home -> Toast.makeText(applicationContext,"HOME CLICKED",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


}
