package com.application.r2t2i.enigmacinema;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CinemaDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cinema.db";
    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    public CinemaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_CINEMA_TABLE = "CREATE TABLE " + CinemaContract.FeedEntry. TABLE_NAME + " (" +
                CinemaContract.FeedEntry. _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CinemaContract.FeedEntry. COLUMN_MOVIE_TITLE + " TEXT NOT NULL, " +
                CinemaContract.FeedEntry. COLUMN_DATE + " TEXT NOT NULL, " +
                CinemaContract.FeedEntry. COLUMN_TIME + " TEXT NOT NULL, " +
                CinemaContract.FeedEntry. COLUMN_SCENARIO_MARK + " INTEGER NOT NULL, " +
                CinemaContract.FeedEntry. COLUMN_DIRECTION_MARK + " INTEGER NOT NULL, " +
                CinemaContract.FeedEntry. COLUMN_MUSIC_MARK + " INTEGER NOT NULL " +
                "); " ;

        sqLiteDatabase.execSQL(SQL_CREATE_CINEMA_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " + CinemaContract.FeedEntry. TABLE_NAME); onCreate(sqLiteDatabase);
    }
}
