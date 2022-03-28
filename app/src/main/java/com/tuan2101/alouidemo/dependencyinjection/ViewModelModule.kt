package com.tuan2101.alouidemo.dependencyinjection

import com.tuan2101.alouidemo.viewmodels.HomeViewModel
import com.tuan2101.alouidemo.viewmodels.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by ndt2101 on 3/28/2022.
 */

val viewModelModule = module {
    viewModel { HomeViewModel(homeRepository = get()) }
    viewModel { SplashViewModel() }
}