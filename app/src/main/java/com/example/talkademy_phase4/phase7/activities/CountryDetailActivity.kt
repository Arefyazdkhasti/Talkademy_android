package com.example.talkademy_phase4.phase7.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.ActivityCountryDetailBinding
import com.example.talkademy_phase4.phase7.adapter.COUNTRY_NAME
import com.example.talkademy_phase4.phase7.adapter.ViewPagerAdapter
import com.example.talkademy_phase4.phase7.dataClass.Country
import com.example.talkademy_phase4.phase7.fragments.FirstFragment
import com.example.talkademy_phase4.phase7.fragments.SecondFragment
import com.example.talkademy_phase4.phase7.fragments.ThirdFragment
import com.example.talkademy_phase4.phase7.util.UIUtils.Companion.showToast


class CountryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = intent?.getParcelableExtra<Country>(COUNTRY_NAME)

        if (country != null) {
            supportActionBar?.title = country.name

            supportActionBar?.apply {
                setHomeButtonEnabled(true)
                setDisplayHomeAsUpEnabled(true)
            }
            bindUI(country)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_country_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()

            R.id.like_country -> {
                showAlertDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showAlertDialog() {

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Sample AlertDialog")
            setMessage("You Clicked Star. What do you want to do?")
            setPositiveButton("OK") { _, _ ->
                showToast(applicationContext,"clicked yes")
            }
            setNegativeButton("Cancel") { _, _ ->
                showToast(applicationContext,"clicked cancel")
            }
            show()
        }
    }

    private fun bindUI(country: Country){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstFragment(country.list[0]),"1")
        adapter.addFragment(SecondFragment(country.list[1]),"2")
        adapter.addFragment(ThirdFragment(country.list[2]),"3")

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}
