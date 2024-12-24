package com.example.learncodingapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learncodingapp.R;

public class TopicSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);

        // Get the selected language from the previous activity
        String selectedLanguage = getIntent().getStringExtra("selected_language");

        // Define a list of coding topics
        String[] codingTopics = {
                "Variables", "Loops", "Functions", "Arrays",
                "Object-Oriented Programming", "Data Structures", "Recursion"
        };

        // Set up the Spinner (dropdown) to display the topics
        Spinner topicSpinner = findViewById(R.id.topicSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, codingTopics);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        topicSpinner.setAdapter(adapter);

        // Set up the "Start Challenges" button
        Button startChallengesButton = findViewById(R.id.startChallengesButton);
        startChallengesButton.setOnClickListener(v -> {
            String selectedTopic = topicSpinner.getSelectedItem().toString();

            // Pass the selected language and topic to the ChallengeActivity
            Intent intent = new Intent(TopicSelectionActivity.this, ChallengeActivity.class);
            intent.putExtra("selected_language", selectedLanguage);
            intent.putExtra("selected_topic", selectedTopic);
            startActivity(intent);
        });
    }
}