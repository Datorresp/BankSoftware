package exceptions;

/**
 *
 * @author diegoa.torres
 */
public class CreditException extends Exception {

    public CreditException() {
        super("YOU CAN'T PAY A CREDIT CARD WITH ANOTHER CREDIT CARD");
    }

}
