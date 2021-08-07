package com.example.talkademy_phase4.phase5

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.talkademy_phase4.databinding.ActivityStartBinding


const val DATA_KEY = "com.example.talkademy_phase4.data"
const val ANSWER_KEY = "com.example.talkademy_phase4.answer"
const val NO_DATA_RECEIVED = "No data received"
const val REQUEST_CODE = 1
const val RESULT_CODE = 2

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)

        setContentView(binding.root)

        bindUI()

    }

    private fun bindUI() {
        val sendText = binding.sampleSendText.text as String

        binding.sendBtn.setOnClickListener {
            sendDataToSecondActivity(sendText)
        }
    }

    private fun sendDataToSecondActivity(data: String) {
        val intent = Intent(applicationContext, DestinationActivity::class.java)
        intent.putExtra(DATA_KEY, data)
        startActivityForResult(intent, REQUEST_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                val res: Bundle? = data?.extras
                val result = res?.getString(ANSWER_KEY)

                if (!result.isNullOrEmpty())
                    Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()
            }
        }
    }
}