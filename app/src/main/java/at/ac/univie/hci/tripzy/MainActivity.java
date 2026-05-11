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

        searchButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            startActivity(intent);
        });

        TextView tripsNav = findViewById(R.id.tripsNav);
        tripsNav.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TripsActivity.class);
            startActivity(intent);
        });
    }
}