package com.example.notepad.Database;


import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notepad.Models.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB datbase;
    private static String DATABASE_NAME = "NoteApp";

    public synchronized  static RoomDB getInstance(Context context){
        if (datbase == null) {
            datbase = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, DATABASE_NAME).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();


        }
        return datbase;
    }

    public abstract MainDAO mainDAO();
}
