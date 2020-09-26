package model;

/**
 *
 * @author diegoa.torres
 */
class PayedException extends Exception {

    public PayedException() {
        super("THIS CREDIT CARD IS ALREADY PAYED");
    }
    
    
}
