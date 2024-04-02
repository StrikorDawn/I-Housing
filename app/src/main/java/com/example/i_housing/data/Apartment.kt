package com.example.i_housing.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Defines how the apartment data class in kotlin is mapped to a schema table 'apartments'
@Entity(tableName = "apartments")
data class Apartment(
	@PrimaryKey(autoGenerate = true)
	val id: Int = 0,
	@ColumnInfo(name = "name")
	val apartmentName: String,
	@ColumnInfo(name = "price")
	val price: Int,
	@ColumnInfo(name = "website")
	val website: String,
	@ColumnInfo(name = "phone_number")
	val phoneNumber: String,
	@ColumnInfo(name = "latitude")
	val latitude: Double,
	@ColumnInfo(name = "longitude")
	val longitude: Double,
	@ColumnInfo(name = "distance_to_campus")
	val distanceToCampus : Double,
	@ColumnInfo(name = "gym")
	val gym: Boolean,
	@ColumnInfo(name = "hot_tub")
	val hotTub: Boolean,
	@ColumnInfo(name = "club_house")
	val clubHouse: Boolean,
	@ColumnInfo(name = "washer_dryer")
	val washerDryer: Boolean,
	@ColumnInfo(name = "fridge")
	val fridge: Int,
	@ColumnInfo(name = "bathroom")
	val bathroom: Int
)