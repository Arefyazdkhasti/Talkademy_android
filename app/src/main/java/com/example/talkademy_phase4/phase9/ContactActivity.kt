package com.example.talkademy_phase4.phase9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.talkademy_phase4.databinding.ActivityContactBinding


class ContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactBinding

    companion object{
        var isTowPain = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        determinePaneLayout()
    }

    override fun onRestart() {
        super.onRestart()
        determinePaneLayout()
    }

    private fun determinePaneLayout() {
        val fragmentItemDetail = binding.contactItemFragmentContainer

        isTowPain = fragmentItemDetail != null

        println(isTowPain)
    }
}