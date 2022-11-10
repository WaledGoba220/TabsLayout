package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayoutL: TabLayout
    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayoutL = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayoutL.addTab(tabLayoutL.newTab().setText("Home"))
        tabLayoutL.addTab(tabLayoutL.newTab().setText("Profile"))
        tabLayoutL.addTab(tabLayoutL.newTab().setText("Settings"))
        tabLayoutL.tabGravity = TabLayout.GRAVITY_FILL


        val adapter = com.example.tablayout.Adapter.Adapter(this, supportFragmentManager, tabLayoutL.tabCount)
        viewPager.adapter =adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayoutL))
        tabLayoutL.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })


    }
}