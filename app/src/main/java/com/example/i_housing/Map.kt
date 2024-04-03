
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.i_housing.data.Apartment
import com.example.i_housing.data.ApartmentDatabase
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.runBlocking

// The Apartment Marker object holds latitude and longitude and title of marker
class AptMarker(lat: Double, lng:Double,title:String, id:String){
	val Lat = lat
	val Lng = lng
	val Title = title
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapApartments(db: ApartmentDatabase) {
	val context = LocalContext.current as ComponentActivity

	// Instantiates the DAO interface and populates the apartment and markerlist from the database
	var apartmentDao = db.apartmentDao()
	var apartments by remember {
		mutableStateOf(listOf<Apartment>())
	}
	var markerList  by remember {
		mutableStateOf(listOf<AptMarker>())
	}
	runBlocking {
		apartments = apartmentDao.GetAll()
		var tempList = mutableListOf<AptMarker>()
		apartments.forEach {apartment ->
			tempList.add(AptMarker(
				apartment.latitude,
				apartment.longitude,
				apartment.apartmentName,
				apartment.id.toString()
			))
		}
		markerList = tempList
	}

	// Variable for the current apartment clicked
	var aptClicked : Apartment by remember {
		mutableStateOf(apartments.get(0))
	}

	// Define bottom sheetstate for map view
	val sheetState = rememberModalBottomSheetState()
	var showBottomSheet by remember {
		mutableStateOf(false)
	}

	AndroidView(factory = { context ->
		MapView(context).apply {
			// Ensure the MapView receives the appropriate lifecycle events
			onCreate(Bundle())
			getMapAsync { googleMap ->
				// Manipulate the map when it's ready
				googleMap.moveCamera(
					CameraUpdateFactory.newLatLngZoom(
						LatLng(43.8141, -111.7850), // Coordinates for BYU-Idaho in Rexburg
						14f // Zoom level
					)
				)

				// loops iterates through list of apartments and creates markers for
				// each to be added to the map
				for (i in markerList) {
					googleMap.addMarker(
					MarkerOptions()
						.position(LatLng(i.Lat, i.Lng)) // Example coordinates for another apartment
						.title(i.Title)
				)
				}

				// Creates a listener for when a user clicks a marker
				googleMap.setOnMarkerClickListener { marker ->
					// Displays the bottom Sheet, and sets the apt clicked to the apt marker they clicked
					showBottomSheet = true
					runBlocking {
						aptClicked = marker.title.let {
							apartmentDao.getApartmentByName(it!!)!!
						}
					}

					// Get the lat/long from the marker, query the database for the apartment with that address and return the details to the bottom sheet
					true
				}
			}
		}
	})

	// Display apartment details in bottom sheet if a user has clicked an apartment
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
				//Displays all text details for the apartment, to be integrated with map markers
				Text(text = "Apartment Details: ${aptClicked?.apartmentName}", textAlign = TextAlign.Center, fontSize = 16.sp)
				Text(text = "Phone Number: ${aptClicked?.phoneNumber}", fontSize = 16.sp)
				Text(text = "Website: ${aptClicked?.website}", fontSize = 16.sp)
				Text(text = "Bathrooms: ${aptClicked?.bathroom}", fontSize = 16.sp)
				Text(text = "Fridges: ${aptClicked?.fridge}", fontSize = 16.sp)
				Row {
					Text(text = "Washer/Dryer: ", fontSize = 16.sp)
					if (aptClicked?.washerDryer == true) {
						Icon(imageVector = Icons.Default.Check, contentDescription = null)
					} else {
						Icon(imageVector = Icons.Default.Clear, contentDescription = null)
					}
				}
				Row {
					Text(text = "Gym: ", fontSize = 16.sp)
					if (aptClicked?.gym == true) {
						Icon(imageVector = Icons.Default.Check, contentDescription = null)
					} else {
						Icon(imageVector = Icons.Default.Clear, contentDescription = null)
					}
				}
				Row {
					Text(text = "Clubhouse: ", fontSize = 16.sp)
					if (aptClicked?.clubHouse == true) {
						Icon(imageVector = Icons.Default.Check, contentDescription = null)
					} else {
						Icon(imageVector = Icons.Default.Clear, contentDescription = null)
					}
				}
				Row {
					Text(text = "Hot Tub: ", fontSize = 16.sp)
					if (aptClicked?.hotTub == true) {
						Icon(imageVector = Icons.Default.Check, contentDescription = null)
					} else {
						Icon(imageVector = Icons.Default.Clear, contentDescription = null)
					}
				}
			}
		}
	}
}