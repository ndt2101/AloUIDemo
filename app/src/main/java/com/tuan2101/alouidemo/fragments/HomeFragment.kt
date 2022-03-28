package com.tuan2101.alouidemo.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.palette.graphics.Palette
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.adapter.AdvertisementAdapter
import com.tuan2101.alouidemo.adapter.ServiceViewPagerAdapter
import com.tuan2101.alouidemo.databinding.FragmentHomeBinding
import com.tuan2101.alouidemo.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModel()
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
        setScrollAnim()
        setupForServiceTab()
        viewModel.onFetchingAdImages()
        setObserve()
        return binding.root
    }

    private fun setupAdViewPager() {
        runnable = Runnable {
            if (binding.adViewpager.currentItem == viewModel.fetchingAdImagesDataState.value!!.adImages!!.size - 1) {
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

    private fun setObserve() {
        viewModel.fetchingAdImagesDataState.observe(viewLifecycleOwner) {
            it?.let {
                it.adImages?.let { adImages ->
                    adAdapter = AdvertisementAdapter(adImages)
                    binding.adViewpager.adapter = adAdapter
                    binding.indicator.setViewPager(binding.adViewpager)
                    setupAdViewPager()
                } ?: run {
                    it.error?.let { error ->
                        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                    }
                } ?: return@observe
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
            handler.removeCallbacks(it)
        }
    }

    override fun onResume() {
        super.onResume()
        runnable?.let {
            handler.postDelayed(it, 3000)
        }

    }
}