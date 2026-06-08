package at.ac.univie.hci.tripzy;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;

public class ResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        View trainRouteCard = findViewById(R.id.trainRouteCard);
        View busRouteCard = findViewById(R.id.busRouteCard);


        //basically the next two methods bring us to the same screen
        trainRouteCard.setOnClickListener(v -> {
            // this is just a simple database simulation for the prototype
            AppData.selectedTrip = MockData.grazTrip;
            if (AppData.selectedTrip == null) {
                AppData.errorMessage = "No trip selected.";
                return;
            }
            Intent intent = new Intent(ResultsActivity.this, CityDetailActivity.class);
            startActivity(intent);
        });

        busRouteCard.setOnClickListener(v -> {
            // this is just a simple database simulation for the prototype
            AppData.selectedTrip = MockData.grazTrip;

            if (AppData.selectedTrip == null) {
                AppData.errorMessage = "No trip selected.";
                return;
            }
            Intent intent = new Intent(ResultsActivity.this, CityDetailActivity.class);
            startActivity(intent);
        });
// surprise button alaways leads to Graz
        /*View surpriseButton = findViewById(R.id.surpriseButton);
        surpriseButton.setOnClickListener(v -> {
            AppData.selectedTrip = MockData.grazTrip;
            Intent intent = new Intent(ResultsActivity.this, CityDetailActivity.class);
            startActivity(intent);
        });
*/

        //those three buttons appear often throught the files and mostly present at the bottom
        //of each screen for the quick switching up between them
        View exploreNav = findViewById(R.id.exploreNav);
        exploreNav.setOnClickListener(v -> {
            Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        View savedNav = findViewById(R.id.savedNav);
        savedNav.setOnClickListener(v -> {
            Intent intent = new Intent(ResultsActivity.this, SavedActivity.class);
            startActivity(intent);
        });

        View tripsNav = findViewById(R.id.tripsNav);
        tripsNav.setOnClickListener(v -> {
            Intent intent = new Intent(ResultsActivity.this, TripsActivity.class);
            startActivity(intent);
        });
    }
}
