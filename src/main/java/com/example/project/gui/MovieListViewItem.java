package com.example.project.gui;

import com.example.project.MovieApplication;
import com.example.project.movies.Movie;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.CacheHint;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MovieListViewItem extends HBox implements Initializable {

    @FXML
    public Label nameTitle;
    public ImageView avatarThumbnail;
    public Label Description;

    MovieListViewItem() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MovieListViewItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMovie(Movie m) {
        this.nameTitle.setText(m.getNameRU());
        this.Description.setText (m.getShortDescription());
        m.setNameEN(m.getNameEN());
        try{
            this.avatarThumbnail.setImage(new Image(getClass().getResource("loading.gif").toString()));
            if (!MovieApplication.imageCache.containsKey(m.getPosterURL())) {
                Platform.runLater(() -> {
                    MovieApplication.imageCache.put(m.getPosterURL(), new Image(m.getPosterURL()));
                    this.avatarThumbnail.setImage(MovieApplication.imageCache.get(m.getPosterURL()));
                });
            } else {
                this.avatarThumbnail.setImage(MovieApplication.imageCache.get(m.getPosterURL()));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.setCache(true);
        this.setCacheHint(CacheHint.SPEED);

        this.avatarThumbnail.setCache(true);
        this.avatarThumbnail.setCacheHint(CacheHint.SPEED);
    }
}
