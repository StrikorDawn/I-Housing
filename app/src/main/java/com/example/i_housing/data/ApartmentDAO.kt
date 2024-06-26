package com.example.i_housing.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// DAO Interface defines how kotlin methods are constructed to run SQL code in the room database

@Dao
interface ApartmentDao {

    // Gets arguments from the Filter table and returns each apartment that matches those arguments
    @Query(
        "SELECT * " +
        "FROM apartments " +
        "WHERE price BETWEEN :minPrice AND :maxPrice " +
        "AND distance_to_campus BETWEEN :minDistance AND :maxDistance " +
        "AND bathroom BETWEEN :minBath AND :maxBath " +
        "AND fridge BETWEEN :minFridge AND :maxFridge " +
        "AND hot_tub = :hasHottub " +
        "AND gym = :hasGym " +
        "AND club_house = :hasClubhouse " +
        "AND washer_dryer = :hasWasher"
    )
    suspend fun getFilteredApartments(
        minPrice: Int, maxPrice: Int,
        minDistance: Double, maxDistance: Double,
        minBath: Int, maxBath: Int,
        minFridge: Int, maxFridge: Int,
        hasWasher: Boolean,
        hasClubhouse: Boolean,
        hasGym: Boolean,
        hasHottub: Boolean
    ) : List<Apartment>

    // Inserts a new apartment into the database
    @Insert
    suspend fun insertApartment(apartment: Apartment)

    // Returns an apartment matching the name passed if it exists in the database
    @Query(
        "SELECT * FROM apartments WHERE name = :name"
    )
    suspend fun getApartmentByName(name: String) : Apartment?

    // Boolean that returns true if the apartments already exists in the database
    suspend fun apartmentExists(name: String): Boolean {
        val existingApartment = getApartmentByName(name)
        return existingApartment != null
    }

    // Returns a List of every apartment in the database
    @Query("select * from apartments")
    suspend fun GetAll(): List<Apartment>

@Query("select * from apartments order by price asc")
suspend fun SortLowToHigh() : List<Apartment>

@Query("select * from apartments order by price desc")
suspend fun SortHighToLow(): List<Apartment>

@Query("select * from apartments where price between :low_price and :high_price")
suspend fun SortPriceRange(low_price: Int,high_price: Int): List<Apartment>

@Query("SELECT * FROM apartments ORDER BY gym DESC")
suspend fun HasGym(): List<Apartment>

@Query("SELECT * FROM apartments ORDER BY hot_tub DESC")
suspend fun HasHotTub(): List<Apartment>

@Query("SELECT * FROM apartments ORDER BY club_house DESC")
suspend fun HasClubHouse(): List<Apartment>

@Query("SELECT * FROM apartments ORDER BY washer_dryer DESC")
suspend fun HasWasherDryer(): List<Apartment>

@Query("SELECT * FROM apartments ORDER BY fridge DESC")
suspend fun FridgeNumber(): List<Apartment>

@Query("SELECT * FROM apartments ORDER BY bathroom DESC")
suspend fun BathroomNumber(): List<Apartment>
}



