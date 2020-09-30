package ui;

import exceptions.DebitException;
import exceptions.IDException;
import exceptions.insufficientFundsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    private ActiveClient actualClient;

    @FXML
    private Pane pPanel;

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

    @FXML
    private ComboBox<String> cbOperations;

    ObservableList<String> olOperations = FXCollections.observableArrayList("Withdraw", "Deposit", "Account Cancellation", "Card payment", "Undo operations");

    //wt
    @FXML
    private Label wtLbIdentification;

    @FXML
    private ComboBox<String> wtCbCards;

    private ObservableList<String> wtOlCards = FXCollections.observableArrayList();

    @FXML
    private TextField wtTfAmount;


    public ControllerOperations(ControllerMenu controllerMenu) {
        this.cm = controllerMenu;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (wtLbIdentification != null) {
            wtLbIdentification.setText(actualClient.getId());
        }
        if (wtCbCards != null){
            try {
                Bank b = cm.getB();
                String s = b.showCards(actualClient.getId());
                String[] split = s.split(";");
                for (int i = 0; i < split.length; i++) {
                    wtOlCards.add(split[i]);
                }
                wtCbCards.setItems(wtOlCards);
            } catch (IDException e) {
                e.printStackTrace();
            }
        }
    }
    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void goBack() throws IOException {
        BorderPane bp = cm.getBp();
        FXMLLoader fl = new FXMLLoader(getClass().getResource("Bank.fxml"));
        fl.setController(cm);
        Pane p = fl.load();
        bp.setCenter(p);
    }

    // Search

    @SuppressWarnings({"unused", "RedundantSuppression", "OptionalGetWithoutIsPresent"})
    public void searchClient() {
        String sr = tfSearch.getText();
        try {
            Bank b = cm.getB();
            actualClient = b.searchActiveClient(sr);
            cbOperations.setDisable(false);
            cbOperations.setItems(olOperations);
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

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void openPerspectivesOperations() throws IOException {
        String s = cbOperations.getValue();
        if (s.equals("Withdraw")) {
            FXMLLoader fl = new FXMLLoader(getClass().getResource("Withdraw.fxml"));
            fl.setController(this);
            Pane pane = fl.load();
            pPanel.getChildren().clear();
            pPanel.getChildren().add(pane);
        }else if (s.equals("Deposit")) {
            FXMLLoader fl = new FXMLLoader(getClass().getResource("Deposit.fxml"));
            fl.setController(this);
            Pane pane = fl.load();
            pPanel.getChildren().clear();
            pPanel.getChildren().add(pane);
        }else if (s.equals("Account Cancellation")) {
            FXMLLoader fl = new FXMLLoader(getClass().getResource("AccountCancellation.fxml"));
            fl.setController(this);
            Pane pane = fl.load();
            pPanel.getChildren().clear();
            pPanel.getChildren().add(pane);
        }else if (s.equals("Card payment")){
            FXMLLoader fl = new FXMLLoader(getClass().getResource("CardPayment.fxml"));
            fl.setController(this);
            Pane pane = fl.load();
            pPanel.getChildren().clear();
            pPanel.getChildren().add(pane);
        }else if (s.equals("Undo operations")){
            FXMLLoader fl = new FXMLLoader(getClass().getResource("UndoOperations.fxml"));
            fl.setController(this);
            Pane pane = fl.load();
            pPanel.getChildren().clear();
            pPanel.getChildren().add(pane);
        }
    }

    private void openAddClientView() {
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

    //AddClient

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void addNewClient() throws IOException {
        Bank b = cm.getB();
        String name = tfAddName.getText();
        String id = tfAddId.getText();
        String phone = tfAddPhone.getText();
        String address = tfAddAddress.getText();
        //pedir disable, pregnant, gender(constante) y age

        if (name.equals("") || id.equals("") || phone.equals("") || address.equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Empty field");
            a.setContentText("Something is empty");
            a.showAndWait();
        }else {
        //    b.addClient(new ActiveClient(name, id, phone, address, disabled, pregnant, gender, age));
            goBack();
        }
    }

    //wt
    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void withdraw() {
        try {
            Bank b = cm.getB();
            String id = wtLbIdentification.getText();
            int cardId = Integer.parseInt(wtCbCards.getValue());
            Long amount = Long.parseLong(wtTfAmount.getText());
            b.withdraw(id, cardId, amount);
        } catch (DebitException e) {
            e.printStackTrace();
        } catch (insufficientFundsException e) {
            e.printStackTrace();
        } catch (IDException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
