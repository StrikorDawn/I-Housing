package com.example.i_housing.navigation

sealed class Screen(val route: String) {
	object ListScreen : Screen("list")
	object MapScreen : Screen("map")
	object FilterScreen : Screen("filter")
}