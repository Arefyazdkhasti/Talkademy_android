package com.example.talkademy_phase4.phase10.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.talkademy_phase4.databinding.ShowTextFragmentBinding
import com.example.talkademy_phase4.phase10.ui.SharedViewModel

class ShowTextFragment : Fragment() {

    fun newInstance(): ShowTextFragment {
        val args = Bundle()

        return ShowTextFragment().apply {
            arguments = args
        }
    }

    private lateinit var viewModel: SharedViewModel

    private var _binding: ShowTextFragmentBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ShowTextFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.content.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer

            binding.content = it
        })
    }


}