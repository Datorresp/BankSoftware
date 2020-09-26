package model;

/**
 *
 * @author diegoa.torres
 */
class CreditException extends Exception {

    public CreditException() {
        super("YOU CAN'T PAY A CREDIT CARD WITH ANOTHER CREDIT CARD");
    }

}
