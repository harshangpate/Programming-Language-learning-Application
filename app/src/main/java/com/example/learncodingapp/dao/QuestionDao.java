package com.example.learncodingapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.learncodingapp.entities.Question;
import com.example.learncodingapp.dao.QuestionDao;
import com.example.learncodingapp.database.AppDatabase;

import java.util.List;

@Dao
public interface QuestionDao {
    // Insert a list of questions
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Question> questions);

    // Fetch all questions by topic and language
    @Query("SELECT * FROM questions WHERE topic = :topic AND language = :language")
    List<Question> getQuestionsByTopicAndLanguage(String topic, String language);

    @Query("SELECT COUNT(*) FROM questions")
    int getCount();
    @Query("SELECT COUNT(*) FROM questions WHERE topic = :topic AND language = :language")
    int countQuestionsByTopicAndLanguage(String topic, String language);
    @Query("SELECT * FROM questions WHERE topic = :topic AND language = :language AND difficulty = :difficulty")
    List<Question> getQuestionsByTopicLanguageAndDifficulty(String topic, String language, String difficulty);
}
