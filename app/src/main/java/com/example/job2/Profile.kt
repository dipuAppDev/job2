package com.example.job2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    var id:Int?,
    @ColumnInfo(name = "name")
    var name:String?=null,
    @ColumnInfo(name="address")
    var address:String?=null,
    @ColumnInfo(name="city")
    var city:String?=null
)
