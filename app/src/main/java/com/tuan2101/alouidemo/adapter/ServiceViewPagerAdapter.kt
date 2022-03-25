package com.tuan2101.alouidemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tuan2101.alouidemo.fragments.ServiceItemFragment
import com.tuan2101.alouidemo.viewmodels.HomeViewModel

/**
 * Created by ndt2101 on 3/25/2022.
 */
class ServiceViewPagerAdapter(activity: FragmentActivity, val viewModel: HomeViewModel) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ServiceItemFragment("top_service", viewModel)
            1 -> ServiceItemFragment("new_service", viewModel)
            2 -> ServiceItemFragment("saved_service", viewModel)
            else -> ServiceItemFragment("top_service", viewModel)
        }
    }
}