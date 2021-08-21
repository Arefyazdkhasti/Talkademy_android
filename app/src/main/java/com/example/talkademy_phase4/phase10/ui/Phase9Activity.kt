package com.example.talkademy_phase4.phase10.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talkademy_phase4.databinding.ActivityPhase9Binding
import com.example.talkademy_phase4.phase10.ui.getText.GetTextFragment

class Phase9Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPhase9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhase9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        bindUI()

    }

    private fun bindUI() {
        binding.sendBtn.setOnClickListener {

        }
    }
}