package com.example.i_housing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.i_housing.data.ApartmentDatabase
import com.example.i_housing.navigation.BottomNavItem
import com.example.i_housing.navigation.BottomNavigationBar
import com.example.i_housing.navigation.Navigation

class Main : ComponentActivity() {
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		// Create singleton instance of the room database object
		val db = Room.databaseBuilder(
		applicationContext,
		ApartmentDatabase::class.java, "db").build()

		//Populate the Database with apartment listings
		db.populateDatabase()

		// Display Composables in UI using a scaffold and navcontroller
		setContent {
			val navController = rememberNavController()
			Scaffold (
				// Create a floating button to access search filter screen
				floatingActionButton = {
					FloatingActionButton(onClick = {
						navController.navigate("filter")
					}) {
						Icon(Icons.Default.Search, contentDescription = "Search Filters")
					}
				},
				// Create a bottom nav bar to navigate between screens
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
				// Create a surface using the scaffolding padding
				Surface (
					modifier = Modifier
						.padding(paddingValue)
						.fillMaxSize(),
					color = Color.White
				){
					// Run the Navigation composable, that displays various screens depending on current destination
					Navigation(navController = navController, db)
				}
			}
		}
	}
}
