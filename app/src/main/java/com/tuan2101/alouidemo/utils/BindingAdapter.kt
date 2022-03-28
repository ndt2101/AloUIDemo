package com.tuan2101.alouidemo.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.dataclasses.Service

/**
 * Created by ndt2101 on 3/25/2022.
 */

@BindingAdapter("setTrust")
fun TextView.setTrust(service: Service) {
    if (service.isTrusted) {
        this.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_shield_24, 0, 0, 0)
    }
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}