package com.example.project.gui;

import com.example.project.movies.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MovieCardViewer extends HBox implements Initializable {

    public final ObservableList<Movie> movies = FXCollections.observableArrayList();

    @FXML
    private ListView movieListView;

    @FXML
    private HBox movieCardContainer;

    public MovieCardViewer() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MovieCardViewer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMovies(List<Movie> movies) {
        this.movies.addAll(movies);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.movieListView.setItems(movies);

        this.movieListView.setCellFactory(lv -> {
            ListCell<Movie> cell = new ListCell<Movie>() {
                @Override
                protected void updateItem(Movie item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        return;
                    }
                    MovieListViewItem c = new MovieListViewItem();
                    c.setMovie(item);
                    setGraphic(c);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    this.movieClicked(e, (Movie) movieListView.getSelectionModel().getSelectedItem());
                    e.consume();
                }
            });
            return cell;
        });

        this.movieCardContainer.getChildren().removeAll();
        this.card = new MovieCard();
        this.movieCardContainer.getChildren().add(card);

    }

    MovieCard card;

    void movieClicked(MouseEvent e, Movie m) {


        this.card.setMovie(m);
    }
}
