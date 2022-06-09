package com.example.project.movies;

import com.example.project.MovieApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    boolean planned = false;
    boolean watched = false;
    boolean favourites = false;//Избранное
    boolean postponed = false;//отложено
    boolean abandoned = false;//Брошено

    String nameRU;
    String nameEN= "";
    String PosterURL = String.valueOf(MovieApplication.class.getResource("puppy.jpg"));
    String Genres="Жанры: " ;
    String country="";
    String webUrl;
    String shortDescription="";
    int years=0;
    int filmId;
    double ratingKinopoisk=0;


    public boolean isPlanned() {
        return planned;
    }

    public boolean isWatched() {
        return watched;
    }

    public boolean isFavourites() {
        return favourites;
    }

    public boolean isPostponed() {
        return postponed;
    }

    public boolean isAbandoned() {
        return abandoned;
    }

    public void setPlanned(boolean planned) {
        this.planned = planned;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public void setFavourites(boolean favourites) {
        this.favourites = favourites;
    }

    public void setPostponed(boolean postponed) {
        this.postponed = postponed;
    }

    public void setAbandoned(boolean abandoned) {
        this.abandoned = abandoned;
    }





    public void setId(Long id) {
        this.id = id;
    }

    public void setNameRU(String nameRU) {
        this.nameRU = nameRU;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public void setPosterURL(String posterURL) {
        this.PosterURL = posterURL;
    }

    public void setGenres(String genres) {
        this.Genres = genres;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setRatingKinopoisk(double ratingKinopoisk) {
        this.ratingKinopoisk = ratingKinopoisk;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Movie(String nameRu ) {
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
