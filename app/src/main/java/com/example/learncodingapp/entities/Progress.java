package com.example.learncodingapp.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "progress")
public class Progress {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId; // Link this to user profiles in the future
    private String topic;
    private String language;
    private int completedChallenges;
    private int totalScore;
    private long timestamp; // To track when progress was updated

    // Constructor
    public Progress(int userId, String topic, String language, int completedChallenges, int totalScore, long timestamp) {
        this.userId = userId;
        this.topic = topic;
        this.language = language;
        this.completedChallenges = completedChallenges;
        this.totalScore = totalScore;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCompletedChallenges() {
        return completedChallenges;
    }

    public void setCompletedChallenges(int completedChallenges) {
        this.completedChallenges = completedChallenges;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
