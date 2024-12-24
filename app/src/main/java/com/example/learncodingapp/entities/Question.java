package com.example.learncodingapp.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.learncodingapp.dao.QuestionDao;
@Entity(tableName = "questions")
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String question;
    private String answer;
    private String topic;
    private String language;
    private String difficulty; // New field for difficulty level

    public Question(String question, String answer, String topic, String language, String difficulty) {
        this.question = question;
        this.answer = answer;
        this.topic = topic;
        this.language = language;
        this.difficulty = difficulty;
    }

    // Getters and setters for all fields
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
}
