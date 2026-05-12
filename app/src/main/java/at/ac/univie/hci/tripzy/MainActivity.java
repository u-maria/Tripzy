package at.ac.univie.hci.tripzy;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );
            return insets;
        });

        View searchButton = findViewById(R.id.searchButton);
        View searchBar = findViewById(R.id.searchBar);


        //to fix the problem with the broken search button
        //overlay appears if search bar is clicked and dissapears on click of closeOverlay
        //and overlayBackdrop
        View searchOverlay = findViewById(R.id.searchOverlay);
        View overlayBackdrop = findViewById(R.id.overlayBackdrop);
        View closeOverlay = findViewById(R.id.closeOverlay);

        searchBar.setOnClickListener(v -> {
            searchOverlay.setVisibility(View.VISIBLE);
            overlayBackdrop.setVisibility(View.VISIBLE);
        });

        closeOverlay.setOnClickListener(v -> {
            searchOverlay.setVisibility(View.GONE);
            overlayBackdrop.setVisibility(View.GONE);
        });

        overlayBackdrop.setOnClickListener(v -> {
            searchOverlay.setVisibility(View.GONE);
            overlayBackdrop.setVisibility(View.GONE);
        });

        searchButton.setOnClickListener(v -> {

            //pretend selection of the trip(not real just for reference)
            AppData.selectedTrip = MockData.grazTrip;
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            startActivity(intent);
        });

        TextView tripsNav = findViewById(R.id.tripsNav);
        TextView savedNav = findViewById(R.id.savedNav);
        //Clicking this button brings us to saved screen
        savedNav.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SavedActivity.class);
            startActivity(intent);
        });
        //This one brings us to currently booked trips
        tripsNav.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TripsActivity.class);
            startActivity(intent);
        });
    }
}
