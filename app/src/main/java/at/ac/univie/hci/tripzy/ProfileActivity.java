package at.ac.univie.hci.tripzy;
//created profileActivity because it did not exist for activity_profile.xml
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //additionally added backbutton functionality
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        View backButton = findViewById(R.id.profileBackButton);
        backButton.setOnClickListener(v -> finish());
    }
}
