package com.example.project.gui;

import com.example.project.movies.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MovieListViewItem extends HBox {

    // подтянуть названия графических элементов
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
        try{
            this.avatarThumbnail.setImage(new Image(m.getPosterURL()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
