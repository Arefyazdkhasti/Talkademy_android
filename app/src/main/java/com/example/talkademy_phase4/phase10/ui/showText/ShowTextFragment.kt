package com.example.talkademy_phase4.phase10.ui.showText

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.talkademy_phase4.R

class ShowTextFragment : Fragment() {

    companion object {
        fun newInstance() = ShowTextFragment()
    }

    private lateinit var viewModel: ShwoTextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_text_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShwoTextViewModel::class.java)
        // TODO: Use the ViewModel
    }

}