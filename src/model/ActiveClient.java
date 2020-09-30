package model;

import exceptions.CreditException;
import exceptions.DebitException;
import exceptions.PayException;
import exceptions.IDException;
import exceptions.PayedException;
import exceptions.insufficientFundsException;

public class ActiveClient extends Client implements Comparable<ActiveClient>{

    private BankAccount account;
    private long totalMoney;

    public ActiveClient(String name, String id, String phone, String address) {
        super(name, id, phone, address);
        this.account = new BankAccount();
        totalMoney = 0;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }   
    
    public void openABankAccount(BankAccount newBA){
        
        setAccount(newBA);
    }
    
    public void addToBackUp(){
        
        account.addToBackUp(account);
        totalMoney = totalMoney();
    }
    
    public void undo(){
        
        BankAccount backUp = account.undo();
        account = backUp;
        totalMoney = totalMoney();
    }
    
    public void addCard(Card newC){
        
        account.addCard(newC);
    }
    
    public void deleteCard(int cardId) throws IDException{
        
        account.deleteCard(cardId);
        totalMoney = totalMoney();
    }
    
    public void payCardCash(int cardId, long amount) throws Exception,PayedException,IDException, PayException{
        
        account.payCardCash(cardId, amount);
        totalMoney = totalMoney();
    }
    
    public void payCardDebit(int cardId, int cardDebitId, long amount) throws PayException,PayedException,IDException,insufficientFundsException,CreditException{
        
        account.payCardDebit(cardId, cardDebitId, amount);
        totalMoney = totalMoney();
    }
    
    public void withdraw(int cardId, long amount) throws IDException, insufficientFundsException, DebitException{   
        
        account.withdraw(cardId, amount);
        totalMoney = totalMoney();
    }
    
    public void deposit(int cardId, long amount) throws IDException, DebitException{
        
        account.deposit(cardId, amount);
        totalMoney = totalMoney();
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
    
    public long totalMoney(){
        
        return account.totalDebitMoney();
    }

    @Override
    public int compareTo(ActiveClient o) {
        return Integer.parseInt(this.getId())-Integer.parseInt(o.getId());
    }
    
    public int compareToByName(ActiveClient o){
        
        return this.getName().compareTo(o.getName());
    }
    
    public int compareToByPhone(ActiveClient o){
        return this.getPhone().compareTo(o.getPhone());
    }

    public long compareToTotalMoney(ActiveClient o){
        return this.totalMoney-o.totalMoney;
    }
}
