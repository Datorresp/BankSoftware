package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLines implements Initializable {

    @FXML
    private final ControllerMenu cm;

    @FXML
    private VBox linea1;
    @FXML
    private Label contLinea1;
    @FXML
    private VBox linea2;
    @FXML
    private Label contLinea2;

    public ControllerLines(ControllerMenu controllerMenu) {
        cm = controllerMenu;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void goBack() throws IOException {
        BorderPane bp = cm.getBp();
        FXMLLoader fl = new FXMLLoader(getClass().getResource("Bank.fxml"));
        fl.setController(cm);
        Pane p = fl.load();
        bp.setCenter(p);
    }
    
    
        @SuppressWarnings({"unused", "RedundantSuppression"})
    public void addToLine() {

    }
    
}
