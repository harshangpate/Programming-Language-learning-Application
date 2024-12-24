package com.example.learncodingapp.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learncodingapp.R;
import com.example.learncodingapp.adapters.ChallengeAdapter;
import com.example.learncodingapp.database.AppDatabase;
import com.example.learncodingapp.entities.Question;

import java.util.List;

public class ChallengeActivity extends AppCompatActivity {

    private List<Question> questionsList;
    private Spinner spinnerDifficulty; // Difficulty selector spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        // Initialize the difficulty spinner
        spinnerDifficulty = findViewById(R.id.spinnerDifficulty);

        // Button to start the challenge after selecting difficulty
        Button buttonStartChallenge = findViewById(R.id.buttonStartChallenge);

        // Get selected topic and language from Intent
        String selectedTopic = getIntent().getStringExtra("selected_topic");
        String selectedLanguage = getIntent().getStringExtra("selected_language");

        // Set up button click listener for starting the challenge
        buttonStartChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected difficulty from the spinner
                String selectedDifficulty = spinnerDifficulty.getSelectedItem().toString();

                // Load questions from the database based on topic, language, and difficulty
                loadQuestionsFromDatabase(selectedTopic, selectedLanguage, selectedDifficulty);
            }
        });
    }

    private void loadQuestionsFromDatabase(String topic, String language, String difficulty) {
        AppDatabase db = AppDatabase.getInstance(this);
        new AsyncTask<Void, Void, List<Question>>() {
            @Override
            protected List<Question> doInBackground(Void... voids) {
                // Fetch questions based on topic, language, and difficulty
                return db.questionDao().getQuestionsByTopicLanguageAndDifficulty(topic, language, difficulty);
            }

            @Override
            protected void onPostExecute(List<Question> result) {
                if (result == null || result.isEmpty()) {
                    // Show a message if no questions are found
                    Toast.makeText(ChallengeActivity.this, "No questions found for the selected difficulty!", Toast.LENGTH_SHORT).show();
                } else {
                    questionsList = result;
                    populateListView();
                }
            }
        }.execute();
    }

    private void populateListView() {
        ListView challengesListView = findViewById(R.id.challengesListView);
        String[] questionsArray = new String[questionsList.size()];

        for (int i = 0; i < questionsList.size(); i++) {
            questionsArray[i] = questionsList.get(i).getQuestion();
        }

        // Debugging to verify the questions are being passed
        Log.d("ChallengeActivity", "Number of questions: " + questionsArray.length);

        ChallengeAdapter adapter = new ChallengeAdapter(this, questionsArray);
        challengesListView.setAdapter(adapter);

        challengesListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedQuestion = questionsArray[position];
            Intent intent = new Intent(ChallengeActivity.this, ChallengeDetailActivity.class);
            intent.putExtra("selected_question", selectedQuestion);
            intent.putExtra("selected_topic", questionsList.get(position).getTopic());
            intent.putExtra("selected_language", questionsList.get(position).getLanguage());
            startActivity(intent);
        });
    }
}
