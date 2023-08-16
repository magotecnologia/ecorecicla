package edu.unal.todosalau.ecorecicla.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.unal.todosalau.ecorecicla.data.dao.UserDao;
import edu.unal.todosalau.ecorecicla.data.entity.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class EcoreciclaDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
