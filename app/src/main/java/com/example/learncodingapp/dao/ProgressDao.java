package com.example.learncodingapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.learncodingapp.entities.Progress;

import java.util.List;

@Dao
public interface ProgressDao {

    // Insert a new progress entry
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProgress(Progress progress);

    // Fetch progress by user, topic, and language
    @Query("SELECT * FROM progress WHERE userId = :userId AND topic = :topic AND language = :language")
    Progress getProgressByTopicAndLanguage(int userId, String topic, String language);

    // Fetch all progress for a user
    @Query("SELECT * FROM progress WHERE userId = :userId")
    List<Progress> getAllProgressByUser(int userId);

    // Update progress entry
    @Update
    void updateProgress(Progress progress);
}
