package com.example.i_housing.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Apartment")
data class Apartment(
	@PrimaryKey(autoGenerate = true) val id: Long = 0,
	@ColumnInfo(name = "apartment_name") var apartment_name: String,
	val price: Int,
	@ColumnInfo(name = "pay_schedule")
	val paySchedule: String,
	val website: String,
	@ColumnInfo(name = "phone_number")
	val phoneNumber: String,
	@ColumnInfo(name = "distance_to_campus")
	val distanceToCampus: String,
	val gym: Boolean,
	@ColumnInfo(name = "hot_tub")
	val hotTub: Boolean,
	@ColumnInfo(name = "club_house")
	val clubHouse: Boolean,
	@ColumnInfo(name = "washer_dryer")
	val washerDryer: Boolean,
	val fridge: String,
	val bathroom: String
)

//data class Apartment(
//	val name : String,
//	val single : Boolean,
//	val price : Float,
//	val semester: Boolean,
//	val distanceFromCampus: Float,
//	val amenities : List<String>,
//	val link : String,
//	val phoneNumber : String
//)

