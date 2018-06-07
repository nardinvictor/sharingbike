package com.activity.nardin.sharingbike;
        import android.*;
        import android.app.ProgressDialog;
        import android.app.SearchManager;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.app.FragmentActivity;
        import android.os.Bundle;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.SearchView;
        import android.widget.Toast;





        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.Marker;
        import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    EditText edittext;
    Button go1 , letsgo1;
    //Button ok1 ;
    Marker mplace1, mplace2 , mplace3, mplace4, mplace5;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //edittext = (EditText) findViewById(R.id.search);
        //go1 = (Button) findViewById(R.id.go);
        letsgo1 = (Button) findViewById(R.id.letsgo);
        letsgo1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                Intent signIn = new Intent(MapsActivity.this,Qrcode.class);
                startActivity(signIn);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        // Add a marker in October and move the camera
        //october is the place of the person.
        //place1, place2, place3, place4 are the places of the bikes.
        LatLng FOEHU = new LatLng(29.8523875,31.3416858);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.addMarker(new MarkerOptions().position(FOEHU).title("Your Place").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng place1 = new LatLng(29.8486429,31.3401384);
        LatLng place2 = new LatLng(29.850818,31.3386018);
        LatLng place3 = new LatLng(29.8514415,31.3416377);
        LatLng place4 = new LatLng(29.85193,31.3372898);
        LatLng place5 = new LatLng(29.849983,31.3379393);
        mplace1 = mMap.addMarker(new MarkerOptions().position(place1).title("13 bike"  ).icon(BitmapDescriptorFactory.fromResource(R.drawable.bike4)));
        mplace2 = mMap.addMarker(new MarkerOptions().position(place2).title("bike").icon(BitmapDescriptorFactory.fromResource(R.drawable.bike4)));
        mplace3 = mMap.addMarker(new MarkerOptions().position(place3).title("bike").icon(BitmapDescriptorFactory.fromResource(R.drawable.bike4)));
        mplace4 = mMap.addMarker(new MarkerOptions().position(place4).title("bike").icon(BitmapDescriptorFactory.fromResource(R.drawable.bike4)));
        mplace5 = mMap.addMarker(new MarkerOptions().position(place5).title("bike").icon(BitmapDescriptorFactory.fromResource(R.drawable.bike4)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FOEHU, 16));
        mplace1.setTag(0);
        mplace2.setTag(0);
        mplace3.setTag(0);
        mplace4.setTag(0);
        mplace5.setTag(0);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        //}
        // });

    }

    public boolean onMarkerClick(final Marker marker) {

        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }
        return false;

    }
}
