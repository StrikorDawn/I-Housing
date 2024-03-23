package com.example.i_housing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import androidx.room.Room

class Main : ComponentActivity() {
//	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val db = Room.databaseBuilder(
			applicationContext,
			ApartmentDatabase::class.java, "db").build()
		setContent {
			val navController = rememberNavController()
			Scaffold (
				floatingActionButton = {
					FloatingActionButton(onClick = {
						navController.navigate("filter")
					}) {
						Icon(Icons.Default.Search, contentDescription = "Search Filters")
					}
				},
				topBar = {
					Row (
						modifier = Modifier.fillMaxWidth().background(Color.Blue)
					){
						var searchText = ""
						TextField(
							modifier = Modifier.fillMaxWidth(),
							placeholder = {
								Text(text = "Search Results...")
							},
							value = searchText,
							onValueChange = { text ->
								searchText = text
							})
					}
				},
				bottomBar = {
					BottomNavigationBar(
						items = listOf(
							BottomNavItem(
								name = "Map",
								route = "map",
								icon = Icons.Default.Place
							),
							BottomNavItem(
								name = "List",
								route = "list",
								icon = Icons.Default.Menu
							)
						),
						navController = navController,
						modifier = Modifier.background(Color.Blue),
						onItemClick = {
							navController.navigate(it.route)
						}
					)
				}
			) {paddingValue ->
				Surface (
					modifier = Modifier
						.padding(paddingValue)
						.fillMaxSize(),
					color = Color.White
				){
					Navigation(navController = navController, db)
				}
			}
		}
	}
}
