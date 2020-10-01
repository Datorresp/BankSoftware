package ui;

import exceptions.*;
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
import model.Card;
import model.Client;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerOperations implements Initializable {

    private final ControllerMenu cm;

    private static int cardNumbers = 100000000;

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

    ObservableList<String> olOperations = FXCollections.observableArrayList("Add New Card","Withdraw", "Deposit", "Account Cancellation", "Card payment", "Undo operations");

    @FXML
    private CheckBox addDisable;

    @FXML
    private CheckBox addPregnant;

    @FXML
    private ComboBox<String> cbAddGender;

    private final ObservableList<String> olAddcbGender = FXCollections.observableArrayList("Man", "Woman");

    @FXML
    private TextField tfAddAge;


    //wt
    @FXML
    private Label wtLbIdentification;

    @FXML
    private ComboBox<String> wtCbCards;

    @FXML
    private ComboBox<String> wtCbCards1;

    @FXML
    private TextField wtTfAmount;

    //ac

    @FXML
    private TextArea acTextArea;

    //cp

    @FXML
    private RadioButton cpRbCard;

    @FXML
    private RadioButton cpRbCash;

    //acn
    @FXML
    private Label ancCardId;

    @FXML
    private RadioButton ancDebit;

    @FXML
    private RadioButton ancCredit;

    @FXML
    private TextField ancBadge;


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
                ObservableList<String> wtOlCards = FXCollections.observableArrayList();
                Bank b = cm.getB();
                String s = b.showCards(actualClient.getId());
                String[] split = s.split(";");
                Collections.addAll(wtOlCards, split);
                wtCbCards.setItems(wtOlCards);
            } catch (IDException e) {
                e.printStackTrace();
            }
        }
        if (wtCbCards1 != null){
            try {
                ObservableList<String> wtOlCards = FXCollections.observableArrayList();
                Bank b = cm.getB();
                String s = b.showDebitCards(actualClient.getId());
                String[] split = s.split(";");
                Collections.addAll(wtOlCards, split);
                wtCbCards1.setItems(wtOlCards);
            } catch (IDException e) {
                e.printStackTrace();
            }
        }
        if (ancCardId != null) {
            ancCardId.setText(cardNumbers +"");
        }
        if (cbAddGender != null) {
            cbAddGender.setItems(olAddcbGender);
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

    public void clear() {
        pPanel.getChildren().clear();
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
        switch (s) {
            case "Add New Card": {
                FXMLLoader fl = new FXMLLoader(getClass().getResource("AddNewCard.fxml"));
                fl.setController(this);
                Pane pane = fl.load();
                pPanel.getChildren().clear();
                pPanel.getChildren().add(pane);
                break;
            }
            case "Withdraw": {
                FXMLLoader fl = new FXMLLoader(getClass().getResource("Withdraw.fxml"));
                fl.setController(this);
                Pane pane = fl.load();
                pPanel.getChildren().clear();
                pPanel.getChildren().add(pane);
                break;
            }
            case "Deposit": {
                FXMLLoader fl = new FXMLLoader(getClass().getResource("Deposit.fxml"));
                fl.setController(this);
                Pane pane = fl.load();
                pPanel.getChildren().clear();
                pPanel.getChildren().add(pane);
                break;
            }
            case "Account Cancellation": {
                FXMLLoader fl = new FXMLLoader(getClass().getResource("AccountCancellation.fxml"));
                fl.setController(this);
                Pane pane = fl.load();
                pPanel.getChildren().clear();
                pPanel.getChildren().add(pane);
                break;
            }
            case "Card payment": {
                FXMLLoader fl = new FXMLLoader(getClass().getResource("CardPayment.fxml"));
                fl.setController(this);
                Pane pane = fl.load();
                pPanel.getChildren().clear();
                pPanel.getChildren().add(pane);
                break;
            }
            case "Undo operations": {
                FXMLLoader fl = new FXMLLoader(getClass().getResource("UndoOperations.fxml"));
                fl.setController(this);
                Pane pane = fl.load();
                pPanel.getChildren().clear();
                pPanel.getChildren().add(pane);
                break;
            }
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
        try {
            Bank b = cm.getB();
            String name = tfAddName.getText();
            String id = tfAddId.getText();
            String phone = tfAddPhone.getText();
            String address = tfAddAddress.getText();
            boolean dis = addDisable.isSelected();
            boolean preg = addPregnant.isSelected();
            int gender = 0;
            if (cbAddGender.getValue().equalsIgnoreCase("Man"))
                gender = Client.MAN;
            else if (cbAddGender.getValue().equalsIgnoreCase("Woman"))
                gender = Client.WOMAN;
            int age = Integer.parseInt(tfAddAge.getText());

            if (name.equals("") || id.equals("") || phone.equals("") || address.equals("")) {
                alert2();
            } else {
                b.addClient(new ActiveClient(name, id, phone, address, dis, preg, gender, age));
                goBack();
            }
            b.addToBackUp(id);
        }catch (NumberFormatException e) {
            alert2();
        } catch (IDException e) {
            alert1(e);
        }
    }

    //wt
    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void withdraw() {
        try {
            Bank b = cm.getB();
            String id = wtLbIdentification.getText();
            int cardId = Integer.parseInt(wtCbCards.getValue());
            long amount = Long.parseLong(wtTfAmount.getText());
            b.withdraw(id, cardId, amount);
            b.addToBackUp(id);
            clear();
        } catch (DebitException | insufficientFundsException | IDException e) {
           alert1(e);
        } catch (NumberFormatException e) {
           alert2();
        }
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void deposit() {
        try {
            Bank b = cm.getB();
            String id = wtLbIdentification.getText();
            int cardId = Integer.parseInt(wtCbCards.getValue());
            long amount = Long.parseLong(wtTfAmount.getText());
            b.deposit(id, cardId, amount);
            b.addToBackUp(id);
            clear();
        } catch (IDException | DebitException e ) {
            alert1(e);
        } catch (NumberFormatException e) {
            alert2();
        }
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void inactiveClient() {
        try {
            Bank b = cm.getB();
            String id = wtLbIdentification.getText();
            String cause = acTextArea.getText();
            b.inactivateClient(id, cause);
            clear();
        } catch (IDException e) {
            alert1(e);
        }
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void cardPayment() {
        try {
            Bank b = cm.getB();
            String id = actualClient.getId();
            int cardId = Integer.parseInt(wtCbCards.getValue());
            int debitId = 0;
            if (!wtCbCards1.getValue().equals(""))
                 debitId = Integer.parseInt(wtCbCards1.getValue());
            long amount = Long.parseLong(wtTfAmount.getText());
            if (cpRbCard.isSelected()) {
                if (wtCbCards1.getValue().equals(""))
                    alert2();
                else
                    b.payCardDebit(id, cardId, debitId, amount);
            }else if (cpRbCash.isSelected()){
                b.payCardCash(id, cardId, amount);
            }
            b.addToBackUp(id);
        } catch (PayedException | IDException | insufficientFundsException | CreditException | PayException | NumberFormatException e) {
            alert1(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void toggle() {
        wtCbCards1.setDisable(!wtCbCards1.isDisable());
        wtCbCards1.setValue("");
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void undo() {
        try {
            Bank b = cm.getB();
            b.undo(wtLbIdentification.getText());
            clear();
        } catch (IDException e) {
            alert1(e);
        }
    }

    public void alert1 (Throwable e) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(e.toString());
        a.setContentText(e.getMessage());
        a.showAndWait();
    }

    public void alert2 () {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Error in the given data");
        a.setContentText("Some given data was wrong");
        a.showAndWait();
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    public void addNewCard() {
        try {
            Bank b = cm.getB();
            int idCard = cardNumbers;
            cardNumbers += 1;
            String id = actualClient.getId();
            int type = -1;
            if (ancDebit.isSelected()) {
                type = Card.DEBIT;
            }else if (ancCredit.isSelected()){
                type = Card.CREDIT;
            }
            String divise = ancBadge.getText();
            b.addCard(id, new Card(type, 0, false, idCard, divise));
            b.addToBackUp(id);
            clear();
        } catch (NumberFormatException e) {
            alert2();
        } catch (IDException e) {
            alert1(e);
        }
    }
}
