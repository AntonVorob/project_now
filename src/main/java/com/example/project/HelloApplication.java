package com.example.project;

import com.example.project.gui.MovieCardViewer;
import com.example.project.movies.Movie;
import com.example.project.movies.MovieService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class HelloApplication extends Application {

    static MovieService movieService;

    private static ConfigurableApplicationContext context;

    @Override
    public void start(Stage stage) throws IOException {

        context = SpringApplication.run(HelloApplication.class);
        movieService = context.getBean(MovieService.class);

        // TODO: project.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("example.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 545);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        MovieCardViewer x = new MovieCardViewer();
        x.setMovies(List.of(new Movie[]{new Movie("Здравствуйте, я ваша тетя!")}));
        ((HBox) scene.getRoot()).getChildren().add(x);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        //context.close();
    }


    public static void main(String[] args) {
        launch();
    }
}