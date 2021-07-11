package io.codezone.movieinfoservice.models;

public class InfoServiceModel {
    int movieId;
    String name;

    public InfoServiceModel() {}

    public InfoServiceModel(int movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public int getMovieId() {
        return this.movieId;
    }

    public String getName() {
        return this.name;
    }

    public void setMovieId(int mId) {
        this.movieId = mId;
    }

    public void setName(String n) {
        this.name = n;
    }
}
