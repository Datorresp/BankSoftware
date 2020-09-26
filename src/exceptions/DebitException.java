package exceptions;

/**
 *
 * @author diegoa.torres
 */
public class DebitException extends Exception {

    public DebitException() {
        super("YOU CANNOT WITHDRAW OR DEPOSIT IN A CREDIT CARD");
    }

    
}
