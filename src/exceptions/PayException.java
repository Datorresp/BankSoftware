package exceptions;

/**
 *
 * @author diegoa.torres
 */
public class PayException extends Exception {
    
    public PayException() {
        super("DEBIT CARDS MUST NOT BE PAID");
        
    }
        
}
