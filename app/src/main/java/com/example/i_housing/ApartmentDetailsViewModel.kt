package com.example.i_housing

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ApartmentDao {
@Query("select * from apartment")
fun GetAll(): List<aprtment>

@Query("select * from apartment where price order by low_price")
fun SortLowToHigh() : List<apartment>

@Query("select * from apartment where price order by low_price")
fun SortHighToLow(): List<apartment>

@Query("select * from apartment where price between low_price and high_price")
fun SortPriceRange(): List<apartment>
}