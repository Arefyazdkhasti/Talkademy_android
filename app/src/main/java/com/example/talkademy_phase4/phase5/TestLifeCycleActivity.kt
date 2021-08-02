package com.example.talkademy_phase4.phase5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.talkademy_phase4.R

private const val LOG_LIFE_CYCLE = "lifecycle"


class TestLifeCycleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_life_cycle)
        Log.i(LOG_LIFE_CYCLE, "onCreate called")
        showToast("onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(LOG_LIFE_CYCLE, "onRestart called")
        showToast("onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_LIFE_CYCLE, "onResume called")
        showToast("onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_LIFE_CYCLE, "onPause called")
        showToast("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_LIFE_CYCLE, "onDestroy called")
        showToast("onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_LIFE_CYCLE, "onStart called")
        showToast("onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_LIFE_CYCLE, "onStop called")
        showToast("onStop")
    }


    private fun showToast(text:String){
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }


}