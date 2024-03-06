package com.example.job2

import androidx.lifecycle.LiveData
import com.example.job2.ProfileDao
import com.example.job2.Profile

class ProfileRepo(val dao: ProfileDao) {
    fun insertProfile(profile: Profile){
        dao.insertProfile(profile)
    }
    fun deleteProfile(profile: Profile){
        dao.deleteProfile(profile)
    }
    fun getAllProfile() : LiveData<List<Profile>>{
        return dao.getAllProfile()
    }
    fun updateProfile(newName:String,newAddress:String,newCity:String,newId:Int){
        dao.updateProfile(newName,newAddress,newCity,newId)
    }
}