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
    public Button btnWatched;
    public Button btnPlanned;
    public Button btnFavourites;
    public Button btnAbandoned;
    public Button btnPostponed;

    Movie selectedMovie;

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

        this.selectedMovie = m;

        this.nameTitle.setText("Название: "+ m.getNameRU());

        this.Genres.setText (m.getGenres());

        this.years.setText("Год: "+m.getYears()+";"+" Рейтинг: "+m.getRatingKinopoisk()+";"+" Страна: "+m.getCountry());

        this.Description.setText ("Оригинальное название: "+m.getNameEN());

          try{
            this.Poster.setImage(new Image(m.getPosterURL()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            this.btnWatched.setOnAction(e -> {//просмотренно
                if ((this.selectedMovie != null) &(selectedMovie.isPlanned()!=true) &(selectedMovie.isPostponed()!=true)&(selectedMovie.isAbandoned()!=true)&(selectedMovie.isFavourites()!=true)) {
                    if (selectedMovie.isWatched()) {
                        selectedMovie.setWatched(false);
                        this.btnWatched.setTextFill(Color.BLUE);
                    } else {
                        selectedMovie.setWatched(true);
                        this.btnWatched.setTextFill(Color.RED);
                    }
                    MovieApplication.movieService.saveMovie(selectedMovie);
                }
            });

            this.btnPlanned.setOnAction(e1 -> {//В планах
                if ((this.selectedMovie != null)&(selectedMovie.isWatched()!=true) &(selectedMovie.isPostponed()!=true)&(selectedMovie.isAbandoned()!=true)&(selectedMovie.isFavourites()!=true)) {
                    if (selectedMovie.isPlanned()) {
                        selectedMovie.setPlanned(false);
                        this.btnPlanned.setTextFill(Color.BLUE);
                    } else {
                        selectedMovie.setPlanned(true);
                        this.btnPlanned.setTextFill(Color.RED);
                    }
                    MovieApplication.movieService.saveMovie(selectedMovie);
                }
            });

            this.btnFavourites.setOnAction(e1 -> {//Избранное
                if ((this.selectedMovie != null) &(selectedMovie.isPlanned()!=true) &(selectedMovie.isPostponed()!=true)&(selectedMovie.isAbandoned()!=true)&(selectedMovie.isWatched()!=true)) {
                    if (selectedMovie.isFavourites()) {
                        selectedMovie.setFavourites(false);
                        this.btnFavourites.setTextFill(Color.BLUE);
                    } else {
                        selectedMovie.setFavourites(true);
                        this.btnFavourites.setTextFill(Color.RED);
                    }
                    MovieApplication.movieService.saveMovie(selectedMovie);
                }
            });

            this.btnPostponed.setOnAction(e1 -> {//Отложено
                if ((this.selectedMovie != null)&(selectedMovie.isPlanned()!=true) &(selectedMovie.isWatched()!=true)&(selectedMovie.isAbandoned()!=true)&(selectedMovie.isFavourites()!=true)) {
                    if (selectedMovie.isPostponed()) {
                        selectedMovie.setPostponed(false);
                        this.btnPostponed.setTextFill(Color.BLUE);
                    } else {
                        selectedMovie.setPostponed(true);
                        this.btnPostponed.setTextFill(Color.RED);
                    }
                    MovieApplication.movieService.saveMovie(selectedMovie);
                }
            });

            this.btnAbandoned.setOnAction(e1 -> {//Юрошено
                if ((this.selectedMovie != null)&(selectedMovie.isPlanned()!=true) &(selectedMovie.isPostponed()!=true)&(selectedMovie.isWatched()!=true)&(selectedMovie.isFavourites()!=true)) {
                    if (selectedMovie.isAbandoned()) {
                        selectedMovie.setAbandoned(false);
                        this.btnAbandoned.setTextFill(Color.BLUE);
                    } else {
                        selectedMovie.setAbandoned(true);
                        this.btnAbandoned.setTextFill(Color.RED);
                    }
                    MovieApplication.movieService.saveMovie(selectedMovie);
                }
            });

    }
}
