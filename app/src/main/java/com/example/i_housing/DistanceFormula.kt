package com.example.i_housing

import kotlin.math.*

fun getDistanceBetweenPoints(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
    val R = 6371 // Earth radius in kilometers

    val dLat = Math.toRadians(lat2 - lat1)
    val dLon = Math.toRadians(lon2 - lon1)
    val lat1Rad = Math.toRadians(lat1)
    val lat2Rad = Math.toRadians(lat2)

    val a = sin(dLat / 2) * sin(dLat / 2) +
            sin(dLon / 2) * sin(dLon / 2) * cos(lat1Rad) * cos(lat2Rad)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    val distanceInKM =  R * c
    val distanceInMiles = distanceInKM * 0.621371
    return distanceInMiles
}

fun getDistanceToCampus(lat: Double, lon: Double): Double {
    val R = 6371 // Earth radius in kilometers
    val campusLat = 43.8145
    val campusLon = 111.7833
    val dLat = Math.toRadians(campusLat - lat)
    val dLon = Math.toRadians(campusLon - lon)
    val lat1Rad = Math.toRadians(lat)
    val lat2Rad = Math.toRadians(campusLat)

    val a = sin(dLat / 2) * sin(dLat / 2) +
            sin(dLon / 2) * sin(dLon / 2) * cos(lat1Rad) * cos(lat2Rad)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    val distanceInKM =  R * c
    val distanceInMiles = distanceInKM * 0.621371
    return distanceInMiles
}