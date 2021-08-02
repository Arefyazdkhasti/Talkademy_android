package com.example.talkademy_phase4.phase4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.talkademy_phase4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindUI();
    }

    private fun bindUI(){
        binding.simpleBtn.setOnClickListener {
            Toast.makeText(this,"Hello Talkademy",Toast.LENGTH_SHORT).show()
        }
    }
}