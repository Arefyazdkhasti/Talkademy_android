package com.example.talkademy_phase4.phase7.dataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountrySite(
    val image:String,
    val content:String
):Parcelable
