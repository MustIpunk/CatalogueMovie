package com.example.saiful.cataloguemovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saiful.cataloguemovie.Movie;
import com.example.saiful.cataloguemovie.R;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if ( view == null ){
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }


    private class ViewHolder{
        private TextView txtName, txtRating, txtGenre;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtGenre = view.findViewById(R.id.txt_genre);
            txtRating = view.findViewById(R.id.txt_rating);
            imgPhoto = view.findViewById(R.id.iv_photo);
        }

        void bind(Movie movie){
            txtName.setText(movie.getName());
            txtRating.setText(String.valueOf(movie.getRating()));
            txtGenre.setText(movie.getGenre());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }
}
