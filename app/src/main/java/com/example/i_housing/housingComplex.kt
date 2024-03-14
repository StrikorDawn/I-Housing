package com.example.i_housing

class HousingComplex(
    val name: String,
    val location: String,
    val numberOfFloors: Int,
    val apartments: MutableList<Apartment> = mutableListOf()
) {
    // Method to add an apartment to the complex
    fun addApartment(apartment: Apartment) {
        apartments.add(apartment)
    }

    // Method to calculate the average rent of all apartments in the complex
    fun calculateAverageRent(): Double {
        val totalRent = apartments.sumOf { it.rent }
        return totalRent / apartments.size
    }

    // Method to display complex details
    fun displayDetails() {
        println("Housing Complex: $name")
        println("Location: $location")
        println("Number of Floors: $numberOfFloors")
        println("Number of Apartments: ${apartments.size}")
        println("Average Rent: $${"%.2f".format(calculateAverageRent())}")
        println()

        // Display details for each apartment in the complex
        apartments.forEach { it.displayDetails() }
    }
}

fun main() {
    // Create some apartment objects
    val apartment1 = Apartment(101, 2, 2, 1200.0, 1500.0, listOf("Balcony", "Swimming Pool"))
    val apartment2 = Apartment(202, 3, 2, 1500.0, 1800.0, listOf("Gym", "Parking"))
    val apartment3 = Apartment(303, 1, 1, 800.0, 1200.0, listOf("Laundry", "Pet Friendly"))

    // Create a housing complex and add apartments
    val housingComplex = HousingComplex("Sunny Apartments", "123 Main St", 3)
    housingComplex.addApartment(apartment1)
    housingComplex.addApartment(apartment2)
    housingComplex.addApartment(apartment3)

    // Display details of the housing complex
    housingComplex.displayDetails()
}
