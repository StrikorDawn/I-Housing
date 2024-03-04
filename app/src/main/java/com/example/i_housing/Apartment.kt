package com.example.i_housing

data class Apartment(
	val name : String,
	val single : Boolean,
	val price : Float,
	val semester: Boolean,
	val distanceFromCampus: Float,
	val amenities : List<String>,
	val link : String,
	val phoneNumber : String
)