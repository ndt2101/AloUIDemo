package com.tuan2101.alouidemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by ndt2101 on 3/24/2022.
 */
class SplashViewModel : ViewModel() {
    private val _navToWelcome2 = MutableLiveData(false)
    private val _navToWelcome1 = MutableLiveData(false)
    private val _requestLocation = MutableLiveData(false)
    val requestLocation: LiveData<Boolean>
        get() = _requestLocation
    val navToWelcome2: LiveData<Boolean>
        get() = _navToWelcome2
    val navToWelcome1: LiveData<Boolean>
        get() = _navToWelcome1

    fun onNavToWelcome1() {
        _navToWelcome1.value = true
    }

    fun onNavToWelcome1Completed() {
        _navToWelcome1.value = false
    }


    fun onNavToWelcome2() {
        _navToWelcome2.value = true
    }

    fun onNavToWelcome2Completed() {
        _navToWelcome2.value = false
    }

    fun onRequestLocation() {
        _requestLocation.value = true
    }

    fun onRequestLocationCompleted() {
        _requestLocation.value = false
    }
}