package com.example.project.gui;

import com.example.project.MovieApplication;
import com.example.project.movies.Movie;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public Button searchBtn;
    public Button btnPlanned;
    public TextField searchTextField;
    public VBox movieContainer;
    public TabPane foldersTabPane;
    public VBox movieContainerPlanned;
    public VBox movieContainerWatched;
    public VBox movieContainerFavourites;
    public VBox movieContainerPostponed;
    public VBox movieContainerAbandoned;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        searchBtn.setOnAction(e -> {

            Platform.runLater( () -> {
                String text = searchTextField.getText();
                List<Movie> movies = MovieApplication.movieService.findMovies(text);

                MovieCardViewer viewer = new MovieCardViewer();
                viewer.setMovies(movies);
                movieContainer.getChildren().clear();
                movieContainer.getChildren().add(viewer);
            });

        });

        this.foldersTabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {

                if (newValue.equals(0)) {
                    MovieCardViewer viewer = new MovieCardViewer();
                    viewer.setMovies(MovieApplication.movieService.getMoviesPlanned());
                    movieContainerPlanned.getChildren().clear();
                    movieContainerPlanned.getChildren().add(viewer);
                }
                if (newValue.equals(1)) {
                    MovieCardViewer viewer = new MovieCardViewer();
                    viewer.setMovies(MovieApplication.movieService.getMoviesWatched());
                    movieContainerWatched.getChildren().clear();
                    movieContainerWatched.getChildren().add(viewer);
                }
                if (newValue.equals(2)) {
                    MovieCardViewer viewer = new MovieCardViewer();
                    viewer.setMovies(MovieApplication.movieService.getMoviesFavourites());
                    movieContainerFavourites.getChildren().clear();
                    movieContainerFavourites.getChildren().add(viewer);
                }
                if (newValue.equals(3)) {
                    MovieCardViewer viewer = new MovieCardViewer();
                    viewer.setMovies(MovieApplication.movieService.getMoviesPostponed());
                    movieContainerPostponed.getChildren().clear();
                    movieContainerPostponed.getChildren().add(viewer);
                }
                if (newValue.equals(4)) {
                    MovieCardViewer viewer = new MovieCardViewer();
                    viewer.setMovies(MovieApplication.movieService.getMoviesAbandoned());
                    movieContainerAbandoned.getChildren().clear();
                    movieContainerAbandoned.getChildren().add(viewer);
                }
            }
        });



    }
}
