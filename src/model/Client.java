package model;

import java.util.ArrayList;
import java.util.Date;

public class Client {

    private String name;
    private String id;
    private String BankAccount;
    private ArrayList<String> creditDebitCards;
    private Date paymentDay;
    private Date dateOfAdmission;

    private BackUp<Client> backUp;

    public Client(String name, String id) {
        this.name = name;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(String bankAccount) {
        BankAccount = bankAccount;
    }

    public ArrayList<String> getCreditDebitCards() {
        return creditDebitCards;
    }

    public void setCreditDebitCards(ArrayList<String> creditDebitCards) {
        this.creditDebitCards = creditDebitCards;
    }

    public Date getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Date paymentDay) {
        this.paymentDay = paymentDay;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public BackUp<Client> getBackUp() {
        return backUp;
    }

    public void setBackUp(BackUp<Client> backUp) {
        this.backUp = backUp;
    }

    public void makeBackUp() {
        backUp.apilar(this);
    }
}
