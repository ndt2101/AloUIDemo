package com.tuan2101.alouidemo.fragments

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.tuan2101.alouidemo.activities.MainActivity
import com.tuan2101.alouidemo.databinding.FragmentWelcome2Binding
import com.tuan2101.alouidemo.viewmodels.SplashViewModel

class WelcomeFragment2 : Fragment() {

    val viewModel: SplashViewModel by activityViewModels()
    var callBack: OnBackPressedCallback? = null
    lateinit var binding: FragmentWelcome2Binding
    private lateinit var sharedPreferences: SharedPreferences


    @RequiresApi(Build.VERSION_CODES.N)
    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                val saveSharedPreferencesState =
                    sharedPreferences.edit().putString("isTheFirstTime", "No").commit()
                navigateToMain()
                viewModel.onRequestLocationCompleted()
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                val saveSharedPreferencesState =
                    sharedPreferences.edit().putString("isTheFirstTime", "No").commit()
                navigateToMain()
                viewModel.onRequestLocationCompleted()
            }
            else -> {
                navigateToMain()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcome2Binding.inflate(layoutInflater, container, false)
        sharedPreferences = requireActivity().getSharedPreferences(
            "sharePreference",
            AppCompatActivity.MODE_PRIVATE
        )
        setObserve()
        binding.viewModel = viewModel
        return binding.root
    }

    private fun setObserve() {
        viewModel.requestLocation.observe(viewLifecycleOwner) {
            if (it) {
                locationPermissionRequest.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }
    }


    private fun navigateToMain() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onResume() {
        super.onResume()
        onBack()
    }

    private fun onBack() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewModel.onNavToWelcome1()
            if (isEnabled) {
                isEnabled = false
            }
        }
    }

    override fun onPause() {
        super.onPause()
        callBack?.remove()
    }
}