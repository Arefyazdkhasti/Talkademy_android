package com.example.talkademy_phase4.phase7.dataClass

import android.os.Parcelable
import com.example.talkademy_phase4.phase7.enumerian.Continent
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: String,
    val continent: Continent,
    val list: List<CountrySite>
): Parcelable
