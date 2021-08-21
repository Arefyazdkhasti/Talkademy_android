package com.example.talkademy_phase4.phase9

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContactsInfo::class],version = 1)
abstract class ContactsDataBase:RoomDatabase() {

    abstract fun contactDao(): ContactsDao

    companion object {
        @Volatile
        private var instance: ContactsDataBase? = null

        fun getDatabase(context: Context): ContactsDataBase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, ContactsDataBase::class.java, "contacts.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}