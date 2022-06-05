package com.example.project.gui;

import com.example.project.movies.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MovieCard extends HBox {

    @FXML
    Label nameTitle;
    Label years;
    Label Genres;
    Label Description;
    ImageView Poster;
    public MovieCard() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("cardOfFilms.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setMovie(Movie m) {
        this.nameTitle.setText(m.getNameRU()+"\n"+m.getNameEN()+"\n");
        this.Genres.setText (m.getGenres());
        this.years.setText(m.getYears()+"\n"+m.getRatingKinopoisk()+"\n"+m.getCountry()+"\n");
        this.Description.setText (m.getShortDescription());
        try{
            this.Poster.setImage(new Image(m.getPosterURL()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void setMovieName(String s) {
        this.nameTitle.setText(s);
    }


}
