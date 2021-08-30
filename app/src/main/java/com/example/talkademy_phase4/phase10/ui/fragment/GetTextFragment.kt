package com.example.talkademy_phase4.phase10.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.GetTextFragmentBinding
import com.example.talkademy_phase4.phase10.ui.SharedViewModel
import com.example.talkademy_phase4.phase10.util.DataListener
import com.example.talkademy_phase4.phase10.util.EditTextListener
import com.example.talkademy_phase4.phase7.util.UIUtils.Companion.loadFragment

class GetTextFragment : Fragment(), DataListener {


    private lateinit var viewModel: SharedViewModel

    private var _binding: GetTextFragmentBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GetTextFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        bindUI()
    }

    private fun bindUI() {
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                (requireActivity() as EditTextListener).isEdtEmpty(p0.isNullOrEmpty(),p0)

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    override fun sendData() {
        viewModel.content.postValue(binding.editText.text.toString())
    }


}