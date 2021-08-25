package com.example.talkademy_phase4.phase10.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.talkademy_phase4.R
import com.example.talkademy_phase4.databinding.ActivityPhase10Binding
import com.example.talkademy_phase4.phase10.util.DataListener
import com.example.talkademy_phase4.phase10.util.EditTextListener


class Phase10Activity : AppCompatActivity(), EditTextListener {

    private lateinit var binding: ActivityPhase10Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhase10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        bindUI()

    }

    private fun bindUI() {

        binding.sendBtn.setOnClickListener {
            val fragment = this.supportFragmentManager.findFragmentById(R.id.FragmentContainerView1)
            (fragment as DataListener).sendData()
        }
    }

    override fun isEdtEmpty(isEmpty: Boolean) {
        println(isEmpty)
        binding.isEmpty = isEmpty
        if (isEmpty) {
            binding.sendBtn.apply {
//                isClickable = false
//                isEnabled = false
                setBackgroundColor(ContextCompat.getColor(context.applicationContext, R.color.silver))
            }
        } else {
            binding.sendBtn.apply {
//                isClickable = true
//                isEnabled = true
                setBackgroundColor(ContextCompat.getColor(context.applicationContext, R.color.blue))
            }
        }
    }

}