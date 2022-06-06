package com.example.project;

import com.example.project.movies.MovieService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class MovieApplication extends Application {

    public static MovieService movieService;

    private static ConfigurableApplicationContext context;

    @Override
    public void start(Stage stage) throws IOException {

        context = SpringApplication.run(MovieApplication.class);
        movieService = context.getBean(MovieService.class);

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("example.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("project.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 545);
        stage.setTitle("Hello!");
        stage.setScene(scene);
//        MovieCardViewer x = new MovieCardViewer();
//        x.setMovies(List.of(new Movie[]{new Movie("Здравствуйте, я ваша тетя!")}));
//        ((HBox) scene.getRoot()).getChildren().add(x);
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