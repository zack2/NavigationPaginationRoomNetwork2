package com.olivierloukombo.navigationpaginationroomnetwork.data;

import android.content.Context;

import com.olivierloukombo.navigationpaginationroomnetwork.data.dao.ProductDao;
import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;

import androidx.room.Room;
import androidx.room.RoomDatabase;


@androidx.room.Database(
        entities = {Products.class},
        version = 1,
        exportSchema = false)
public abstract class DatabaseApp extends RoomDatabase {

    private static final String DATABASE_NAME = "database";
    public abstract ProductDao productDao();
    private static DatabaseApp INSTANCE;
    private static final Object LOCK = new Object();

    public static DatabaseApp getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                // Create database here
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        DatabaseApp.class,
                        DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }

}
