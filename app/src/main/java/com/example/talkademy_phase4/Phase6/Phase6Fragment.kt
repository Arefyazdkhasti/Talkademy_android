package com.example.talkademy_phase4.Phase6

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.FragmentPhase6Binding
import java.lang.Exception

private const val TALKACADEMY = "talkacademy"

class Phase6Fragment : Fragment() {

    private var _binding: FragmentPhase6Binding? = null
    private val binding
        get() = _binding!!

    private lateinit var textList: ArrayList<String>
    private lateinit var itemAdapter: RecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhase6Binding.inflate(inflater, container, false)
        initRecycler()
        bindUI()
        return binding.root
    }


    private fun initRecycler() {
        textList = arrayListOf()

        itemAdapter = RecyclerItemAdapter(textList)

        binding.recyclerView.apply {
            adapter = itemAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

    }

    private fun bindUI() {
        binding.addBtn.setOnClickListener {

            val inputText = binding.editText.text
            if (binding.checkbox.isChecked) {
                if (inputText != null) {
                    if (inputText.toString() == TALKACADEMY) {
                        addItemToTheRecyclerView(inputText.toString())
                    } else {
                        showToast("Not match with talkacademy")
                    }
                } else {
                    showToast("Input can't be empty")
                }
            } else {
                showToast("check the Check box")
            }
        }
    }

    private fun addItemToTheRecyclerView(text: String) {
        itemAdapter.addItem(text)
    }

    private fun showToast(string: String) {
        Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}