package com.example.i_housing.navigation


import MapApartments
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.i_housing.FilterApartments
import com.example.i_housing.ListApartments
import com.example.i_housing.data.ApartmentDatabase

@Composable
fun Navigation(navController: NavHostController, database: ApartmentDatabase) {
	// Define the NavHost with arguments for routes to the various screens
	NavHost(navController = navController, startDestination = Screen.ListScreen.route) {
		composable(Screen.ListScreen.route) {
			ListApartments(database)
		}
		composable(Screen.MapScreen.route) {
			MapApartments(database)
		}
		composable(Screen.FilterScreen.route) {
			FilterApartments(navController = navController)
		}
	}
}


// Bottom Navigation Bar composable to display in scaffolding.
// Takes a list of BottomNavItems to display that navigate to a screen when clicked
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
	items: List<BottomNavItem>,
	navController: NavController,
	modifier: Modifier,
	onItemClick: (BottomNavItem) -> Unit
) {
	val backStackEntry = navController.currentBackStackEntryAsState()
	NavigationBar(
		modifier = modifier,
		containerColor = Color.Blue,
		tonalElevation = 5.dp
	) {
		// Create a NavigationBarItem for each item passed to the NavBar
		items.forEach { item ->
			val selected = item.route == backStackEntry.value?.destination?.route
			NavigationBarItem(
				selected = selected,
				colors = NavigationBarItemDefaults.colors(
					selectedIconColor = Color.Blue,
					unselectedIconColor = Color.White
				),
				onClick = {
					onItemClick(item)
					navController.navigate(item.route) // Navigate to the clicked item's route
				},
				icon = {
					Column(
						horizontalAlignment = CenterHorizontally
					) {
						if (item.badgeCount > 0) {
							BadgedBox(badge = {
								Badge {
									Text(text = item.badgeCount.toString())
								}
							}) {
								Icon(
									imageVector = item.icon,
									contentDescription = item.name
								)
							}
						} else {
							Icon(
								imageVector = item.icon,
								contentDescription = item.name
							)
						}
						if (selected) {
							Text(
								text = item.name,
								textAlign = TextAlign.Center,
								fontSize = 15.sp
							)
						}
					}
				}
			)
		}
	}
}



