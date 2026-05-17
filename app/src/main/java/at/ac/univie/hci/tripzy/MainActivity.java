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
import android.widget.EditText;

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
        EditText destinationInput = findViewById(R.id.destinationInput);
        View searchBar = findViewById(R.id.searchBar);

        // fixing trip days flexibility
        TextView datesTab = findViewById(R.id.datesTab);
        TextView flexibleDatesTab = findViewById(R.id.flexibleDatesTab);

        View calendarGrid = findViewById(R.id.calendarGrid);
        TextView flexibleDateText = findViewById(R.id.flexibleDateText);


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

        // flexible dates visibility
        datesTab.setOnClickListener(v -> {
            calendarGrid.setVisibility(View.VISIBLE);
            flexibleDateText.setVisibility(View.GONE);

            datesTab.setBackgroundResource(R.drawable.bg_card);
            datesTab.setTextColor(getResources().getColor(R.color.tripzy_text));

            flexibleDatesTab.setBackgroundColor(
                    getResources().getColor(android.R.color.transparent)
            );
            flexibleDatesTab.setTextColor(
                    getResources().getColor(R.color.tripzy_text_secondary)
            );
        });

        flexibleDatesTab.setOnClickListener(v -> {
            calendarGrid.setVisibility(View.GONE);
            flexibleDateText.setVisibility(View.VISIBLE);

            flexibleDatesTab.setBackgroundResource(R.drawable.bg_card);
            flexibleDatesTab.setTextColor(
                    getResources().getColor(R.color.tripzy_text)
            );

            datesTab.setBackgroundColor(
                    getResources().getColor(android.R.color.transparent)
            );
            datesTab.setTextColor(
                    getResources().getColor(R.color.tripzy_text_secondary)
            );
        });

        searchButton.setOnClickListener(v -> {

            //pretend selection of the trip(not real just for reference)
            AppData.selectedTrip = MockData.grazTrip;
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            startActivity(intent);
        });
// surprise button always leads to Graz
        View surpriseButton = findViewById(R.id.surpriseButton);
        surpriseButton.setOnClickListener(v -> {
            AppData.selectedTrip = MockData.grazTrip;
            Intent intent = new Intent(MainActivity.this, CityDetailActivity.class);
            startActivity(intent);
        });
        // profile button leads to max mustermann
        View profileButton = findViewById(R.id.profileButton_main);
        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
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
