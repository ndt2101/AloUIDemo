package com.tuan2101.alouidemo.dependencyinjection

import com.tuan2101.alouidemo.repositories.HomeRepository
import com.tuan2101.alouidemo.repositories.HomeRepositoryImpl
import org.koin.dsl.module

/**
 * Created by ndt2101 on 3/28/2022.
 */

val repositoryModule = module {
    factory<HomeRepository> { HomeRepositoryImpl() }
}