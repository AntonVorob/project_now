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
    public TextField searchTextField;
    public VBox movieContainer;
    public TabPane foldersTabPane;

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
                // TODO: добавить во вкладку отображатель кина по категориям (см. выше)
                if (newValue.equals(0)) {

                }
                if (newValue.equals(1)) {

                }
                // ...
            }
        });



    }
}
