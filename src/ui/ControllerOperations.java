package ui;

import exceptions.IDException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.ActiveClient;
import model.Bank;
import model.BankAccount;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerOperations implements Initializable {

    private final ControllerMenu cm;

    @FXML
    private TextField tfSearch;

    @FXML
    private TextField tfAddName;

    @FXML
    private TextField tfAddPhone;

    @FXML
    private TextField tfAddAddress;

    @FXML
    private TextField tfAddId;


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

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void searchClient() {
        String sr = tfSearch.getText();
        try {
            Bank b = cm.getB();
            ActiveClient ac = b.searchActiveClient(sr);

        } catch (IDException e) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle(e.toString());
            a.setContentText(e.getMessage() + "\n"
            + "DO YOU WANT TO CREATE A NEW ONE?");
            Optional<ButtonType> action = a.showAndWait();
            if (action.get() == ButtonType.OK){
                openAddClientView();
            }
        }
    }

    public void openAddClientView() {
        try {
            BorderPane gp = cm.getBp();
            FXMLLoader fl = new FXMLLoader(getClass().getResource("AddClient.fxml"));
            fl.setController(this);
            Pane pane = fl.load();
            gp.setCenter(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void addNewClient() throws IOException {
        Bank b = cm.getB();
        String name = tfAddName.getText();
        String id = tfAddId.getText();
        String phone = tfAddPhone.getText();
        String address = tfAddAddress.getText();

        if (name.equals("") || id.equals("") || phone.equals("") || address.equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Empty field");
            a.setContentText("Something is empty");
            a.showAndWait();
        }else {
            b.addClient(new ActiveClient(new BankAccount(), name, id, phone, address));
            goBack();
        }
    }
}
