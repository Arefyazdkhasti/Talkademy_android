package com.example.talkademy_phase4.phase10.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val content = MutableLiveData<CharSequence>()
}