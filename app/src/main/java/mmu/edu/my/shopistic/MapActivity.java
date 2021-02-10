package mmu.edu.my.shopistic;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapActivity extends AppCompatActivity {
    Geocoder geocoder;
    TextView textView;
    Button button;
    EditText editText;
    SupportMapFragment supportMapFragment;
    GoogleMap mMap;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        back = findViewById(R.id.back5);
        back = (ImageView) findViewById(R.id.back5);
        back.setOnClickListener(v -> {
            Intent back;
            back = new Intent(MapActivity.this, Payment.class);
            startActivity(back);
            finish();
        });

        setContentView(R.layout.activity_map);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.locationName);


        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        button.setOnClickListener(vs -> {
            String result=null;
            geocoder=new Geocoder(MapActivity.this, Locale.getDefault());
            try {
                double lat, lng;
                List<Address> addresses=geocoder.getFromLocationName(editText.getText().toString(),1);
//                  result=addresses.get(0).getAddressLine(0)+"\n"+addresses.get(0).getLatitude()+":"+addresses.get(0).getLongitude();
                result=addresses.get(0).getAddressLine(0)+"\n";
                lat=addresses.get(0).getLatitude();
                lng=addresses.get(0).getLongitude();
                textView.setText(result);
                supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        LatLng point = new LatLng(lat, lng);
                        mMap = googleMap;
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(point, 15));
                        mMap.addMarker(new MarkerOptions().position(point).title("Your point"));
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}