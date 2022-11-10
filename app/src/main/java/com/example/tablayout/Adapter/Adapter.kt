package com.example.tablayout.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tablayout.Fragments.Home
import com.example.tablayout.Fragments.Profile
import com.example.tablayout.Fragments.Settings

internal  class Adapter (var context: Context,
                         fm: FragmentManager,
                         var totalTaps:Int

):FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return totalTaps
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                Home()
            }
            1 -> {
                Profile()
            }
            2->{
                Settings()
            }
            else -> getItem(position)

        }
    }

}