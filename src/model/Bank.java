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
import java.util.ArrayList;

public class Bank {
   
    private GenericsQueue<ActiveClient>line;
    private final HashTable <String, ActiveClient> clients;
    private final HashTable <String, InactiveClient> inactiveClients;
    private final Heap <Client> priority;
    private ArrayList<ActiveClient> activeClients ;
    
    public Bank(){
        
        line = new GenericsQueue<>();
        priority = new Heap<>(0, 0);
        clients = new HashTable<>();
        inactiveClients = new HashTable<>();
        activeClients = new ArrayList<>();
        ActiveClient ac = new ActiveClient("Juan", "1006", "301236541", "cll 23 # 102-123", false, false, 1, 20);
        ActiveClient ac1 = new ActiveClient("Diego", "1008", "301285411", "cll 10 # 10-13", false, false, 1, 23);
        ActiveClient ac2 = new ActiveClient("Isa", "1009", "306576541", "cll 26 # 112-323", false, false, 2, 20);
        addClient(ac);
        addClient(ac1);
        addClient(ac2);
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
        activeClients.add(newC);
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
    
    private void swap(int i, int j) {
        ActiveClient aux = activeClients.get(i);
        activeClients.set(i, activeClients.get(j));
        activeClients.set(j, aux);
    }

    
    public void heapSortId (Client [] c) {
    	Heap<Client> c1 = new Heap<Client>(0,0);
    	c1.setArray(c);
    	c1.heapSort();
    }
    
        public void quickSortPhone(){

        int n = activeClients.size();
        qsort(0, n-1);
    }

    public void qsort(int low, int high){

        if (low < high) {

            int part = partition(low, high);
            qsort(low, part-1);
            qsort(part+1, high);
        }
    }

    private int partition(int low, int high){

        ActiveClient aux = activeClients.get(high);
        int i = low;

        for (int j = low; j < high; j++) {

            if (activeClients.get(j).compareToByPhone(aux) < 0) {

                swap(i, j);
                i++;
            }
        }

        swap(i, high);
        return i;
    }

    private void BubbleSort(){

        int n = activeClients.size();

        for(int i = 0; i < n; i++) {

            for(int j = 1; j < (n-i); j++) {

                if(activeClients.get(j-1).compareToByName(activeClients.get(j)) > 0) {

                    swap(i, j);
                }
            }
        }
    } 

    private ActiveClient[] MergeSortTotalMoney(ActiveClient[] a) {

        int n = a.length;
        ActiveClient[] b = new ActiveClient[n];
        a = mSort(a, 0,n-1, b);
        return a;
    }   

    private ActiveClient[] mSort(ActiveClient[] clientA, int low, int high, ActiveClient[] clientB) {

        if(low < high) {

            int mid = (low + high)/2;
            mSort(clientA, low, mid, clientB);
            mSort(clientA, mid+1, high, clientB);
            mergeTotalMoney(clientA, low, mid, high, clientB);
        }
        return clientA;
    }   

    private ActiveClient[] mergeTotalMoney(ActiveClient[] clientA, int low, int mid, int high, ActiveClient[] clientB){

        int i = low;
        int j = mid+1;
        int k = low;
        while(i<=mid && j <= high){

            if(clientA[i].compareToTotalMoney(clientA[j]) < 0){

                clientB[k] = clientA[i];
                i++;
            }else{

                clientB[k] = clientA[j];
                j++;
            }
            k++;
        }while(i <= mid){

            clientB[k] = clientA[i];
            i++;
            k++;
        }while(j <= high){

            clientB[k] = clientA[j];
            j++;
            k++;
        }for(k=low; k <= high; k++){

            clientA[k] = clientB[k];
        }

        return clientA;
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

    public String showDebitCards(String clientId) throws IDException {
        ActiveClient aux = clients.search(clientId);
        if (aux != null) {
            return aux.showDebitCards();
        }else{
            throw new IDException("ACTIVE CLIENT");
        }
    }
    
    public String showLineStatus(){
        
        return "NORMAL LINE HAS " + line.size() + "AND THE NEXT USER IS: " + line.peek().toString();
    }

    public String showLine() {
        String ret = "";
        GenericsQueue<ActiveClient> save = new GenericsQueue<>();
        ActiveClient ac = line.peek();
        line.poll();
        while (ac != null) {
            ret += ac.getId() +" "+ ac.getName()+";";
            save.offer(ac);
            ac = line.peek();
            line.poll();
        }
        line = save;
        return ret;
    }
}
