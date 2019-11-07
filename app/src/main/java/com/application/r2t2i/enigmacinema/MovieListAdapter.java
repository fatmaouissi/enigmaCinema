package com.application.r2t2i.enigmacinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;



public class MovieListAdapter extends AppCompatActivity {

    private SQLiteDatabase mDb;
    private Cursor mCursor;
    private Context mContext;
    private EditText txtDate, txtTime, movieTitle, scenarioMark, directionMark, musicMark, movieDesc ;

    Cursor cursor = getAllMovies();


    private Cursor getAllMovies() {
        return mDb.query(
                CinemaContract.FeedEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                CinemaContract.FeedEntry.COLUMN_MOVIE_TITLE
        );
    }


}
