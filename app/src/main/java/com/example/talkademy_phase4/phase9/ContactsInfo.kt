package com.example.talkademy_phase4.phase9

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "contacts")
@Parcelize
data class ContactsInfo(
    @PrimaryKey(autoGenerate = false)
    val contactId: String,
    val displayName:String,
    val phoneNumber :String,
    val image: String?
):Parcelable
