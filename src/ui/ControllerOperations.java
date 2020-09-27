package ui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerOperations implements Initializable {

    private final ControllerMenu cm;

    public ControllerOperations(ControllerMenu controllerMenu) {
        this.cm = controllerMenu;
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
}
