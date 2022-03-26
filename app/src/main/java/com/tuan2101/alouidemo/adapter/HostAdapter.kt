package com.tuan2101.alouidemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tuan2101.alouidemo.fragments.HomeFragment
import com.tuan2101.alouidemo.fragments.PersonalFragment
import com.tuan2101.alouidemo.fragments.ScheduleFragment

/**
 * Created by ndt2101 on 3/26/2022.
 */
class HostAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> ScheduleFragment()
            2 -> PersonalFragment()
            else -> HomeFragment()
        }
    }
}