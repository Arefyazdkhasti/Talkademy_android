package com.example.talkademy_phase4.phase6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talkademy_phase4.databinding.ActivityPhase6Binding

class Phase6Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPhase6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPhase6Binding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}