package com.tuan2101.alouidemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.adapter.SplashAdapter
import com.tuan2101.alouidemo.databinding.ActivitySplashBinding
import com.tuan2101.alouidemo.viewmodels.SplashViewModel

class SplashActivity : AppCompatActivity() {

    val viewModel: SplashViewModel by viewModels()

    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.viewPager2.adapter = SplashAdapter(this)
        binding.circleIndicator.setViewPager(binding.viewPager2)
        binding.viewPager2.isUserInputEnabled = false
        setObserve()
    }

    private fun setObserve() {
        viewModel.navToWelcome2.observe(this) {
            if (it) {
                binding.viewPager2.currentItem = 1
                viewModel.onNavToWelcome2Completed()
            }
        }
    }
}