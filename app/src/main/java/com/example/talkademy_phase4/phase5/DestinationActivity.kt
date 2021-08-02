package com.example.talkademy_phase4.phase5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.ActivityDestinationBinding
import com.example.talkademy_phase4.phase5.StartActivity.Companion.ANSWER_KEY
import com.example.talkademy_phase4.phase5.StartActivity.Companion.DATA_KEY
import com.example.talkademy_phase4.phase5.StartActivity.Companion.NO_DATA_RECEIVED

class DestinationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDestinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDestinationBinding.inflate(layoutInflater)

        setContentView(binding.root)

        getDataFromIntent()

    }

    private fun getDataFromIntent() {
        val data = intent.getStringExtra(DATA_KEY)

        if (data != null)
            binding.sampleReceivedText.text = data
        else
            binding.sampleReceivedText.text = NO_DATA_RECEIVED

        bindUI()

    }

    private fun bindUI() {
        binding.yesBtn.setOnClickListener {
            sendData("YES")
        }
        binding.noBtn.setOnClickListener {
            sendData("NO")
        }
    }

    private fun sendData(data: String) {
        val intent = Intent(this, StartActivity::class.java)
        intent.putExtra(ANSWER_KEY, data)
        startActivity(intent)
    }

}