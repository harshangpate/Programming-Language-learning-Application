package com.example.learncodingapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learncodingapp.R;

import java.util.ArrayList;
import java.util.Map;

public class LeaderboardActivity extends AppCompatActivity {

    private ListView leaderboardListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        leaderboardListView = findViewById(R.id.leaderboardListView);

        // Retrieve scores from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("leaderboard", MODE_PRIVATE);
        Map<String, ?> allScores = prefs.getAll();

        // Prepare a list of scores for display
        ArrayList<String> scoreList = new ArrayList<>();
        for (Map.Entry<String, ?> entry : allScores.entrySet()) {
            String userName = entry.getKey();
            int userScore = (int) entry.getValue();
            scoreList.add(userName + ": " + userScore + " points");
        }

        // Set the scores to the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, scoreList);
        leaderboardListView.setAdapter(adapter);
    }
}
