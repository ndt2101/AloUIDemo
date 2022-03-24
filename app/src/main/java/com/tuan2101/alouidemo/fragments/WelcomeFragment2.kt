package com.tuan2101.alouidemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuan2101.alouidemo.R
import com.tuan2101.alouidemo.databinding.FragmentWelcome2Binding

class WelcomeFragment2 : Fragment() {

    lateinit var binding: FragmentWelcome2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcome2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }
}