package com.example.i_housing.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Apartment::class], version = 1)
abstract class ApartmentDatabase : RoomDatabase(){
    abstract fun apartmentDao() : ApartmentDao
    fun provideDatabase(
        context: Context
    ) = Room.databaseBuilder(
        context,
        ApartmentDatabase ::class.java,
        "housing.db"
    ).createFromAsset("database/housing.db").build()

}
abstract class FilterDatabase : RoomDatabase(){
    abstract fun FilterDao() : FilterDao
    fun provideDatabase(
        context: Context
    ) = Room.databaseBuilder(
        context,
        FilterDatabase ::class.java,
        "housing.db"
    ).createFromAsset("database/housing.db").build()

}

