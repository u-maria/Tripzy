package at.ac.univie.hci.tripzy;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class TripsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);

        TextView exploreNav = findViewById(R.id.exploreNav);
        exploreNav.setOnClickListener(v -> {
            Intent intent = new Intent(TripsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        TextView savedNav = findViewById(R.id.savedNav);
        savedNav.setOnClickListener(v -> {
            Intent intent = new Intent(TripsActivity.this, SavedActivity.class);
            startActivity(intent);
        });

        View profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(TripsActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
