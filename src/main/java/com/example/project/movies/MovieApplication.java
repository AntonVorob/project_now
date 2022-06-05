package com.example.project.movies;

import com.example.project.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieApplication extends Application {

    static MovieService movieService = new MovieService();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Hello!");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("project.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}