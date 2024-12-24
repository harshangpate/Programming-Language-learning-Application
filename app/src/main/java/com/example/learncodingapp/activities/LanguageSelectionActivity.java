package com.example.learncodingapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learncodingapp.R;
import com.example.learncodingapp.activities.ChallengeActivity;

public class LanguageSelectionActivity extends AppCompatActivity {

    private Button javaButton, pythonButton, cppButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        javaButton = findViewById(R.id.java_button);
        pythonButton = findViewById(R.id.python_button);
        cppButton = findViewById(R.id.cpp_button);


        javaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLanguage("Java");
            }
        });

        pythonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLanguage("Python");
            }
        });

        cppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLanguage("C++");
            }
        });
    }

    private void selectLanguage(String language) {
        // Show a toast that the user has successfully logged in and selected a language
        Toast.makeText(this, "Successfully logged in. Selected language: " + language, Toast.LENGTH_SHORT).show();

        // Redirect to TopicSelectionActivity instead of ChallengeActivity
        Intent intent = new Intent(LanguageSelectionActivity.this, TopicSelectionActivity.class);
        intent.putExtra("selected_language", language); // Pass the selected language to TopicSelectionActivity
        startActivity(intent);

        // Optionally, finish the language selection activity so the user can't go back to it
        finish();
    }
}
