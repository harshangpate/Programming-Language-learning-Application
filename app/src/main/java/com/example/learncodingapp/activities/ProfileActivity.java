package com.example.learncodingapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.learncodingapp.R;
import com.example.learncodingapp.database.AppDatabase;
import com.example.learncodingapp.entities.UserProfile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, ageEditText;
    private Button saveButton;
    private AppDatabase db;
    private UserProfile currentUserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize database
        db = AppDatabase.getInstance(getApplicationContext());

        // Initialize views
        usernameEditText = findViewById(R.id.username_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        ageEditText = findViewById(R.id.age_edit_text);
        saveButton = findViewById(R.id.save_button);

        // Use Executor to perform database operations in the background
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Load current user profile data in the background
        executor.execute(() -> {
            currentUserProfile = db.userProfileDao().getUserProfileById(1);

            // Update UI on the main thread
            runOnUiThread(() -> {
                if (currentUserProfile != null) {
                    usernameEditText.setText(currentUserProfile.getUsername());
                    emailEditText.setText(currentUserProfile.getEmail());
                    ageEditText.setText(String.valueOf(currentUserProfile.getAge()));
                }
            });
        });

        // Save button listener
        saveButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String ageString = ageEditText.getText().toString().trim();

            // Validate inputs
            if (username.isEmpty() || email.isEmpty() || ageString.isEmpty()) {
                Toast.makeText(ProfileActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException e) {
                Toast.makeText(ProfileActivity.this, "Please enter a valid age", Toast.LENGTH_SHORT).show();
                return;
            }

            executor.execute(() -> {
                if (currentUserProfile == null) {
                    // Create new profile
                    UserProfile newUserProfile = new UserProfile(username, email, age);
                    db.userProfileDao().insertUserProfile(newUserProfile);
                } else {
                    // Update existing profile
                    currentUserProfile.setUsername(username);
                    currentUserProfile.setEmail(email);
                    currentUserProfile.setAge(age);
                    db.userProfileDao().updateUserProfile(currentUserProfile);
                }

                // Redirect to MainActivity with a welcome message
                runOnUiThread(() -> {
                    Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);

                    // Show welcome toast
                    Toast.makeText(ProfileActivity.this, "Welcome: " + username, Toast.LENGTH_SHORT).show();
                });
            });
        });
    }
}
