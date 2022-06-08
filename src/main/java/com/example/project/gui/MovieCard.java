package com.example.project.gui;

import com.example.project.MovieApplication;
import com.example.project.movies.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class MovieCard extends HBox implements Initializable {

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

    Movie selectedMovie;

    public void setMovie(Movie m) {

        this.selectedMovie = m;

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

    @FXML
    public Button btnWatched;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btnWatched.setOnAction(e -> {
            if (selectedMovie.isWatched()) {
                selectedMovie.setWatched(false);
                this.btnWatched.setTextFill(Color.BLUE);
            } else {
                selectedMovie.setWatched(true);
                this.btnWatched.setTextFill(Color.RED);
            }
            MovieApplication.movieService.saveMovie(selectedMovie);
        });

        // TODO: написать для других кнопок
    }
}
