package com.example.i_housing.data

import android.health.connect.datatypes.DistanceRecord
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "apartments")
data class Apartment(
	@PrimaryKey(autoGenerate = true)
	val id: Long = 0,
	val name: String,
	val price: Int,
	@ColumnInfo(name = "pay_schedual")
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
	val fridge: Boolean,
	val bathroom: Int,
	val latitude: Double,
	val longitude: Double
)