package com.tuan2101.alouidemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        when (type) {
            ServiceType.TOPSERVICE -> {
                viewModel.onFetchingTopServices()
                viewModel.fetchingTopServicesDataState.observe(viewLifecycleOwner) {
                    it?.let {
                        binding.animationView.visibility =
                            if (it.isLoading) View.VISIBLE else View.GONE
                        it.services?.let { topServices ->
                            adapter.submitList(topServices)
                        } ?: run {
                            it.error?.let { error ->
                                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                            }
                        }
                    } ?: return@observe
                }
            }
            ServiceType.NEWSERVICE -> {
                viewModel.onFetchingNewServices()
                viewModel.fetchingNewServicesDataState.observe(viewLifecycleOwner) {
                    it?.let {
                        binding.animationView.visibility =
                            if (it.isLoading) View.VISIBLE else View.GONE
                        it.services?.let { newServices ->
                            adapter.submitList(newServices)
                        } ?: run {
                            it.error?.let { error ->
                                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                            }
                        }
                    } ?: return@observe
                }
            }

            ServiceType.SAVEDSERVICE -> {
                viewModel.onFetchingSavedServices()
                val emptyServiceFragment = EmptyServiceFragment()
                viewModel.fetchingSavedServicesDataState.observe(viewLifecycleOwner) {
                    it?.let {
                        binding.animationView.visibility =
                            if (it.isLoading) View.VISIBLE else View.GONE
                        it.services?.let { savedServices ->
                            if (savedServices.isEmpty()) {
                                binding.rcv.visibility = View.GONE
                                binding.transactionLayout.visibility = View.VISIBLE
                                childFragmentManager.beginTransaction()
                                    .replace(R.id.transaction_layout, emptyServiceFragment).commit()
                            } else {
                                adapter.submitList(savedServices)
                            }
                        } ?: run {
                            it.error?.let { error ->
                                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                            }
                        }
                    } ?: return@observe
                }
            }
        }
    }
}