package com.example.i_housing.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.i_housing.getDistanceToCampus
import kotlinx.coroutines.runBlocking

@Database(entities = [Apartment::class], version = 2, exportSchema = false)
abstract class ApartmentDatabase : RoomDatabase(){
    abstract fun apartmentDao() : ApartmentDao
    fun provideDatabase(
        context: Context
    ) = Room.databaseBuilder(
        context,
        ApartmentDatabase ::class.java,
        "housing.db"
    ).createFromAsset("database/housing.db").build()

    fun populateDatabase() {
        // Create each apartment
        val apartmentList = mutableListOf<Apartment>()

// Row 1
        apartmentList.add(
            Apartment(
                apartmentName = "Nauvoo House",
                price = 1400,
                website = "https://nauvoohouse.com/floor-plan/",
                phoneNumber = "208-356-7756",
                latitude = 43.8154733208062,
                longitude = -111.78859561542416,
                distanceToCampus = getDistanceToCampus(43.8154733208062, -111.78859561542416),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

// Row 2
        apartmentList.add(
            Apartment(
                apartmentName = "Alpine Chalet",
                price = 999,
                website = "https://alpinechaletrexburg.com",
                phoneNumber = "208-356-9282",
                latitude = 43.81625054367278,
                longitude = -111.79029486145178,
                distanceToCampus = getDistanceToCampus(43.81625054367278, -111.79029486145178),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

// Row 3
        apartmentList.add(
            Apartment(
                apartmentName = "Birch Plaza",
                price = 999,
                website = "https://birchplazarexburg.com/",
                phoneNumber = "208-356-8200",
                latitude = 43.82100549387679,
                longitude = -111.7892695633009,
                distanceToCampus = getDistanceToCampus(43.82100549387679, -111.7892695633009),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

// Row 4
        apartmentList.add(
            Apartment(
                apartmentName = "Bunkhouse Apartments",
                price = 895,
                website = "https://bunkhouseapts.com/",
                phoneNumber = "208-356-7419",
                latitude = 43.81810617334444,
                longitude = -111.78847657679422,
                distanceToCampus = getDistanceToCampus(43.81810617334444, -111.78847657679422),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 0,
                bathroom = 1
            )
        )

// Row 5
        apartmentList.add(
            Apartment(
                apartmentName = "Kensington Manor",
                price = 1175,
                website = "https://kensingtonmanorrexburg.com/",
                phoneNumber = "208-356-7419",
                latitude = 43.81892887759545,
                longitude = -111.77771078843773,
                distanceToCampus = getDistanceToCampus(43.81892887759545,-111.77771078843773),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 0,
                bathroom = 1
            )
        )

// Row 6
        apartmentList.add(
            Apartment(
                apartmentName = "The Cove",
                price = 1775,
                website = "https://rexburgcove.com/",
                phoneNumber = "208-701-4212",
                latitude = 43.82133661163116,
                longitude = -111.79031410378015,
                distanceToCampus = getDistanceToCampus(43.82133661163116, -111.79031410378015),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

// Row 7
        apartmentList.add(
            Apartment(
                apartmentName = "Brooklyn Apartments",
                price = 995,
                website = "https://brooklynapts.net/new/property/1",
                phoneNumber = "208-356-9500",
                latitude = 43.8188614269481,
                longitude = -111.78938375072218,
                distanceToCampus = getDistanceToCampus(43.8188614269481, -111.78938375072218),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 0,
                bathroom = 1
            )
        )

// Row 8
        apartmentList.add(
            Apartment(
                apartmentName = "Towers II",
                price = 1199,
                website = "https://www.thetowerstwo.com/",
                phoneNumber = "208-390-3706",
                latitude = 43.81560637021052,
                longitude = -111.79349003261612,
                distanceToCampus = getDistanceToCampus(43.81560637021052, -111.79349003261612),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 0,
                bathroom = 1
            )
        )

// Row 9
        apartmentList.add(
            Apartment(
                apartmentName = "The Lodge",
                price = 1429,
                website = "https://rexburglodge.com/",
                phoneNumber = "208-356-5638",
                latitude = 43.82436756208896,
                longitude = -111.79202613756797,
                distanceToCampus = getDistanceToCampus(43.82436756208896, -111.79202613756797),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

// Row 10
        apartmentList.add(
            Apartment(
                apartmentName = "The Landing",
                price = 1370,
                website = "https://www.thelandingrexburg.com/",
                phoneNumber = "208-356-9560",
                latitude = 43.82605765222345,
                longitude = -111.79612139235658,
                distanceToCampus = getDistanceToCampus(43.82605765222345, -111.79612139235658),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

// Row 11
        apartmentList.add(
            Apartment(
                apartmentName = "American Avenue",
                price = 1150,
                website = "https://www.myamericanave.com/",
                phoneNumber = "208-356-5097",
                latitude = 43.82286816635875,
                longitude = -111.77931590987531,
                distanceToCampus = getDistanceToCampus(43.82286816635875, -111.77931590987531),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

// Row 12
        apartmentList.add(
            Apartment(
                apartmentName = "Avonlea",
                price = 1175,
                website = "https://rexburgstudenthousing.com/new/property/13",
                phoneNumber = "208-359-0920",
                latitude = 43.8196009700497,
                longitude = -111.78917690378022,
                distanceToCampus = getDistanceToCampus(43.8196009700497, -111.78917690378022),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

// Row 13
        apartmentList.add(
            Apartment(
                apartmentName = "North Point",
                price = 1545,
                website = "https://www.northpointrexburg.com/",
                phoneNumber = "208-681-9542",
                latitude = 43.82260939767552,
                longitude = -111.78646463446522,
                distanceToCampus = getDistanceToCampus(43.82260939767552, -111.78646463446522),
                gym = true,
                hotTub = false,
                clubHouse = true,
                washerDryer = true,
                fridge = 1,
                bathroom = 1
            )
        )

        //Insert each apartment into the database
        apartmentList.forEach {apartment ->
            runBlocking {
                if (!apartmentDao().apartmentExists(apartment.apartmentName)) {
                    apartmentDao().insertApartment(apartment)
                }
            }
        }
    }
}

