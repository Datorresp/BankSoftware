package model;

import dataStructure.HashTable;
import dataStructure.Heap;
import dataStructure.GenericsQueue;
import exceptions.CreditException;
import exceptions.DebitException;
import exceptions.IDException;
import exceptions.PayException;
import exceptions.PayedException;
import exceptions.insufficientFundsException;

public class Bank {
   
    private final GenericsQueue<ActiveClient>line;
    private final GenericsQueue<ActiveClient>priorityLine;
    private final HashTable <String, ActiveClient> clients;
    private final HashTable <String, InactiveClient> inactiveClients;

    private Heap <Client> priority;

    private ActiveClient[]activeClients;

    
    public Bank(){
        
        line = new GenericsQueue<>();
        priorityLine = new GenericsQueue<>();
        clients = new HashTable<>();
        inactiveClients = new HashTable<>();
        activeClients = new ActiveClient[1000];
    }
    
    public void openABankAccount(String clientId, BankAccount newBA) throws IDException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.openABankAccount(newBA);
        }else{
            
            throw new IDException("ACTIVE CLIENT");            
        }
    }
    
    public void addToBackUp(String clientId) throws IDException{
        
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.addToBackUp();
        }else{
            
            throw new IDException("ACTIVE CLIENT");            
        }
    }
    
    public void undo(String clientId) throws IDException{
       
        ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            aux.undo();
        }else{
            
            throw new IDException("ACTIVE CLIENT");            
        }
    }
    
    public void addClient(ActiveClient newC){
        
        clients.insert(newC.getId(), newC);
        for (int i = 0; i < activeClients.length; i++) {
            
            if (activeClients[i]==null) {
                
                activeClients[i]=newC;
            }
        }
    }
    
    public void inactivateClient(String clientId, String cause) throws IDException{
        
        ActiveClient aux = clients.search(clientId);

        if (aux != null) {
            
            InactiveClient newIC = new InactiveClient(cause , aux.getName(), aux.getId(), aux.getPhone(), aux.getAddress(), aux.isDisabled(), aux.isPregnant(), aux.getGender(), aux.getAge());
            inactiveClients.insert(newIC.getId(), newIC);
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
        int priorityLevel = 0;
        
        if (aux.isPregnant()) {
        	priorityLevel ++;
		}
        if (aux.isDisabled()) {
			priorityLevel ++;	
		}
        if (aux.getAge() >= 60) {
			priorityLevel ++;
		}
        if (priorityLevel == 0) {
			line.offer(aux);
		}else {
		//	priority insert priority queue
		}
        
    }
    
    public void attendLine(){
        
        if (line.size() >= 1) {
            
            line.poll();
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
    
    public void heapSortId (Client [] c) {
    	Heap<Client> c1 = new Heap<Client>(0,0);
    	c1.setArray(c);
    	c1.heapSort();
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
    
    public String showCards(String clientId) throws IDException{
        
                ActiveClient aux = clients.search(clientId);
        
        if (aux != null) {
            
            return aux.showCards();
        }else{
            
            throw new IDException("ACTIVE CLIENT");
        }  
    }
    
    public String showLineStatus(){
        
        return "NORMAL LINE HAS " + line.size() + "AND THE NEXT USER IS: " + line.peek().toString();
    }
}
