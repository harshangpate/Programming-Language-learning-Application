package com.example.learncodingapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learncodingapp.R;
import com.example.learncodingapp.database.AppDatabase;
import com.example.learncodingapp.entities.Question;

public class ChallengeDetailActivity extends AppCompatActivity {

    private TextView questionTextView;
    private EditText answerEditText;
    private Button submitButton;
    private String correctAnswer;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_detail);

        questionTextView = findViewById(R.id.questionTextView);
        answerEditText = findViewById(R.id.answerEditText);
        submitButton = findViewById(R.id.submitButton);

        // Get selected question, topic, and language
        String selectedQuestion = getIntent().getStringExtra("selected_question");
        String selectedTopic = getIntent().getStringExtra("selected_topic");
        String selectedLanguage = getIntent().getStringExtra("selected_language");

        // Display the selected question
        questionTextView.setText(selectedQuestion);

        // Fetch the correct answer from the database
        fetchCorrectAnswerFromDatabase(selectedQuestion, selectedTopic, selectedLanguage);

        submitButton.setOnClickListener(v -> {
            String userAnswer = answerEditText.getText().toString();

            // Validate answer
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                score += 10;  // Add 10 points for correct answer
                Toast.makeText(ChallengeDetailActivity.this, "Correct answer!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ChallengeDetailActivity.this, "Incorrect answer. Try again!", Toast.LENGTH_SHORT).show();
            }

            // Save score to leaderboard
            SharedPreferences prefs = getSharedPreferences("leaderboard", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            String userName = "User1"; // You can dynamically get the user's name from SummaryActivity
            editor.putInt(userName, score);
            editor.apply();

            // Redirect to SummaryActivity
            Intent intent = new Intent(ChallengeDetailActivity.this, SummaryActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        });
    }

    // Fetch the correct answer from the database based on the selected question
    private void fetchCorrectAnswerFromDatabase(String selectedQuestion, String selectedTopic, String selectedLanguage) {
        AppDatabase db = AppDatabase.getInstance(this);

        // Run database operation in the background
        new AsyncTask<Void, Void, Question>() {
            @Override
            protected Question doInBackground(Void... voids) {
                return db.questionDao().getQuestionsByTopicAndLanguage(selectedTopic, selectedLanguage)
                        .stream()
                        .filter(q -> q.getQuestion().equals(selectedQuestion))
                        .findFirst()
                        .orElse(null);
            }

            @Override
            protected void onPostExecute(Question result) {
                if (result != null) {
                    correctAnswer = result.getAnswer();
                } else {
                    Toast.makeText(ChallengeDetailActivity.this, "Error: Answer not found!", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }
}
