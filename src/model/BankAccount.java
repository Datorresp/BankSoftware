package model;

import exceptions.PayedException;
import exceptions.insufficientFundsException;
import exceptions.PayException;
import exceptions.IDException;
import exceptions.CreditException;
import dataStructure.Stack;
import exceptions.DebitException;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 */
public class BankAccount {

    private final ArrayList<Card> cards;
    private final Stack<BankAccount>backUp;

    public BankAccount() {
        cards = new ArrayList<>();
        backUp = new Stack<>();
    }
    
    public void addToBackUp(BankAccount newBA){
        
        backUp.push(newBA);
    }
    
    public BankAccount undo(){
        
        return backUp.pop();
    }
    
    
    public void addCard(Card newC){
        
        cards.add(newC);
    }
    
    public void deleteCard(int cardId) throws IDException{
        
        int i = findCard(cardId);
        Card cardToRemove = cards.get(i);
        if (cardToRemove != null) {
            
            if (cardToRemove.getId() == cardId) {
                
                cards.remove(i);
            }else{
                
                throw new IDException("CARD");
            }
        }else{
            
            throw new IDException("CARD");
        }
          
    }
    
    public void payCardCash(int cardId, long amount) throws PayException,PayedException,IDException{
        
        int i = findCard(cardId);
        Card aux = null;
        try {
            
            aux = cards.get(i);
            
        } catch (IndexOutOfBoundsException e) {
            
            throw  new IDException("CREDIT CARD");
        }
                
        if (aux != null) {
            if (aux.getType() == 2) {

                if (!aux.isPayed()) {

                    aux.setAmount(aux.getAmount() - amount);

                    if (aux.getAmount() == 0) {

                        aux.setPayed(true);
                        
                    }else if(aux.getAmount() > 0){
                        
                        System.out.println("PAYMENT HAS BEEN SUCCESSFUL!, THE MISSING BALANCE IS: " + aux.getAmount() + " " + aux.getDivise());
                        
                    }else{
                        
                        System.out.println("PAYMENT HAS BEEN SUCCESSFUL! THE REMAINING BALANCE IS: " + aux.getAmount()*-1 + " " + aux.getDivise());
                    }
                }else{

                    throw new PayedException();
                }
            }else{

                throw new PayException();
            }
        }else{
            
            throw new IDException("CREDIT CARD");
        }
        
    }
    
    public void payCardDebit(int cardId, int cardDebitId, long amount) throws PayException,PayedException,IDException,insufficientFundsException,CreditException{
        
        int i = findCard(cardId);
        int j = findCard(cardDebitId);
        Card credit = null;
        Card debit = null;
        
        try {
            
            credit = cards.get(i);
            debit = cards.get(j);
            
        } catch (IndexOutOfBoundsException e) {
            
            throw  new IDException("CREDIT OR DEBIT CARD");
        }
        
        if (credit != null && debit != null) {
            
            if (credit.getType() == 1) {
                
                if (debit.getType() == 2) {
                    
                    if (!credit.isPayed()) {
                
                        if (debit.getAmount() >= amount && amount <= credit.getAmount()) {
                            
                            debit.setAmount(debit.getAmount()-amount);
                            credit.setAmount(credit.getAmount()-amount);
                            if (credit.getAmount() == 0) {

                                credit.setPayed(true);
                        
                            }else if(credit.getAmount() > 0){
                        
                                System.out.println("PAYMENT HAS BEEN SUCCESSFUL!, THE MISSING BALANCE IS: " + credit.getAmount() + " " + credit.getDivise());
                        
                            }
                        }else{
                            
                            throw new insufficientFundsException();
                        }
                    }else{
                        
                        throw new PayedException();
                    }
                }else{
                    
                    throw new CreditException();
                }
            }else{
                
                throw new PayException();
            }            
        }else{
            
            throw new IDException("CREDIT OR DEBIT CARD");
        }
    }
    
    public void withdraw(int cardId, long amount) throws IDException, insufficientFundsException, DebitException{
        
        int i = findCard(cardId);
        Card debit = null;
        
        try {

            debit = cards.get(i);
            
        } catch (IndexOutOfBoundsException e) {
            
            throw  new IDException("DEBIT CARD");
        }
        
        if (debit != null) {
            
            if (debit.getType() == 2) {
                
                if (debit.getAmount() >= amount) {
                    
                    debit.setAmount(debit.getAmount() - amount);
                    System.out.println("YOUR BALANCE IN THE DEBIT CARD: " + debit.getId() + " IS: " + debit.getAmount() + " " + debit.getDivise());                    
                }else{
                    
                    throw new insufficientFundsException();
                    
                }
            }else{
                
                throw new DebitException();
            }
        }else{
            
            throw new IDException("DEBIT CARD");
        }        
    }
    
    public void deposit(int cardId, long amount) throws IDException, DebitException{
        
        int i = findCard(cardId);
        Card debit = null;
        
        try {

            debit = cards.get(i);
            
        } catch (IndexOutOfBoundsException e) {
            
            throw  new IDException("DEBIT CARD");
        }
        
        if (debit != null) {
            
            if (debit.getType() == 2) {
                
                debit.setAmount(debit.getAmount()+amount);
            }else{
                
                throw new DebitException();
            }
        }else{
            
            throw new IDException("DEBIT CARD");
        }
    }
    
    public String showCards(){
        
        String msj = "";
        
        for (int i = 0; i < cards.size(); i++) {
            
            msj += cards.get(i).toString() + '\n';
        }
        
        if (msj.equals("")) {
            
            msj += "YOU DON'T HAVE ANY CARD";
        }
        
        return msj;
    }
    
 
    public int findCard(int cardId){
        
        boolean found = false;
        int i;
        
        for (i = 0; i < cards.size() && !found; i++) {
            
            if (cards.get(i).getId() == cardId) {
                
                found = true;                
            }
        }
                        
        return i;
    }
}