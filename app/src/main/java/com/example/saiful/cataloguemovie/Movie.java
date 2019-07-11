package com.example.saiful.cataloguemovie;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int photo, rating, budget, revenue;
    private String name, description, release_date, genre, runtime;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeInt(this.rating);
        dest.writeInt(this.budget);
        dest.writeInt(this.revenue);
        dest.writeString(this.runtime);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.release_date);
        dest.writeString(this.genre);

    }

    public Movie() {

    }


    protected Movie(Parcel in) {
        this.photo = in.readInt();
        this.rating = in.readInt();
        this.budget = in.readInt();
        this.revenue = in.readInt();
        this.runtime = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.release_date = in.readString();
        this.genre = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
