package com.example.i_housing

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

class Main : ComponentActivity() {
//	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			val navController = rememberNavController()
			Scaffold (
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
						modifier = Modifier,
						onItemClick = {
							navController.navigate(it.route)
						}
					)
				}
			) {
				Navigation(navController = navController)
			}
		}
	}
}
