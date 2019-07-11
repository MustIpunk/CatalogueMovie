package com.example.saiful.cataloguemovie;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.saiful.cataloguemovie.Movie;
import com.example.saiful.cataloguemovie.MovieAdapter;
import com.example.saiful.cataloguemovie.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName, dataGenre, dataReleasedate, dataDescription, dataRuntime;
    private int[] dataRating, dataBudget, dataRevenue;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(MainActivity.this, movies.get(i).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,MoveWithObjectActivity.class);
                intent.putExtra(MoveWithObjectActivity.EXTRA_MOVIE, movies.get(i));

                startActivity(intent);
            }
        });
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataRating = getResources().getIntArray(R.array.data_rating);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataBudget = getResources().getIntArray(R.array.data_budget);
        dataRevenue = getResources().getIntArray(R.array.data_revenue);
        dataReleasedate = getResources().getStringArray(R.array.data_releasedate);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataDescription = getResources().getStringArray(R.array.data_description);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setGenre(dataGenre[i]);
            movie.setRating(dataRating[i]);
            movie.setBudget(dataBudget[i]);
            movie.setRevenue(dataRevenue[i]);
            movie.setRelease_date(dataReleasedate[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setDescription(dataDescription[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}