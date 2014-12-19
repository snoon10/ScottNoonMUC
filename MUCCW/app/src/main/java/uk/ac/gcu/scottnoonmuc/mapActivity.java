package uk.ac.gcu.scottnoonmuc;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapActivity extends FragmentActivity {
    //sets Latitude/Longtitude locations for the 3 chosen lochs to display
    static final LatLng LOCHNESS = new LatLng(57.339682, -4.423368);
    static final LatLng LOCHLOMOND = new LatLng(56.131187, -4.629314);
    static final LatLng LOCHMORAR = new LatLng(56.959135, -5.717856);



    private GoogleMap map;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //points activity to vs_map_view layout
        setContentView(R.layout.vs_map_view);
        //sets map variable to fragment from the layout
        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap();
        //sets markers, their details and icon source
        Marker lochness = map.addMarker(new MarkerOptions()
                .position(LOCHNESS)
                .title("Loch Ness")
                .snippet("Scotland's Biggest Loch")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.ic_marker )));

        Marker lochlomond = map.addMarker(new MarkerOptions()
                .position(LOCHLOMOND)
                .title("Loch Lomond")
                .snippet("Scotlands Second Biggest Loch")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.ic_marker)));

        Marker lochmorar = map.addMarker(new MarkerOptions()
                .position(LOCHMORAR)
                .title("Loch Morar")
                .snippet("Scotlands Third Biggest Loch")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.ic_marker)));

        // focus the camera on Loch Ness marker with default zoom of 5
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LOCHNESS, 5));

        // sets camera to move to other markers on click
        map.animateCamera(CameraUpdateFactory.zoomTo(7), 2000, null);
    }
   }


