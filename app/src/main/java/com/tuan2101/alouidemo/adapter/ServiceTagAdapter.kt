package com.tuan2101.alouidemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuan2101.alouidemo.databinding.TagItemBinding

/**
 * Created by ndt2101 on 3/26/2022.
 */
class ServiceTagAdapter(val tags: List<String>): RecyclerView.Adapter<ServiceTagAdapter.TagViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(tags[position])
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    class TagViewHolder(val binding: TagItemBinding): RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): TagViewHolder {
                return TagViewHolder(TagItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
        fun bind(tag: String) {
            binding.tags.text = tag
        }
    }
}