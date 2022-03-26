package com.tuan2101.alouidemo.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.palette.graphics.Palette
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.adapter.AdvertisementAdapter
import com.tuan2101.alouidemo.adapter.ServiceAdapter
import com.tuan2101.alouidemo.adapter.ServiceViewPagerAdapter
import com.tuan2101.alouidemo.databinding.FragmentHomeBinding
import com.tuan2101.alouidemo.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding
    private val tabTitleList = arrayListOf("Top dịch vụ", "Dịch vụ mới", "Ghim")
    private lateinit var adAdapter: AdvertisementAdapter
    var runnable: Runnable? = null
    val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setScrollAnim()
        setupForServiceTab()
        viewModel.getAdImages()
        setObserve()
        return binding.root
    }

    fun setupAdViewPager() {
        runnable = Runnable {
            if (binding.adViewpager.currentItem == viewModel.adImages.value!!.size - 1) {
                binding.adViewpager.currentItem = 0
            } else {
                binding.adViewpager.currentItem = binding.adViewpager.currentItem + 1
            }
        }

        binding.adViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable!!)
                handler.postDelayed(runnable!!, 3000)
            }
        })
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

    fun setObserve() {
        viewModel.adImages.observe(viewLifecycleOwner) {
            it?.let {
                adAdapter = AdvertisementAdapter(it)
                binding.adViewpager.adapter = adAdapter
                binding.indicator.setViewPager(binding.adViewpager)
                setupAdViewPager()
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

    override fun onPause() {
        super.onPause()
        runnable?.let {
            handler.removeCallbacks(it)        }
    }

    override fun onResume() {
        super.onResume()
        runnable?.let {
            handler.postDelayed(it, 3000)
        }

    }
}