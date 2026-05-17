package at.ac.univie.hci.tripzy;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;

public class CityDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_city_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View backButton = findViewById(R.id.detailBackButton);


        TextView cityName = findViewById(R.id.detailCityName);
        TextView tripInfo = findViewById(R.id.detailTripInfo);
        // That os a pretend check if selected data exists. appears throught other project files
        //but does not bring any real functionality(just for reference)
        if (AppData.selectedTrip != null) {
            cityName.setText(AppData.selectedTrip.city);
            tripInfo.setText(AppData.selectedTrip.date + " - 1 guest - from Vienna");
        }

        backButton.setOnClickListener(v -> finish());
    }
}
