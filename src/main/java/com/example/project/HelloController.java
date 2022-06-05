//package com.example.project;
//
//
//import com.example.project.gui.MovieCard;
//import com.example.project.movies.MovieService;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//import javafx.collections.ObservableList;
//import javafx.collections.FXCollections;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.HBox;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Objects;
//import java.util.ResourceBundle;
//public class HelloController implements Initializable {
//    @FXML
//    private ListView listviewu;
//    @FXML
//    private ListView listviewvp;
//    @FXML
//    private ListView listviewmain;
//    @FXML
//    private ListView listviewp;
//    @FXML
//    private ListView listviewB;
//    @FXML
//    private ListView listviewO;
//    @FXML
//    private HBox hboxu;
//    @FXML
//    private HBox hboxvp;
//    @FXML
//    private HBox hboxp;
//    @FXML
//    private HBox hboxo;
//    @FXML
//    private HBox main;
//    @FXML
//    private HBox hboxb;
//    public final ObservableList<ChatDialog> Main = FXCollections.observableArrayList();
//    public final ObservableList<ChatDialog> U = FXCollections.observableArrayList();
//    public final ObservableList<ChatDialog> VP = FXCollections.observableArrayList();
//    public final ObservableList<ChatDialog> Postponed= FXCollections.observableArrayList();
//    public final ObservableList<ChatDialog> Abandoned = FXCollections.observableArrayList();
//    public final ObservableList<ChatDialog> Plane = FXCollections.observableArrayList();
//    MovieService movieService = HelloApplication.movieService;
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        U.addAll(new ChatDialog());
//        this.listviewu.setItems(U);
//        this.listviewu.setCellFactory(lv -> {
//            ListCell<ChatDialog> cell = new ListCell<ChatDialog>() {
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
//                        this.SelectedU(e);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    e.consume();
//                }
//            });
//            return cell;
//        });
//
//
//
//        Main.addAll(new ChatDialog(),new ChatDialog());
//        this.listviewmain.setItems(Main);
//
//        this.listviewmain.setCellFactory(lv -> {
//            ListCell<ChatDialog> cell = new ListCell<ChatDialog>() {
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
//                        this.SelectedMain(e);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    e.consume();
//                }
//            });
//            return cell;
//        });
//
//
//
//        Plane.addAll(new ChatDialog());
//        this.listviewp.setItems(Plane);
//
//        this.listviewp.setCellFactory(lv -> {
//            ListCell<ChatDialog> cell = new ListCell<ChatDialog>() {
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
//                        this.SelectedPlane(e);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    e.consume();
//                }
//            });
//            return cell;
//        });
//
//
//        Abandoned.addAll(new ChatDialog());
//        this.listviewB.setItems(Abandoned);
//
//        this.listviewB.setCellFactory(lv -> {
//            ListCell<ChatDialog> cell = new ListCell<ChatDialog>() {
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
//                        this.SelectedAbandoned(e);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    e.consume();
//                }
//            });
//            return cell;
//        });
//
//
//
//        Postponed.addAll(new ChatDialog());
//        this.listviewO.setItems(Postponed);
//
//        this.listviewO.setCellFactory(lv -> {
//            ListCell<ChatDialog> cell = new ListCell<ChatDialog>() {
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
//                        this.SelectedPostponed(e);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    e.consume();
//                }
//            });
//            return cell;
//        });
//
//
//        VP.addAll(this.movieService.getMovies());
//        this.listviewvp.setItems(VP);
//
//        this.listviewvp.setCellFactory(lv -> {
//            ListCell<ChatDialog> cell = new ListCell<ChatDialog>() {
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
//                        this.SelectedVP(e,(ChatDialog) listviewvp.getSelectionModel().getSelectedItem());
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
//
//
//    public void SelectedVP(MouseEvent mouseEvent, ChatDialog selectedItem) throws IOException {
//
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
//        System.out.println("в планах");
//        //Thread.sleep(5000);
//
//    }
//
//
//
//    public void SelectedPostponed(MouseEvent mouseEvent ) throws IOException {//отложенные
//
//        if (this.listviewO.getSelectionModel().getSelectedItem() == null) {
//            return;
//        }
//
//        System.out.println("отложенные");
//        //Thread.sleep(5000);
//
//    }
//
//    public void SelectedMain(MouseEvent mouseEvent) throws IOException {//главная
//
//        if (this.listviewmain.getSelectionModel().getSelectedItem() == null) {
//            return;
//        }
//
//        System.out.println("Куда отправим фильм");
//        //Thread.sleep(5000);
//
//    }
//
//    public void SelectedAbandoned(MouseEvent mouseEvent) throws IOException {//брошенно
//
//        if (this.listviewB.getSelectionModel().getSelectedItem() == null) {
//            return;
//        }
//
//        System.out.println("Брошенно");
//        //Thread.sleep(5000);
//
//    }
//
//    public void SelectedPlane(MouseEvent mouseEvent) throws IOException {//
//
//        if (this.listviewp.getSelectionModel().getSelectedItem() == null) {
//            return;
//        }
//
//        System.out.println("Просмотренно");
//        //Thread.sleep(5000);
//
//    }
//
//
//    public void SelectedU(MouseEvent mouseEvent) throws IOException {//избранное
//
//        if (this.listviewu.getSelectionModel().getSelectedItem() == null) {
//            return;
//        }
//
//        System.out.println("В избранном");
//        //Thread.sleep(5000);
//
//    }
//}
//
////    public void colorSelected(MouseEvent mouseEvent) {
////        String colorName = (String) this.listviewvp.getSelectionModel().getSelectedItem();
////        Color color = Color.ROSYBROWN;
////        if (colorName.equals("Harry Potter")) {
////            color = Color.RED;
////        } else if (colorName.equals("Star wars")) {
////            color = Color.YELLOW;
////        } else if (colorName.equals("1918")) {
////            color = Color.GREEN;
////        }
////        this.hboxvp.setBackground(new Background(
////                new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)
////        ));
////    }
////
////String colorName = (String) this.listviewu.getSelectionModel().getSelectedItem();
////    Color color = Color.ROSYBROWN;
////
////        if (colorName.equals("Red")) {
////                color = Color.RED;
////                } else if (colorName.equals("Yellow")) {
////                color = Color.YELLOW;
////                } else if (colorName.equals("Green")) {
////                color = Color.GREEN;
////                }
////
////                this.hboxu.setBackground(new Background(
////                new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)
////                ));
