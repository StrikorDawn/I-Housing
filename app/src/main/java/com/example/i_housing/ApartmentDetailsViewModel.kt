package com.example.i_housing

import androidx.room.Dao
import androidx.room.Query

//@Dao
//interface ApartmentDao {
//@Query("select * from apartment")
//fun GetAll(): List<aprtment>
//
//@Query("select * from apartment where price order by low_price asc")
//fun SortLowToHigh() : List<apartment>
//
//@Query("select * from apartment where price order by low_price desc")
//fun SortHighToLow(): List<apartment>
//
//@Query("select * from apartment where price between :low_price and :high_price")
//fun SortPriceRange(low_price: Int,high_price: Int): List<apartment>
//
//@Query("SELECT * FROM apartment ORDER BY gym DESC")
//fun HasGym(): List<Apartment>
//
//@Query("SELECT * FROM apartment ORDER BY hot_tub DESC")
//fun HasHotTub(): List<Apartment>
//
//@Query("SELECT * FROM apartment ORDER BY club_house DESC")
//fun HasClubHouse(): List<Apartment>
//
//@Query("SELECT * FROM apartment ORDER BY washer_dryer DESC")
//fun HasWasherDryer(): List<Apartment>
//
//@Query("SELECT * FROM apartment ORDER BY fridge DESC")
//fun FridgeNumber(): List<Apartment>
//
//@Query("SELECT * FROM apartment ORDER BY bathroom DESC")
//fun BathroomNumber(): List<Apartment>
//}
