package com.example.i_housing.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Apartment::class], version = 1)
abstract class ApartmentDatabase : RoomDatabase() {
    abstract fun apartmentDao(): ApartmentDao

    companion object {
        @Volatile
        private var INSTANCE: ApartmentDatabase? = null

        fun getDatabase(context: Context): ApartmentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ApartmentDatabase::class.java,
                    "apartment_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

