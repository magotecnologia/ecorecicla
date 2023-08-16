package edu.unal.todosalau.ecorecicla.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "USERS")
public class UserEntity {

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "USERNAME")
    public String username;

    @ColumnInfo(name = "EMAIL")
    public String email;

    @ColumnInfo(name = "PASSWORD")
    public String password;
}
