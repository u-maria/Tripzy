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

        trainRouteCard.setOnClickListener(v -> {
            Intent intent = new Intent(ResultsActivity.this, CityDetailActivity.class);
            startActivity(intent);
        });

        busRouteCard.setOnClickListener(v -> {
            Intent intent = new Intent(ResultsActivity.this, CityDetailActivity.class);
            startActivity(intent);
        });
    }
}