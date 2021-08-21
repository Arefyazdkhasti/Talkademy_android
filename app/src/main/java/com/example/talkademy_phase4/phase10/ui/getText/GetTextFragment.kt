package com.example.talkademy_phase4.phase10.ui.getText

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.FragmentContactItemBinding
import com.example.talkademy_phase4.databinding.GetTextFragmentBinding

class GetTextFragment : Fragment() {

    companion object {
        fun newInstance() = GetTextFragment()
    }

    private lateinit var viewModel: GetTextViewModel

    private var _binding: GetTextFragmentBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GetTextFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GetTextViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}