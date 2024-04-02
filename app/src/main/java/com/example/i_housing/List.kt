package com.example.i_housing

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.i_housing.data.Apartment
import com.example.i_housing.data.ApartmentDatabase
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListApartments(database: ApartmentDatabase) {
	var apartmentDao = database.apartmentDao()
//	var filterDao = database.filterDao()
	val sheetState = rememberModalBottomSheetState()
	var showBottomSheet by remember {
		mutableStateOf(false)
	}
	var filterArguments by remember {
		mutableStateOf(listOf<Any>())
	}
	runBlocking {
//		filterArguments = filterDao.getAll()
	}
	var apartments by remember {
		mutableStateOf(listOf<Apartment>())
	}
	runBlocking {
		apartments = apartmentDao.GetAll()
	}
//	val testApartment: Apartment = Apartment(0, "Test Apartment", 1300, "", "", "", "0.5mi", false, true, false, true, "2", "2")
//	val testApartment2: Apartment = Apartment(0, "Another Apartment", 1100, "", "", "", "1.3mi", false, true, false, true, "1", "2")
//	apartments = apartments + testApartment + testApartment2

	LazyColumn (
		modifier = Modifier.fillMaxHeight()
	){
		items(apartments) { apartment ->
			Box (
				modifier = Modifier
					.padding(5.dp)
					.fillMaxWidth()
					.clip(RoundedCornerShape(10.dp))
					.clickable {
						showBottomSheet = true
					}
			) {
				Row (
					modifier = Modifier
						.fillMaxWidth()
						.padding(10.dp)

				){
					Column (
						modifier = Modifier.weight(1f)
					){
						Text(
							text = apartment.apartmentName,
							fontSize = 20.sp,
						)
						Text(text = "Distance to campus: ${getDistanceToCampus(apartment.latitude, apartment.longitude)}")
					}
					Text(text = "$${apartment.price.toString()}", fontSize = 20.sp)
				}
			}
			HorizontalDivider()
			if (showBottomSheet) {
				ModalBottomSheet(
					onDismissRequest = {
						showBottomSheet = false
					},
					sheetState = sheetState,
				) {
					Column(
						modifier = Modifier
							.fillMaxWidth()
							.padding(10.dp)
					){
						Text(text = "Apartment Details: ${apartment.apartmentName}", textAlign = TextAlign.Center, fontSize = 16.sp)
						Text(text = "Phone Number: ${apartment.phoneNumber}", fontSize = 16.sp)
						Text(text = "Website: ${apartment.website}", fontSize = 16.sp)
						Text(text = "Bathrooms: ${apartment.bathroom}", fontSize = 16.sp)
						Text(text = "Fridges: ${apartment.fridge}", fontSize = 16.sp)
						Row {
							Text(text = "Washer/Dryer: ", fontSize = 16.sp)
							if (apartment.washerDryer) {
								Icon(imageVector = Icons.Default.Check, contentDescription = null)
							} else {
								Icon(imageVector = Icons.Default.Clear, contentDescription = null)
							}
						}
						Row {
							Text(text = "Gym: ", fontSize = 16.sp)
							if (apartment.gym) {
								Icon(imageVector = Icons.Default.Check, contentDescription = null)
							} else {
								Icon(imageVector = Icons.Default.Clear, contentDescription = null)
							}
						}
						Row {
							Text(text = "Clubhouse: ", fontSize = 16.sp)
							if (apartment.clubHouse) {
								Icon(imageVector = Icons.Default.Check, contentDescription = null)
							} else {
								Icon(imageVector = Icons.Default.Clear, contentDescription = null)
							}
						}
						Row {
							Text(text = "Hot Tub: ", fontSize = 16.sp)
							if (apartment.hotTub) {
								Icon(imageVector = Icons.Default.Check, contentDescription = null)
							} else {
								Icon(imageVector = Icons.Default.Clear, contentDescription = null)
							}
						}
					}
				}
			}
		}
	}
}