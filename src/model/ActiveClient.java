package model;

import exceptions.CreditException;
import exceptions.DebitException;
import exceptions.PayException;
import exceptions.IDException;
import exceptions.PayedException;
import exceptions.insufficientFundsException;

public class ActiveClient extends Client{

    private BankAccount account;

    public ActiveClient(String name, String id, String phone, String address, boolean disabled, boolean pregnant, int gender, int age) {
        super(name, id, phone, address, disabled, pregnant, gender, age);
        this.account = new BankAccount();
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
    
    public void openABankAccount(BankAccount newBA){
        
        setAccount(newBA);
    }
    
    public void addToBackUp(){
        
        account.addToBackUp(account);
    }
    
    public void undo(){
        
        BankAccount backUp = account.undo();
        account = backUp;
    }
    
    public void addCard(Card newC){
        
        account.addCard(newC);
    }
    
    public void deleteCard(int cardId) throws IDException{
        
        account.deleteCard(cardId);
    }
    
    public void payCardCash(int cardId, long amount) throws Exception,PayedException,IDException, PayException{
        
        account.payCardCash(cardId, amount);
    }
    
    public void payCardDebit(int cardId, int cardDebitId, long amount) throws PayException,PayedException,IDException,insufficientFundsException,CreditException{
        
        account.payCardDebit(cardId, cardDebitId, amount);
    }
    
    public void withdraw(int cardId, long amount) throws IDException, insufficientFundsException, DebitException{   
        
        account.withdraw(cardId, amount);
    }
    
    public void deposit(int cardId, long amount) throws IDException, DebitException{
        
        account.deposit(cardId, amount);
    }

    @Override
    public String toString() {
        return "ActiveClient{" + "account=" + account + '}';
    }
    
    public String showClientInfo(){
        
        return super.toString() + '\n';
    }
    
    public String showCards(){
        
        return account.showCards();
    }

}
