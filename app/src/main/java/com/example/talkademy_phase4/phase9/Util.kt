package com.example.talkademy_phase4.phase9

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.phase7.fragments.REQUEST_CONTINENTS

class Util {
    companion object {

        fun launchItemFragment(fragment: Fragment, contact: ContactsInfo,tag:String) {
            println(contact.displayName)
            val newFragment = ContactItemFragment().newInstance(contact)
            newFragment.setTargetFragment(fragment, REQUEST_CONTINENTS)
            if (ContactActivity.isTowPain)
                loadFragmentTowPanel(fragment.requireActivity() as AppCompatActivity,newFragment)
            else
                loadFragmentSinglePanel(fragment.requireActivity() as AppCompatActivity,newFragment,tag)
        }


        private fun loadFragmentSinglePanel(activity: AppCompatActivity, fragment: Fragment, tag: String) {
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.contact_fragment_container, fragment, tag)
                .addToBackStack(tag)
                .commit()
        }

        private fun loadFragmentTowPanel(activity: AppCompatActivity, fragment: Fragment) {
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.contact_item_fragment_container, fragment)
                .commit()
        }

        fun showToast(context: Context,content:String){
            Toast.makeText(
                context,
                content,
                Toast.LENGTH_LONG
            ).show()
        }

    }
}