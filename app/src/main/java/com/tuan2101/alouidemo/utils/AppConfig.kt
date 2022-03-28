package com.tuan2101.alouidemo.utils

import android.app.Application
import com.tuan2101.alouidemo.dependencyinjection.repositoryModule
import com.tuan2101.alouidemo.dependencyinjection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by ndt2101 on 3/28/2022.
 */
class AppConfig: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppConfig)
            modules(listOf(viewModelModule, repositoryModule))
        }
    }
}