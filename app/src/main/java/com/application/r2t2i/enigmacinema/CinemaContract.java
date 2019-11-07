package com.application.r2t2i.enigmacinema;

import android.provider.BaseColumns;

import java.util.Date;


public class CinemaContract {

    private CinemaContract() {} // Make the constructor private to prevent from accidental instantiation of the contract class.

    public static class FeedEntry implements BaseColumns {

        public static final String TABLE_NAME = "cinema";
        public static final String COLUMN_MOVIE_TITLE = "movieTitle";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_SCENARIO_MARK = "scenarioMark";
        public static final String COLUMN_DIRECTION_MARK = "directionMark";
        public static final String COLUMN_MUSIC_MARK = "musicMark";

    }
}
