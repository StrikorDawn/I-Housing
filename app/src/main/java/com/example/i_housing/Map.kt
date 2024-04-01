import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.core.view.forEach
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AptMarker(lat: Double, lng:Double,title:String, id:String){
	val Lat = lat
	val Lng = lng
	val Title = title
	val Id = id
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapApartments(navController: NavController) {
	val context = LocalContext.current as ComponentActivity
	val markerList = mutableListOf(AptMarker(43.8219, -111.7797,"Student Apartment 1", "000"),AptMarker(43.8203, -111.7815,"Student Apartment 2","001"),
		AptMarker(43.83, -111.76,"Student Apartment 3","010"))
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
//				googleMap.addMarker(
//					MarkerOptions()
//						.position(LatLng(43.8219, -111.7797)) // Example coordinates for an apartment
//						.title("Student Apartment 1")
//				)
//				googleMap.addMarker(
//					MarkerOptions()
//						.position(LatLng(43.8203, -111.7815)) // Example coordinates for another apartment
//						.title("Student Apartment 2")
//				)
				for (i in markerList) {
					googleMap.addMarker(
					MarkerOptions()
						.position(LatLng(i.Lat, i.Lng)) // Example coordinates for another apartment
						.title(i.Title)
				)
				}

				googleMap.setOnMarkerClickListener { marker ->
					showBottomSheet = true
					// Get the lat/long from the marker, query the database for the apartment with that address and return the details to the bottom sheet
					true
				}
			}
		}
	})

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
//				Text(text = "Apartment Details: ${apartment.apartment_name}", textAlign = TextAlign.Center, fontSize = 16.sp)
//				Text(text = "Phone Number: ${apartment.phoneNumber}", fontSize = 16.sp)
//				Text(text = "Website: ${apartment.website}", fontSize = 16.sp)
//				Text(text = "Bathrooms: ${apartment.bathroom}", fontSize = 16.sp)
//				Text(text = "Fridges: ${apartment.fridge}", fontSize = 16.sp)
//				Row {
//					Text(text = "Washer/Dryer: ", fontSize = 16.sp)
//					if (apartment.washerDryer) {
//						Icon(imageVector = Icons.Default.Check, contentDescription = null)
//					} else {
//						Icon(imageVector = Icons.Default.Clear, contentDescription = null)
//					}
//				}
//				Row {
//					Text(text = "Gym: ", fontSize = 16.sp)
//					if (apartment.gym) {
//						Icon(imageVector = Icons.Default.Check, contentDescription = null)
//					} else {
//						Icon(imageVector = Icons.Default.Clear, contentDescription = null)
//					}
//				}
//				Row {
//					Text(text = "Clubhouse: ", fontSize = 16.sp)
//					if (apartment.clubHouse) {
//						Icon(imageVector = Icons.Default.Check, contentDescription = null)
//					} else {
//						Icon(imageVector = Icons.Default.Clear, contentDescription = null)
//					}
//				}
//				Row {
//					Text(text = "Hot Tub: ", fontSize = 16.sp)
//					if (apartment.hotTub) {
//						Icon(imageVector = Icons.Default.Check, contentDescription = null)
//					} else {
//						Icon(imageVector = Icons.Default.Clear, contentDescription = null)
//					}
//				}
			}
		}
	}
}