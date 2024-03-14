package com.example.i_housing

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ListApartments(navController : NavController) {
	var text by remember {
		mutableStateOf("")
	}
	var apartment : String
	var apartmentList : List<String> = mutableListOf("Apartment 1", "Apartment 2")
	LazyColumn (
		modifier = Modifier.fillMaxHeight()
	){
		items(apartmentList) { apartment ->
			Text(text = apartment, fontSize = 15.sp)
			Divider()
		}
	}
	Text(text = "Apartment list goes here", textAlign = TextAlign.Center)
}

