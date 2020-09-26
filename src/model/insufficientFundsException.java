package model;

/**
 *
 * @author diegoa.torres
 */
class insufficientFundsException extends Exception {

    public insufficientFundsException() {
        
        super("THERE ARE NOT ENOUGH FUNDS ON THE DEBIT CARD TO COVER THE DIGITED AMOUNT");
    }
}
