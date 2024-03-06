package com.example.job2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.userprofileregistration.database.ProfileDatabase

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
val repo : ProfileRepo
init {
    val dao = ProfileDatabase.initDatabase(application).getDao()
    repo = ProfileRepo(dao)
}
    fun insertProfile(profile: Profile){
        repo.insertProfile(profile)
    }
    fun deleteProfile(profile: Profile){
        repo.deleteProfile(profile)
    }
    fun getAllProfile() : LiveData<List<Profile>>{
        return repo.getAllProfile()
    }
    fun updateProfile(newName:String,newAddress:String,newCity:String,newId:Int){
        repo.updateProfile(newName,newAddress,newCity,newId)
    }
}