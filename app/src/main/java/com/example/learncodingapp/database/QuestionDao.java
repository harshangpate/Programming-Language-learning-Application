package com.example.learncodingapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.learncodingapp.entities.Question;

import java.util.List;

@Dao
public interface QuestionDao {

    // Insert a question
    @Insert
    void insertQuestion(Question question);

    // Fetch all questions by topic and language
    @Query("SELECT * FROM questions WHERE topic = :topic AND language = :language")
    List<Question> getQuestionsByTopicAndLanguage(String topic, String language);

    // Fetch all questions
    @Query("SELECT * FROM questions")
    List<Question> getAllQuestions();

}
