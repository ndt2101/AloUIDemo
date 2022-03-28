package com.tuan2101.alouidemo.repositories

import com.tuan2101.alouidemo.dataclasses.Service

/**
 * Created by ndt2101 on 3/28/2022.
 */
interface HomeRepository {
    suspend fun fetchTopServices(): List<Service>
    suspend fun fetchNewServices(): List<Service>
    suspend fun fetchSavedServices(): List<Service>
    suspend fun fetchAdImages(): List<String>
}