package com.example.i_housing.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "apartments")
data class Apartment(
	@PrimaryKey(autoGenerate = true) val id: Long = 0,
	@ColumnInfo(name = "name") var apartment_name: String,
	val price: Int,
	@ColumnInfo(name = "pay_schedule")
	val paySchedule: String,
	@ColumnInfo(name = "website")
	val website: String,
	@ColumnInfo(name = "phone_number")
	val phoneNumber: String,
	@ColumnInfo(name = "distance_to_campus")
	val distanceToCampus: String,
	@ColumnInfo(name = "gym")
	val gym: Boolean,
	@ColumnInfo(name = "hot_tub")
	val hotTub: Boolean,
	@ColumnInfo(name = "club_house")
	val clubHouse: Boolean,
	@ColumnInfo(name = "washer_dryer")
	val washerDryer: Boolean,
	@ColumnInfo(name = "fridge")
	val fridge: String,
	@ColumnInfo(name = "bathroom")
	val bathroom: String
)