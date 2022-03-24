package com.tuan2101.alouidemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tuan2101.alouidemo.fragments.WelcomeFragment
import com.tuan2101.alouidemo.fragments.WelcomeFragment2

/**
 * Created by ndt2101 on 3/24/2022.
 */
class SplashAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> WelcomeFragment()
            1 -> WelcomeFragment2()
            else -> WelcomeFragment()
        }
    }
}