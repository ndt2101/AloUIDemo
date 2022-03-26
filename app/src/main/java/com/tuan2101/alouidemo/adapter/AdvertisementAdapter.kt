package com.tuan2101.alouidemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tuan2101.alouidemo.databinding.AdvertisementItemBinding

/**
 * Created by ndt2101 on 3/26/2022.
 */
class AdvertisementAdapter(private val listImg: List<String>) :
    RecyclerView.Adapter<AdvertisementAdapter.AdvertisementViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisementViewHolder {
        return AdvertisementViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AdvertisementViewHolder, position: Int) {
        holder.bind(listImg[position])
    }

    override fun getItemCount(): Int {
        return listImg.size
    }

    class AdvertisementViewHolder(val binding: AdvertisementItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(img: String) {
            Glide.with(binding.root.context).load(img).into(binding.adImg)
        }

        companion object {
            fun from(parent: ViewGroup): AdvertisementViewHolder {
                return AdvertisementViewHolder(
                    AdvertisementItemBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false)
                )
            }
        }
    }

}