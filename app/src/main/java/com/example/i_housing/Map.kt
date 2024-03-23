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
						LatLng(37.7749, -122.4194), // San Francisco coordinates
						12f // Zoom level
					)
				)
				googleMap.addMarker(
					MarkerOptions().position(LatLng(37.7749, -122.4194)).title("Marker in San Francisco")
				)
			}
		}
	})
}