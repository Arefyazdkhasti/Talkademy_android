package com.example.talkademy_phase4.phase5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    companion object{
        const val DATA_KEY = "data"
        const val ANSWER_KEY = "answer"
        const val NO_DATA_RECEIVED =  "No data received"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)

        setContentView(binding.root)

        bindUI()

        getAnswer()
    }

    private fun bindUI() {
        val sendText = binding.sampleSendText.text as String

        binding.sendBtn.setOnClickListener {
            sendDataToSecondActivity(sendText)
        }
    }

    private fun sendDataToSecondActivity(data:String) {
        val intent = Intent(this,DestinationActivity::class.java)
        intent.putExtra(DATA_KEY,data)
        startActivity(intent)
    }

    private fun getAnswer() {
        val answer = intent.getStringExtra(ANSWER_KEY)
        if (answer != null)
            Toast.makeText(this,answer, Toast.LENGTH_SHORT).show()
    }
}