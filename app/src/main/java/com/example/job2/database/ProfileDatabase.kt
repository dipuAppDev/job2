package com.example.userprofileregistration.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.job2.ProfileDao
import com.example.job2.Profile

@Database(entities = [Profile::class], version = 1, exportSchema = false)
abstract class ProfileDatabase : RoomDatabase() {
    abstract fun getDao() : ProfileDao
    companion object{
        private var INSTANCE:ProfileDatabase?=null
        fun initDatabase(context: Context) : ProfileDatabase{
            val instance = Room.databaseBuilder(
                context.applicationContext,
                ProfileDatabase::class.java,
                "profile_database"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}