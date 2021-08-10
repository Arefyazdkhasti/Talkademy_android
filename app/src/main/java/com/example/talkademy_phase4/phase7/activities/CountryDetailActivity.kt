package com.example.talkademy_phase4.phase7.activities

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.ActivityCountryDetailBinding
import com.example.talkademy_phase4.phase7.adapter.COUNTRY_NAME
import com.example.talkademy_phase4.phase7.dataClass.Country

class CountryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountryDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = intent.getParcelableExtra<Country>(COUNTRY_NAME)

        if (country != null) {
            supportActionBar?.title = country.name

            supportActionBar?.apply {
                setHomeButtonEnabled(true)
                setDisplayHomeAsUpEnabled(true)
            }
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
                Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            }
            setNegativeButton("Cancel") { _, _ ->
                Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            }
            show()
        }


    }

}
