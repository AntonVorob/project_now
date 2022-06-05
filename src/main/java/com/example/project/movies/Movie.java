package com.example.project.movies;

import com.example.project.HelloApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    boolean Planned;
    boolean Watched;
    boolean Favourites;//Избранное
    boolean Postponed;//отложено
    boolean Abandoned;//Брошено

    String nameRU;
    String nameEN;
    String PosterURL = String.valueOf(HelloApplication.class.getResource("puppy.jpg"));
    String Genres;
    int years;
    double ratingKinopoisk;
    String shortDescription;
    String country;
    String webUrl;
    int filmId;

//

    public Movie(String nameRU, String nameEN, String posterURL, String genres, int years, double ratingKinopoisk, String shortDescription, String country, String webUrl, int FilmId) {
        this.nameRU = nameRU;
        this.nameEN = nameEN;
        PosterURL = posterURL;
        Genres = genres;
        this.years = years;
        this.ratingKinopoisk = ratingKinopoisk;
        this.shortDescription = shortDescription;
        this.country = country;
        this.webUrl = webUrl;
        this.filmId= filmId;
    }

    public Movie(String nameRu) {
        this.nameRU = nameRu;
    }

    public Movie() {

    }

    public String getNameRU() {
        return nameRU;
    }
    public int getfilmId() {
        return filmId;
    }

    public String getNameEN() {
        return nameEN;
    }

    public String getPosterURL() {
        return PosterURL;
    }

    public String getGenres() {
        return Genres;
    }

    public int getYears() {
        return years;
    }

    public double getRatingKinopoisk() {
        return ratingKinopoisk;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getCountry() {
        return country;
    }

    public String getWebUrl() {
        return webUrl;
    }
}
