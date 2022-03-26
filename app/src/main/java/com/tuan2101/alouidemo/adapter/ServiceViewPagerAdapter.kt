package com.tuan2101.alouidemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tuan2101.alouidemo.fragments.ServiceItemFragment
import com.tuan2101.alouidemo.utils.ServiceType
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
            0 -> ServiceItemFragment(ServiceType.TOPSERVICE, viewModel)
            1 -> ServiceItemFragment(ServiceType.NEWSERVICE, viewModel)
            2 -> ServiceItemFragment(ServiceType.SAVEDSERVICE, viewModel)
            else -> ServiceItemFragment(ServiceType.TOPSERVICE, viewModel)
        }
    }
}