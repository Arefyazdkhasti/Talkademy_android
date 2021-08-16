package com.example.talkademy_phase4.phase9

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContactsInfo(
    val contactId: String,
    val displayName:String,
    val phoneNumber :String,
    val image: String?
):Parcelable
