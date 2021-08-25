package com.example.talkademy_phase4.phase9

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.FragmentContactItemBinding
import com.example.talkademy_phase4.databinding.FragmentContactListBinding
import java.io.IOException

const val CONTACT_KEY = "com.example.talkademy_phase4.phase9_contact_key"

class ContactItemFragment : Fragment() {

    private var _binding: FragmentContactItemBinding? = null
    private val binding
        get() = _binding!!

    fun newInstance(contact: ContactsInfo): ContactItemFragment {
        val args = Bundle().apply {
            putParcelable(CONTACT_KEY, contact)
        }
        return ContactItemFragment().apply {
            arguments = args
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactItemBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactsInfo: ContactsInfo? = arguments?.getParcelable(CONTACT_KEY)
        if (contactsInfo != null) bindUI(contactsInfo)
    }

    private fun bindUI(contactsInfo: ContactsInfo) {

        if (contactsInfo.image != null)
            Glide.with(requireContext()).load(contactsInfo.image).circleCrop().into(binding.contactImage)
        else
            binding.contactImage.setImageResource(R.drawable.avatar)

        binding.contactName.text = contactsInfo.displayName

        binding.contactNumber.text = contactsInfo.phoneNumber
    }


    private fun urlToBitMap(context: Context, uri: String?): Bitmap? {
        var bitmap: Bitmap? = null
        if (uri != null) {
            try {
                bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, Uri.parse(uri))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return when {
            bitmap != null -> bitmap
            else -> null
        }
    }


}