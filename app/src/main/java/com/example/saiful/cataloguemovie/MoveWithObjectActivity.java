package com.example.saiful.cataloguemovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "movie_name" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
    }
}
