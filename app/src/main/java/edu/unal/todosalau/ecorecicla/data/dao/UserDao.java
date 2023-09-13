package edu.unal.todosalau.ecorecicla.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import edu.unal.todosalau.ecorecicla.data.entity.UserEntity;

@Dao
public interface UserDao {
    @Query("SELECT * FROM USERS AS U WHERE U.USERNAME = :username")
    abstract List<UserEntity> findUsersByName(String username);
}
