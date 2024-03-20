package com.example.i_housing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.runBlocking

@Composable
fun ListApartments(database: ApartmentDatabase) {
	var apartmentDao = database.apartmentDao()
	var apartments by remember {
		mutableStateOf(listOf<Apartment>())
	}
	runBlocking {
		apartments = apartmentDao.GetAll()
	}

	LazyColumn (
		modifier = Modifier.fillMaxHeight()
	){
		items(apartments) { apartment ->
			Row (
				modifier = Modifier.fillMaxWidth()
			){
				Text(text = apartment.apartment_name, fontSize = 15.sp)
				Text(text = apartment.price.toString(), fontSize = 10.sp)
			}
			HorizontalDivider()
		}
	}
	Text(text = "Apartment list goes here", textAlign = TextAlign.Center)
}

