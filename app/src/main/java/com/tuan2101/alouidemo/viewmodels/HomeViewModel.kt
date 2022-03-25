package com.tuan2101.alouidemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuan2101.dataclasses.Service

/**
 * Created by ndt2101 on 3/25/2022.
 */
class HomeViewModel() : ViewModel() {
    private val _topServices = MutableLiveData<List<Service>>()
    val topServices: LiveData<List<Service>>
        get() = _topServices

    fun getTopServices() {
        val list = ArrayList<Service>()
        val tags = ArrayList<String>()
        tags.add("Sửa chữa điểu hòa")
        tags.add("Sửa đồ")
        tags.add("Thay mực")
        val service = Service(
            0,
            "Sửa điều hòa Kim Thành",
            true,
            "https://dstgroup.vn/wp-content/uploads/2021/05/ad8932ee4830bb6ee221.jpg",
            tags,
            0.3f,
            "08",
            "18",
            4.5f
        )
        list.add(service)
        list.add(service)
        list.add(service)
        list.add(service)
        list.add(service)
        list.add(service)
        list.add(service)
        _topServices.postValue(list)
    }

}