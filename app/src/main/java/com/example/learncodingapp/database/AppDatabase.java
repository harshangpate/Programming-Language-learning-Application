package com.example.learncodingapp.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.learncodingapp.dao.QuestionDao;
import com.example.learncodingapp.dao.UserProfileDao;
import com.example.learncodingapp.entities.Question;
import com.example.learncodingapp.entities.UserProfile;

@Database(entities = {UserProfile.class, Question.class}, version = 2, exportSchema = false) // Bump version
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserProfileDao userProfileDao();
    public abstract QuestionDao questionDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "learncodingapp_db")
                    .fallbackToDestructiveMigration() // Handle migration
                    .build();
        }
        return instance;
    }
}