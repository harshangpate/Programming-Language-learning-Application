package com.example.learncodingapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.learncodingapp.entities.UserProfile;

import java.util.List;

@Dao
public interface UserProfileDao {

    @Insert
    void insertUserProfile(UserProfile userProfile);

    @Query("SELECT * FROM UserProfile WHERE id = :id LIMIT 1")
    UserProfile getUserProfileById(int id);

    @Update
    void updateUserProfile(UserProfile userProfile);

    @Query("SELECT * FROM UserProfile")
    List<UserProfile> getAllUserProfiles();
}
