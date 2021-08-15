package com.example.talkademy_phase4.phase7.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.FragmentCountryBinding
import com.example.talkademy_phase4.phase7.activities.CountriesListActivity
import com.example.talkademy_phase4.phase7.adapter.CountryAdapter
import com.example.talkademy_phase4.phase7.dataClass.Country
import com.example.talkademy_phase4.phase7.DataFakeGenerator
import com.example.talkademy_phase4.phase7.enumerian.Continent
import com.example.talkademy_phase4.phase7.util.UIUtils.Companion.loadFragment


const val REQUEST_CONTINENTS = 12
const val CONTINENTS_KEY = "com.example.talkademy_phase4.continent_key"

class CountryFragment : Fragment() {

    private var _binding: FragmentCountryBinding? = null
    private val binding
        get() = _binding!!

    private var continent: ArrayList<Continent> = arrayListOf(
        Continent.AMERICA,
        Continent.AFRICA,
        Continent.ASIA,
        Continent.EUROPE,
        Continent.AUSTRALIA
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.country_list_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.setting) {
            launchSettingFragment()
        }
        return true
    }

    private fun launchSettingFragment() {
        val newFragment = SettingFragment().newInstance(changeContinentToString())

        newFragment.setTargetFragment(this, REQUEST_CONTINENTS)
        loadFragment(activity as AppCompatActivity,newFragment, "SettingFragment")
    }


    private fun bindUI() {
        println(continent)
        val countryList = arrayListOf<Country>()

        if (continent.contains(Continent.AMERICA))
            countryList.addAll(DataFakeGenerator.getAmericaCountry())
        if (continent.contains(Continent.AFRICA))
            countryList.addAll(DataFakeGenerator.getAfricaCountry())
        if (continent.contains(Continent.ASIA))
            countryList.addAll(DataFakeGenerator.getAsiaCountry())
        if (continent.contains(Continent.EUROPE))
            countryList.addAll(DataFakeGenerator.getEuropeCountry())
        if (continent.contains(Continent.AUSTRALIA))
            countryList.addAll(DataFakeGenerator.getAustraliaCountry())

        initRecycler(countryList)
    }

    private fun initRecycler(countryList: ArrayList<Country>) {
        val _adapter = CountryAdapter(countryList)

        binding.countryRecyclerView.apply{
            adapter = _adapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        }
    }


    fun setContinent(list: List<Continent>) {
        continent.clear()
        continent.addAll(list)
    }

    private fun changeContinentToString(): ArrayList<String>{
        val list = ArrayList<String>()
        continent.forEach {
            list.add(it.name)
        }
        return list
    }
}