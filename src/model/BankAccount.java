package model;

import dataStructure.Stack;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 */
public class BankAccount {

    private ArrayList<Card> cards;
    private Stack<BankAccount>backUp;

    public BankAccount(ArrayList<Card> cards, Stack<BankAccount> backUp) {
        this.cards = cards;
        this.backUp = backUp;
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
    
    public void deleteCard(int cardId){
        
        int i = findCard(cardId);
        
        cards.remove(i);
          
    }
    
    public void payCardCash(int cardId, long amount) throws DebitException,PayedException,IDException{
        
        int i = findCard(cardId);
        Card aux = null;
        try {
            
            aux = cards.get(i);
            
        } catch (IndexOutOfBoundsException e) {
            
            throw  new IDException();
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

                throw new DebitException();
            }
        }else{
            
            throw new IDException();
        }
        
    }
    
    public void payCardDebit(int cardId, int cardDebitId, long amount) throws DebitException,PayedException,IDException,insufficientFundsException,CreditException{
        
        int i = findCard(cardId);
        int j = findCard(cardDebitId);
        Card credit = null;
        Card debit = null;
        
        try {
            
            credit = cards.get(i);
            debit = cards.get(j);
            
        } catch (IndexOutOfBoundsException e) {
            
            throw  new IDException();
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
                
                throw new DebitException();
            }            
        }else{
            
            throw new IDException();
        }
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
