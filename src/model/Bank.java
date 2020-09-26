package model;

import dataStructure.HashTable;
import dataStructure.Queue;
import exceptions.CreditException;
import exceptions.DebitException;
import exceptions.IDException;
import exceptions.PayException;
import exceptions.PayedException;
import exceptions.insufficientFundsException;

public class Bank {
   
    private Queue<ActiveClient>line;
    private Queue<ActiveClient>priorityLine;
    private HashTable <String, ActiveClient> clients;
    private HashTable <String, ActiveClient> inactiveClients;
    
    public Bank(){
        
        line = new Queue<>();
        priorityLine = new Queue<>();
        clients = new HashTable<>();
        inactiveClients = new HashTable<>();
    }
    
    public void addClient(ActiveClient newC){
        
        clients.insert(newC.getId(), newC);
    }
    
    public void inactivateClient(String clientId) throws IDException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            inactiveClients.insert(clientId, aux);
            clients.delete(clientId);
        }else{
            
            throw new IDException("ACTIVE CLIENT");
            
        }
    }
    
    public ActiveClient searchActiveClient(String clientId) throws IDException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            return aux;
        }else{
            
            throw new IDException("ACTIVE CLIENT");

        }
    }
    
    public void addToLine(String clientId) throws IDException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            line.add(aux);
        }else{
            
            throw new IDException("ACTIVE CLIENT");            
        }
    }
    
    public void attendLine(){
        
        if (line.size() >= 1) {
            
            line.delete();
        }else{
            
            System.out.println("NO ONE IN THE LINE");
        }
    }
    
    public void addCard(String clientId, Card newC) throws IDException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.addCard(newC);
        }else{
            
            throw new IDException("ACTIVE CLIENT");
        }
    }
    
    public void deleteCard(String clientId, int cardID) throws IDException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.deleteCard(cardID);
        }else{
            
            throw new IDException("ACTIVE CLIENT");
        }        
    }
    
    public void payCardCash(String clientId, int cardId, long amount) throws Exception,PayedException,IDException, PayException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.payCardCash(cardId, amount);
        }else{
            
            throw new IDException("ACTIVE CLIENT");
        }        
    }
    
    public void payCardDebit(String clientId, int cardId, int cardDebitId, long amount) throws PayException,PayedException,IDException,insufficientFundsException,CreditException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.payCardDebit(cardId, cardDebitId, amount);
        }else{
            
            throw new IDException("ACTIVE CLIENT");
        }        
    }
    
    public void withdraw(String clientId, int cardId, long amount) throws IDException, insufficientFundsException, DebitException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.withdraw(cardId, amount);
        }else{
            
            throw new IDException("ACTIVE CLIENT");
        }
    }
    
    public void deposit(String clientId, int cardId, long amount) throws IDException, DebitException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.deposit(cardId, amount);
        }else{
            
            throw new IDException("ACTIVE CLIENT");
        }  
    }
    
    public String showClientInfo(){
        
        String msj = "";
        
        return msj;
    }
    
    public String showLineStatus(){
        
        return "NORMAL LINE HAS " + line.size() + "AND THE NEXT USER IS: " + line.peek().toString();
    }
}
