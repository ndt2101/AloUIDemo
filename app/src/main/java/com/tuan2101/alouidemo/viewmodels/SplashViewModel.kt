package com.tuan2101.alouidemo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by ndt2101 on 3/24/2022.
 */
class SplashViewModel(): ViewModel() {
    private val _navToWelcome2 = MutableLiveData(false)
    val navToWelcome2: LiveData<Boolean>
        get() = _navToWelcome2

    fun onNavToWelcome2() {
        _navToWelcome2.value = true
    }

    fun onNavToWelcome2Completed() {
        _navToWelcome2.value = false
    }
}