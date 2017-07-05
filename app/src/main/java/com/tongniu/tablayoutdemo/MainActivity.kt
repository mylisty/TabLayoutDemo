package com.tongniu.tablayoutdemo

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
     var tabLayout: TabLayout?=null
     var viewPager: ViewPager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBarCompat.compat(this)
        tabLayout = findViewById(R.id.tabLayout) as TabLayout
        viewPager = findViewById(R.id.viewpager) as ViewPager
        val title = ArrayList<String>()
        title.add("Taab 1")
        title.add("Tab 2")
        tabLayout!!.addTab(tabLayout!!.newTab().setText(title[0]))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(title[1]))
        val list = ArrayList<Fragment>()
        list.add(FirstFragment())
        list.add(FirstFragment2())
        tabLayout!!.tabMode = TabLayout.MODE_SCROLLABLE
        viewPager!!.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return list[position]
            }

            override fun getCount(): Int {
                return list.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                return title[position]
            }
        }
        tabLayout!!.setupWithViewPager(viewPager)
        viewPager!!.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                Toast.makeText(this@MainActivity, "" + position, Toast.LENGTH_SHORT).show()
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
}
