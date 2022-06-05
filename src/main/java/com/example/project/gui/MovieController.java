//package com.example.project.gui;
//
//import com.example.project.movies.Movie;
//import com.example.project.movies.MovieApplication;
//import com.example.project.movies.MovieService;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//
//import javafx.collections.ObservableList;
//import javafx.collections.FXCollections;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Objects;
//import java.util.ResourceBundle;
//
//
//
//
//public class MovieController implements Initializable {
//
//    public final ObservableList<Movie> movies = FXCollections.observableArrayList();
//
//    public ListView listviewvp;
//    public  HBox hboxvp;;
//
//    MovieService movieService = MovieApplication.movieService;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
////        ChatDialog A = new ChatDialog();
////        A.name = "Hermione";
////        A.message = "It's leviOsa, not leviosA!";
////
////        ChatDialog B = new ChatDialog();
////        B.name = "Margarita";
////        B.message = "It is vodka, isn't it?";
////
////
////        movies.addAll(A, B);
//
//        movies.addAll(this.movieService.getMovies());
//
//
//        this.listviewvp.setItems(movies);
//
//        this.listviewvp.setCellFactory(lv -> {
//            ListCell<Movie> cell = new ListCell<ChatDialog>() {
//                @Override
//                protected void updateItem(ChatDialog item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty) {
//                        return;
//                    }
//                    ChatBox c = new ChatBox();
//                    c.setDialog(item);
//                    setGraphic(c);
//                }
//            };
//            cell.setOnMouseClicked(e -> {
//                if (!cell.isEmpty()) {
//                    try {
//                        this.SelectedVP(e, (ChatDialog) listviewvp.getSelectionModel().getSelectedItem());
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    e.consume();
//                }
//            });
//            return cell;
//        });
//    }
//
//    public void SelectedVP(MouseEvent mouseEvent, ChatDialog selectedItem) throws IOException {
//        MovieCard card = new MovieCard();
//        card.setMovieName(selectedItem.name);
//        this.hboxvp.getChildren().clear();
//        this.hboxvp.getChildren().add(card);
//
//        if (Objects.equals(selectedItem.name, "Hermione")) {
//            Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//            appStage.setScene(new Scene(new MovieCard(), 500, 500));
//            appStage.show();
//        }
//    }
//
//
//}