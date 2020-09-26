package model;

/**
 *
 * @author diegoa.torres
 */
class DebitException extends Exception {
    
    public DebitException() {
        super("DEBIT CARDS MUST NOT BE PAID");
        
    }
        
}
