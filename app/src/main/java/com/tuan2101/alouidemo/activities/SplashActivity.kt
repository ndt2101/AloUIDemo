package com.tuan2101.alouidemo.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.adapter.SplashAdapter
import com.tuan2101.alouidemo.databinding.ActivitySplashBinding
import com.tuan2101.alouidemo.viewmodels.SplashViewModel

class SplashActivity : AppCompatActivity() {

    val viewModel: SplashViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences

    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        sharedPreferences = getSharedPreferences("sharePreference", MODE_PRIVATE)
        val isTheFirstTime = sharedPreferences.getString("isTheFirstTime", null)

        if (isTheFirstTime != null) {
            navigateToMain()
        } else {
            binding.viewPager2.adapter = SplashAdapter(this)
            binding.circleIndicator.setViewPager(binding.viewPager2)
            setObserve()
        }
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setObserve() {
        viewModel.navToWelcome2.observe(this) {
            if (it) {
                binding.viewPager2.currentItem = 1
                viewModel.onNavToWelcome2Completed()
            }
        }

        viewModel.navToWelcome1.observe(this) {
            if (it) {
                binding.viewPager2.currentItem = 0
                viewModel.onNavToWelcome1Completed()
            }
        }
    }
}