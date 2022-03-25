package com.tuan2101.alouidemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuan2101.alouidemo.adapter.ServiceAdapter
import com.tuan2101.alouidemo.databinding.FragmentServiceItemBinding
import com.tuan2101.alouidemo.viewmodels.HomeViewModel

class ServiceItemFragment(val type: String, val viewModel: HomeViewModel) : Fragment() {

    lateinit var binding: FragmentServiceItemBinding
    lateinit var adapter: ServiceAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentServiceItemBinding.inflate(layoutInflater, container, false)
        adapter = ServiceAdapter()
        binding.rcv.adapter = adapter
        setObserve()
        viewModel.getTopServices()
        return binding.root
    }

    private fun setObserve() {
        viewModel.topServices.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it)
            }
        }
    }
}