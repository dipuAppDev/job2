package com.example.job2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profile: Profile)
    @Delete
    fun deleteProfile(profile: Profile)
    @Query("SELECT * FROM profile_table ORDER BY id DESC")
    fun getAllProfile() : LiveData<List<Profile>>
    @Query("UPDATE profile_table SET name = :newName,address = :newAddress,city = :newCity WHERE id = :newId")
    fun updateProfile(newName:String,newAddress:String,newCity:String,newId:Int)
}