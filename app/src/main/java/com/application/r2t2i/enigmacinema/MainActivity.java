package com.application.r2t2i.enigmacinema;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import static com.application.r2t2i.enigmacinema.CinemaContract.*;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    Button btnDatePicker, btnTimePicker, btnSubmit;
    EditText txtDate, txtTime, movieTitle, scenarioMark, directionMark, musicMark, movieDesc;
    private int mYear, mMonth, mDay, mHour, mMinute;

    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieTitle = (EditText) findViewById(R.id.movieTitle);
        scenarioMark = (EditText) findViewById(R.id.scenarioMark);
        directionMark = (EditText) findViewById(R.id.directionMark);
        musicMark = (EditText) findViewById(R.id.musicMark);
        movieDesc = (EditText) findViewById(R.id.movieDesc);
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);
        btnSubmit=(Button)findViewById(R.id.submit);


        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);



        CinemaDbHelper dbHelper = new CinemaDbHelper(this);
        mDb = dbHelper.getWritableDatabase();

        Cursor cursor = getAllMovies();

    }
    private Cursor getAllMovies() {
        return mDb.query(
                FeedEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                FeedEntry.COLUMN_MOVIE_TITLE
        );
    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
    public void createMovie(View view) {

        Intent intent = new Intent(MainActivity.this, MovieListAdapter.class);
        startActivity(intent);



        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_MOVIE_TITLE, movieTitle.getText().toString());
        values.put(FeedEntry.COLUMN_DATE, txtDate.getText().toString());
        values.put(FeedEntry.COLUMN_TIME, txtTime.getText().toString());
        values.put(FeedEntry.COLUMN_SCENARIO_MARK, txtTime.getText().toString());
        values.put(FeedEntry.COLUMN_DIRECTION_MARK, directionMark.getText().toString());
        values.put(FeedEntry.COLUMN_SCENARIO_MARK, musicMark.getText().toString());


        mDb.insert(FeedEntry.TABLE_NAME, null, values);
    }

}
