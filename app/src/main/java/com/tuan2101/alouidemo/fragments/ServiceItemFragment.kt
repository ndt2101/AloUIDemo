package com.tuan2101.alouidemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.adapter.ServiceAdapter
import com.tuan2101.alouidemo.databinding.FragmentServiceItemBinding
import com.tuan2101.alouidemo.utils.ServiceType
import com.tuan2101.alouidemo.viewmodels.HomeViewModel

class ServiceItemFragment(val type: ServiceType, val viewModel: HomeViewModel) : Fragment() {

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
        return binding.root
    }

    private fun setObserve() {
        when(type) {
            ServiceType.TOPSERVICE -> {
                viewModel.getTopServices()
                viewModel.topServices.observe(viewLifecycleOwner) {
                    it?.let {
                        adapter.submitList(it)
                    }
                }
            }
            ServiceType.NEWSERVICE -> {
                viewModel.getTopServices()
                viewModel.newServices.observe(viewLifecycleOwner) {
                    it?.let {
                        adapter.submitList(it)
                    }
                }
            }

            ServiceType.SAVEDSERVICE -> {
                val emptyServiceFragment = EmptyServiceFragment()
                viewModel.savedServices.observe(viewLifecycleOwner) {
                    if (it.isNullOrEmpty()) {
                        binding.rcv.visibility = View.GONE
                        binding.transactionLayout.visibility = View.VISIBLE
                        childFragmentManager.beginTransaction().replace(R.id.transaction_layout, emptyServiceFragment).commit()
                    } else {
                        adapter.submitList(it)
                    }
                }
            }
        }
    }
}