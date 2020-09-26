package model;

import exceptions.PayException;
import exceptions.CreditException;
import exceptions.DebitException;
import exceptions.PayException;
import exceptions.IDException;
import exceptions.PayedException;
import exceptions.insufficientFundsException;

public class ActiveClient extends Client{

    private BankAccount account;

    public ActiveClient(BankAccount account, String name, String id, String phone, String address) {
        super(name, id, phone, address);
        this.account = account;
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
    
    public void deleteCard(int cardId){
        
        account.deleteCard(cardId);
    }
    
    public void payCardCash(int cardId, long amount) throws Exception,PayedException,IDException{
        
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

}
