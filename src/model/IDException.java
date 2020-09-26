package model;

/**
 *
 * @author diegoa.torres
 */
class IDException extends Exception {

    public IDException(){
        
        super("THIS CREDIT CARD DOESN'T EXIST");
    }
}
