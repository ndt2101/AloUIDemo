package com.tuan2101.alouidemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tuan2101.alouidemo.databinding.ServiceItemBinding
import com.tuan2101.dataclasses.Service

/**
 * Created by ndt2101 on 3/25/2022.
 */
class ServiceAdapter(): ListAdapter<Service, ServiceAdapter.ServiceViewHolder>(ServiceCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ServiceViewHolder(val binding: ServiceItemBinding): RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ServiceViewHolder{
                return ServiceViewHolder(ServiceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }

        fun bind(service: Service) {
            binding.service = service
            binding.tags.layoutManager = object : LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false) {
                override fun canScrollHorizontally(): Boolean {
                    return false
                }
            }
            binding.tags.adapter = ServiceTagAdapter(service.tags)
        }
    }

    class ServiceCallBack : DiffUtil.ItemCallback<Service>() {
        override fun areItemsTheSame(oldItem: Service, newItem: Service): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Service, newItem: Service): Boolean {
            return oldItem == newItem
        }

    }
}