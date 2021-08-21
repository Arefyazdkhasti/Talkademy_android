package com.example.talkademy_phase4.phase9

import androidx.room.*

@Dao
interface ContactsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(contact: ContactsInfo)

    @Delete
    fun delete(contact: ContactsInfo)

    @Query("SELECT * FROM contacts")
    fun getAllContacts():List<ContactsInfo>
}
