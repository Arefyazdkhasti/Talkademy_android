package com.example.talkademy_phase4.phase7.util

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.talkademy_phase4.R

class UIUtils {
    companion object{
        fun loadFragment(activity: AppCompatActivity,fragment: Fragment, tag: String) {
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.country_setting_fragment_container_view, fragment, tag)
                .addToBackStack(tag)
                .commit()
        }

        fun showToast(context: Context,content:String){
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
        }
    }
}