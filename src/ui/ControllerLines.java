package ui;

import exceptions.IDException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Bank;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLines implements Initializable {

    @FXML
    private final ControllerMenu cm;

    @FXML
    private VBox vbLine1;

    @FXML
    private VBox vbLine2;

    @FXML
    private TextField linesTdId;


    public ControllerLines(ControllerMenu controllerMenu) {
        cm = controllerMenu;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refresh();
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
        try {
            Bank b = cm.getB();
            String s = linesTdId.getText();
            b.addToLine(s);
            refresh();
        } catch (IDException e) {
            alert1(e);
        }
    }

    private void refresh() {
        Bank b = cm.getB();
        String s = b.showLine();
        String[] split = s.split(";");
        vbLine1.getChildren().clear();
        for (int i = 0; i < split.length; i++) {
            Label l = new Label();
            l.setPrefWidth(214);
            l.setFont(Font.font(20));
            l.setStyle("-fx-font-weight: bold");
            l.setAlignment(Pos.CENTER);
            l.setText(split[i]);
            vbLine1.getChildren().add(l);
        }
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void attendLine() {
        Bank b = cm.getB();
        b.attendLine();
        refresh();
    }

    public void alert1(Throwable e) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(e.toString());
        a.setContentText(e.getMessage());
        a.showAndWait();
    }

}
