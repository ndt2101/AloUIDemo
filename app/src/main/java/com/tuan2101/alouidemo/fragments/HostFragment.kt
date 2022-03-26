package com.tuan2101.alouidemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.adapter.HostAdapter
import com.tuan2101.alouidemo.databinding.FragmentHostBinding

class HostFragment : Fragment() {

    lateinit var binding: FragmentHostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostBinding.inflate(layoutInflater, container, false)

        setupViewPager()
        return binding.root
    }

    private fun setupViewPager() {
        val adapter = HostAdapter(requireActivity())
        binding.viewpager.adapter = adapter
        binding.viewpager.isUserInputEnabled = false

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position) {
                    0 -> binding.bottomNavView.menu.findItem(R.id.home).isChecked = true
                    1 -> binding.bottomNavView.menu.findItem(R.id.schedule).isChecked = true
                    2 -> binding.bottomNavView.menu.findItem(R.id.account).isChecked = true
                }
            }
        })

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> binding.viewpager.currentItem = 0
                R.id.schedule -> binding.viewpager.currentItem = 1
                R.id.account -> binding.viewpager.currentItem = 2
            }
            true
        }
    }
}