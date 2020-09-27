package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMenu implements Initializable {

    private final ControllerUser controllerUser;
    private final ControllerLines controllerLines;
    private final ControllerOperations controllerOperations;

    @FXML
    private BorderPane bp;

    public ControllerMenu() {
        controllerLines = new ControllerLines(this);
        controllerUser = new ControllerUser(this);
        controllerOperations = new ControllerOperations(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public BorderPane getBp() {
        return bp;
    }
    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void lines() throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("Lines.fxml"));
        fl.setController(controllerLines);
        Pane pane = fl.load();
        bp.setCenter(pane);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void users() throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("Users.fxml"));
        fl.setController(controllerUser);
        Pane pane = fl.load();
        bp.setCenter(pane); 
    }
    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void operations() throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("Search.fxml"));
        fl.setController(controllerOperations);
        Pane pane = fl.load();
        bp.setCenter(pane);
    }
}
