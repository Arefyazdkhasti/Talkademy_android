package com.example.talkademy_phase4.phase7.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.talkademy_phase4.databinding.ItemCountryBinding
import com.example.talkademy_phase4.phase7.activities.CountryDetailActivity
import com.example.talkademy_phase4.phase7.dataClass.Country

const val COUNTRY_NAME = "com.example.talkademy_phase4_country_name"
class CountryAdapter (
    private val context: Context,
    private val data: List<Country>
) : RecyclerView.Adapter<CountryAdapter.CountryItemViewHolder>() {

    private lateinit var binding: ItemCountryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItemViewHolder {

        binding =
            ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CountryItemViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: CountryItemViewHolder, position: Int) {
        holder.setData(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class CountryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(country:Country) {
            if (::binding.isInitialized) {
                binding.country.text = country.name
                binding.continent.text = country.continent.toString()
            }

            itemView.setOnClickListener {
                val intent = Intent(context,CountryDetailActivity::class.java)
                intent.putExtra(COUNTRY_NAME,country)
                context.startActivity(intent)
            }
        }

    }

}