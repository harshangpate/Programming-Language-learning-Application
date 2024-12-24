package com.example.learncodingapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learncodingapp.R;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView scoreTextView = findViewById(R.id.scoreTextView);
        Button leaderboardButton = findViewById(R.id.leaderboardButton);
        Button selectDifferentQuestionButton = findViewById(R.id.button_select_different_question);

        // Get the score passed from ChallengeDetailActivity
        int score = getIntent().getIntExtra("score", 0);
        scoreTextView.setText("Your score: " + score);

        // Leaderboard button logic
        leaderboardButton.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryActivity.this, LeaderboardActivity.class);
            startActivity(intent);
        });

        // Select different question button logic
        selectDifferentQuestionButton.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryActivity.this, ChallengeActivity.class);
            startActivity(intent);
        });
    }
}
// {"conversationId":"01a3e620-9a53-40ef-9309-562a868968c2","source":"instruct"}
