package com.tuan2101.alouidemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuan2101.alouidemo.dataclasses.Service
import com.tuan2101.alouidemo.repositories.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Created by ndt2101 on 3/25/2022.
 */
class HomeViewModel(val homeRepository: HomeRepository) : ViewModel() {
    private val job = Job()
    private val ioScope = CoroutineScope(Dispatchers.IO + job)

    private val _fetchingTopServicesDataState = MutableLiveData<FetchingServicesDataState>()
    val fetchingTopServicesDataState: LiveData<FetchingServicesDataState>
        get() = _fetchingTopServicesDataState
    private val _fetchingNewServicesDataState = MutableLiveData<FetchingServicesDataState>()
    val fetchingNewServicesDataState: LiveData<FetchingServicesDataState>
        get() = _fetchingNewServicesDataState
    private val _fetchingSavedServicesDataState = MutableLiveData<FetchingServicesDataState>()
    val fetchingSavedServicesDataState: LiveData<FetchingServicesDataState>
        get() = _fetchingSavedServicesDataState
    private val _fetchingAdImagesDataState = MutableLiveData<FetchingAdImagesDataState>()
    val fetchingAdImagesDataState: LiveData<FetchingAdImagesDataState>
        get() = _fetchingAdImagesDataState

    data class FetchingServicesDataState(
        val isLoading: Boolean,
        val services: List<Service>?,
        val error: String?
    )

    data class FetchingAdImagesDataState(
        val isLoading: Boolean,
        val adImages: List<String>?,
        val error: String?
    )

    private fun emitFetchingAdImageDataState(
        isLoading: Boolean = false,
        adImages: List<String>? = null,
        error: String? = null
    ) {
        _fetchingAdImagesDataState.postValue(FetchingAdImagesDataState(isLoading, adImages, error))
    }

    fun onFetchingAdImages() {
        ioScope.launch {
            runCatching {
                emitFetchingAdImageDataState(isLoading = true)
                homeRepository.fetchAdImages()
            }.onSuccess {
                emitFetchingAdImageDataState(adImages = it)
            }.onFailure {
                emitFetchingAdImageDataState(error = it.message)
            }
        }
    }

    private fun emitFetchingTopServicesDataState(
        isLoading: Boolean = false,
        topServices: List<Service>? = null,
        error: String? = null
    ) {
        _fetchingTopServicesDataState.postValue(FetchingServicesDataState(isLoading, topServices, error))
    }

    fun onFetchingTopServices() {
        ioScope.launch {
            runCatching {
                emitFetchingTopServicesDataState(isLoading = true)
                homeRepository.fetchTopServices()
            }.onSuccess {
                emitFetchingTopServicesDataState(topServices = it)
            }.onFailure {
                emitFetchingTopServicesDataState(error = it.message)
            }
        }
    }

    private fun emitFetchingNewServicesDataState(
        isLoading: Boolean = false,
        topServices: List<Service>? = null,
        error: String? = null
    ) {
        _fetchingNewServicesDataState.postValue(FetchingServicesDataState(isLoading, topServices, error))
    }

    fun onFetchingNewServices() {
        ioScope.launch {
            runCatching {
                emitFetchingNewServicesDataState(isLoading = true)
                homeRepository.fetchNewServices()
            }.onSuccess {
                emitFetchingNewServicesDataState(topServices = it)
            }.onFailure {
                emitFetchingNewServicesDataState(error = it.message)
            }
        }
    }

    private fun emitFetchingSavedServicesDataState(
        isLoading: Boolean = false,
        topServices: List<Service>? = null,
        error: String? = null
    ) {
        _fetchingSavedServicesDataState.postValue(FetchingServicesDataState(isLoading, topServices, error))
    }

    fun onFetchingSavedServices() {
        ioScope.launch {
            runCatching {
                emitFetchingSavedServicesDataState(isLoading = true)
                homeRepository.fetchSavedServices()
            }.onSuccess {
                emitFetchingSavedServicesDataState(topServices = it)
            }.onFailure {
                emitFetchingSavedServicesDataState(error = it.message)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}