package com.example.talkademy_phase4.Phase6

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talkademy_phase4.databinding.FragmentPhase6Binding

private const val TALKACADEMY = "talkacademy"
private const val LIST_BUNDLE_KEY = "com.example.talkademy_phase4.bundle_key"

class Phase6Fragment : Fragment() {

    private var _binding: FragmentPhase6Binding? = null
    private val binding
        get() = _binding!!

    private lateinit var textList: ArrayList<String>
    private lateinit var itemAdapter: RecyclerItemAdapter
    private lateinit var onConfiguredList: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhase6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        bindUI()
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
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && binding.checkbox.isChecked) {
                    if (s.toString() == TALKACADEMY) {
                        addItemToTheRecyclerView(s.toString())
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        /*if (binding.checkbox.isChecked) {
                    if (s != null) {
                        if (s.toString() == TALKACADEMY) {
                            addItemToTheRecyclerView(s.toString())
                        } else {
                            showToast("Not match with talkacademy")
                        }
                    } else {
                        showToast("Input can't be empty")
                    }
                } else {
                    showToast("check the Check box")
                }*/
    }

    private fun addItemToTheRecyclerView(text: String) {
        itemAdapter.addItem(text)
    }

    private fun showToast(string: String) {
        Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val list = itemAdapter.getItems() as ArrayList<String>
        outState.putStringArrayList(LIST_BUNDLE_KEY, list)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState == null) return


        onConfiguredList = savedInstanceState.getStringArrayList(LIST_BUNDLE_KEY) ?: arrayListOf()
        onConfiguredList.forEach {itemAdapter.addItem(it)}

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}