package com.tuan2101.alouidemo.fragments

import android.graphics.BitmapFactory
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.palette.graphics.Palette
import com.google.android.material.tabs.TabLayoutMediator
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.adapter.ServiceAdapter
import com.tuan2101.alouidemo.adapter.ServiceViewPagerAdapter
import com.tuan2101.alouidemo.databinding.FragmentHomeBinding
import com.tuan2101.alouidemo.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding
    private val tabTitleList = arrayListOf("Top dịch vụ", "Dịch vụ mới", "Ghim")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setScrollAnim()
        setupForServiceTab()
        return binding.root
    }

    private fun setScrollAnim() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.for_bitmap)
        Palette.from(bitmap).generate { palette ->
            val color1 = palette?.getVibrantColor(resources.getColor(R.color.gray))
            if (color1 != null) {
                binding.collapsingToolbarLayout.setContentScrimColor(color1)
            }
        }
    }

    private fun setupForServiceTab() {
        binding.viewPager.adapter = ServiceViewPagerAdapter(requireActivity(), viewModel)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitleList[position]
        }.attach()
        binding.viewPager.isUserInputEnabled = false
    }
}