package com.example.talkademy_phase4.phase9

import android.content.Context
import androidx.fragment.app.Fragment
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.ContactItemBinding
import com.example.talkademy_phase4.phase7.fragments.REQUEST_CONTINENTS
import java.io.IOException


class ContactsAdapter(
    private val fragment: Fragment,
    private val data: List<ContactsInfo>
) : RecyclerView.Adapter<ContactsAdapter.ContactItemViewHolder>() {

    private lateinit var binding: ContactItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {

        binding =
            ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ContactItemViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        holder.setData(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class ContactItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(contact: ContactsInfo) {
            if (!::binding.isInitialized) return

            binding.contactName.text = contact.displayName

            binding.contactNumber.text = contact.phoneNumber


            itemView.setOnClickListener {
                Util.launchItemFragment(fragment,contact,"item")
            }
        }

    }
}