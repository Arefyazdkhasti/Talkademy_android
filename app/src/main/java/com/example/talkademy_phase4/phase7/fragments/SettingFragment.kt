package com.example.talkademy_phase4.phase7.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.talkademy_phase4.databinding.FragmentSettingBinding
import com.example.talkademy_phase4.phase7.Interfaces.IOnBackPressed
import com.example.talkademy_phase4.phase7.enumerian.Continent


class SettingFragment : Fragment(), IOnBackPressed {

    private var _binding: FragmentSettingBinding? = null
    private val binding
        get() = _binding!!

    fun newInstance(continents: ArrayList<String>): SettingFragment {
        val args = Bundle().apply {
            putStringArrayList(CONTINENTS_KEY, continents)
        }
        return SettingFragment().apply {
            arguments = args
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val continents = arguments?.getStringArrayList(CONTINENTS_KEY)
        if (continents != null)
            bindUI(continents)


        setHasOptionsMenu(true)
    }

    private fun bindUI(continent: ArrayList<String>) {
        if (continent.contains(Continent.AMERICA.toString()))
            binding.america.isChecked =true
        if (continent.contains(Continent.AFRICA.toString()))
            binding.africa.isChecked = true
        if (continent.contains(Continent.ASIA.toString()))
            binding.asia.isChecked = true
        if (continent.contains(Continent.EUROPE.toString()))
            binding.europe.isChecked = true
        if (continent.contains(Continent.AUSTRALIA.toString()))
            binding.australia.isChecked = true
    }


    private fun sendContinents() {
        (targetFragment as? CountryFragment)?.setContinent(getCheckedContinents())
    }

    private fun getCheckedContinents(): List<Continent> {
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

    override fun onBackPressed() {
        sendContinents()
    }


}