package com.example.database.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {user.class}, version = 1)  //version va sembre aumentato senno prende sempre lo stesso database
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();


}
