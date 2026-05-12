package at.ac.univie.hci.tripzy;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;

// "Saved" Screen
public class SavedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        TextView exploreNav = findViewById(R.id.exploreNav);
        exploreNav.setOnClickListener(v -> {
            Intent intent = new Intent(SavedActivity.this, MainActivity.class);
            startActivity(intent);
        });

        TextView tripsNav = findViewById(R.id.tripsNav);
        tripsNav.setOnClickListener(v -> {
            Intent intent = new Intent(SavedActivity.this, TripsActivity.class);
            startActivity(intent);
        });
    }
}
