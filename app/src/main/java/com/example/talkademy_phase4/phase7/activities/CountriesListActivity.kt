package com.example.talkademy_phase4.phase7.activities

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.ActivityCountriesListBinding
import com.example.talkademy_phase4.phase7.Interfaces.IOnBackPressed
import com.example.talkademy_phase4.phase7.fragments.CountryFragment

class CountriesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesListBinding.inflate(layoutInflater)

        setContentView(binding.root)
        //set title toolbar
        supportActionBar?.title = "Country List"

        loadFragment(CountryFragment(), "CountryFragment")
    }


    fun loadFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.country_setting_fragment_container_view, fragment, tag)
            .addToBackStack(tag)
            .addToBackStack(null)
            .commit()
    }

    /*override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
    }*/
    override fun onBackPressed() {
        val fragment = this.supportFragmentManager.findFragmentById(R.id.country_setting_fragment_container_view)
        (fragment as? IOnBackPressed)?.onBackPressed()?.let {
            super.onBackPressed()
        }
    }

}