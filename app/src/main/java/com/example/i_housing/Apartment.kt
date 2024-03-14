package com.example.i_housing

// Apartment class representing individual apartments
data class Apartment(
	val number: Int,
	val bedrooms: Int,
	val bathrooms: Int,
	val squareFeet: Double,
	var rent: Double,
	val amenities: List<String>
) {
	// Method to calculate the price per square foot
	fun calculatePricePerSquareFoot(): Double {
		return rent / squareFeet
	}

	// Method to display apartment details
	fun displayDetails() {
		println("Apartment $number Details:")
		println("Bedrooms: $bedrooms")
		println("Bathrooms: $bathrooms")
		println("Square Feet: $squareFeet sq.ft")

		val amenitiesList = amenities.joinToString(", ")
		println("Amenities: $amenitiesList")

		println("Rent: $${"%.2f".format(rent)}")
		println("Price per Square Foot: $${"%.2f".format(calculatePricePerSquareFoot())}")
		println()
	}
}