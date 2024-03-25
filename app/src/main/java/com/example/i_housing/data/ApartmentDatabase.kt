package com.example.i_housing.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Apartment::class], version = 1)
abstract class ApartmentDatabase : RoomDatabase(){
    abstract fun apartmentDao() : ApartmentDao
}