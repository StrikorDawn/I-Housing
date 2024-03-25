import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun MapApartments(navController: NavController) {
	val context = LocalContext.current as ComponentActivity

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
				googleMap.addMarker(
					MarkerOptions()
						.position(LatLng(43.8219, -111.7797)) // Example coordinates for an apartment
						.title("Student Apartment 1")
				)
				googleMap.addMarker(
					MarkerOptions()
						.position(LatLng(43.8203, -111.7815)) // Example coordinates for another apartment
						.title("Student Apartment 2")
				)
			}
		}
	})
}