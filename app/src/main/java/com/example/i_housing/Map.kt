import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.forEach
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AptMarker(lat: Double, lng:Double,title:String, id:String){
	val Lat = lat
	val Lng = lng
	val Title = title
	val Id = id
}

@Composable
fun MapApartments(navController: NavController) {
	val context = LocalContext.current as ComponentActivity
	val markerList = mutableListOf(AptMarker(43.8219, -111.7797,"Student Apartment 1", "000"),AptMarker(43.8203, -111.7815,"Student Apartment 2","001"),
		AptMarker(43.83, -111.76,"Student Apartment 3","010"))


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
			}
		}
	})
}