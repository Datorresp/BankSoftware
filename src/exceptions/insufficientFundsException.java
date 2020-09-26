package exceptions;

/**
 *
 * @author diegoa.torres
 */
public class insufficientFundsException extends Exception {

    public insufficientFundsException() {
        
        super("THERE ARE NOT ENOUGH FUNDS ON THE DEBIT CARD TO COVER THE DIGITED AMOUNT");
    }
}
