package com.example.learncodingapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learncodingapp.entities.Question;
import com.example.learncodingapp.dao.QuestionDao;
import com.example.learncodingapp.database.AppDatabase;
import com.example.learncodingapp.R;
import com.example.learncodingapp.utils.PopulateQuestionsTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppDatabase db = AppDatabase.getInstance(this);
        new PopulateQuestionsTask(db).execute();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button for "Start Learning"
        Button startLearningButton = findViewById(R.id.startLearningButton);
        startLearningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Language Selection before Topic Selection
                Intent intent = new Intent(MainActivity.this, LanguageSelectionActivity.class);
                startActivity(intent);
            }
        });
        // Button for Leaderboard
        Button leaderboardButton = findViewById(R.id.leaderboardButton);
        leaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to LeaderboardActivity
                Intent intent = new Intent(MainActivity.this, LeaderboardActivity.class);
                startActivity(intent);
            }
        });

        // Button for Profile
        Button profileButton = findViewById(R.id.btn_profile);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProfileActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Check if a welcome message is needed after login
        if (getIntent().hasExtra("username")) {
            String username = getIntent().getStringExtra("username");
            // Show a toast welcoming the user
            Toast.makeText(MainActivity.this, "Welcome: " + username, Toast.LENGTH_SHORT).show();
        }
    }
}
