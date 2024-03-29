package com.example.i_housing.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ApartmentDao {
@Query("select * from Apartment")
suspend fun GetAll(): List<Apartment>

@Query("select * from apartment order by price asc")
suspend fun SortLowToHigh() : List<Apartment>

@Query("select * from apartment order by price desc")
suspend fun SortHighToLow(): List<Apartment>

@Query("select * from apartment where price between :low_price and :high_price")
suspend fun SortPriceRange(low_price: Int,high_price: Int): List<Apartment>

@Query("SELECT * FROM apartment ORDER BY gym DESC")
suspend fun HasGym(): List<Apartment>

@Query("SELECT * FROM apartment ORDER BY hot_tub DESC")
suspend fun HasHotTub(): List<Apartment>

@Query("SELECT * FROM apartment ORDER BY club_house DESC")
suspend fun HasClubHouse(): List<Apartment>

@Query("SELECT * FROM apartment ORDER BY washer_dryer DESC")
suspend fun HasWasherDryer(): List<Apartment>

@Query("SELECT * FROM apartment ORDER BY fridge DESC")
suspend fun FridgeNumber(): List<Apartment>

@Query("SELECT * FROM apartment ORDER BY bathroom DESC")
suspend fun BathroomNumber(): List<Apartment>
}



