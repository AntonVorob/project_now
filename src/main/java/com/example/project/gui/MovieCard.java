package com.example.project.gui;

import com.example.project.MovieApplication;
import com.example.project.movies.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MovieCard extends HBox {

    @FXML
   public Label nameTitle;
    public Label years;
    public Label Genres;
    public Label Description;
    public ImageView Poster;
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

        this.nameTitle.setText(m.getNameRU());
        this.Genres.setText (m.getGenres());

        this.years.setText("Год: "+m.getYears()+" Рейтинг: "+m.getRatingKinopoisk()+" Страна:"+m.getCountry());
        this.Description.setText ("Оригинальное название: "+m.getNameEN());
          try{
            this.Poster.setImage(new Image(m.getPosterURL()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // TODO: должны быть кнопки, которые добавляют или удаляют категорию

    void buttonClicked() {
        Movie m = new Movie(); // откуда то у нас есть кино
        m.setAbandoned(true);

        MovieApplication.movieService.saveMovie(m);
    }


}
