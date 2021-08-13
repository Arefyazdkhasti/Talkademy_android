package com.example.talkademy_phase4.phase7.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.FragmentFirstBinding
import com.example.talkademy_phase4.databinding.FragmentSecondBinding
import com.example.talkademy_phase4.phase7.dataClass.CountrySite


class SecondFragment(private val countrySite: CountrySite) : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
    }

    private fun bindUI() {
        binding.title2.text = countrySite.content
    }
}