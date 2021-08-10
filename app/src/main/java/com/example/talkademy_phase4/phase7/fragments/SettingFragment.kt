package com.example.talkademy_phase4.phase7.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.talkademy_phase4.databinding.FragmentSettingBinding
import com.example.talkademy_phase4.phase7.Interfaces.IOnBackPressed
import com.example.talkademy_phase4.phase7.enumerian.Continent


class SettingFragment : Fragment(),IOnBackPressed {

    private var _binding: FragmentSettingBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.text.setOnClickListener {
            sendContinents()
        }

        // TODO showing the back button in action bar
        requireActivity().actionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        setHasOptionsMenu(true)
    }

    private fun sendContinents() {
        (targetFragment as? CountryFragment)?.setContinent(getCheckedContinents())
        activity?.supportFragmentManager?.popBackStackImmediate()
    }

    private fun getCheckedContinents(): List<Continent>{
        val continentList = arrayListOf<Continent>()

        if (binding.america.isChecked)
            continentList.add(Continent.AMERICA)
        if (binding.africa.isChecked)
            continentList.add(Continent.AFRICA)
        if (binding.asia.isChecked)
            continentList.add(Continent.ASIA)
        if (binding.europe.isChecked)
            continentList.add(Continent.EUROPE)
        if (binding.australia.isChecked)
            continentList.add(Continent.AUSTRALIA)

        return continentList
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> /*requireActivity().finish()*/ println("home")
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        //TODO return list
        sendContinents()
    }


}