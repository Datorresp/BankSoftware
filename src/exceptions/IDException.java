package exceptions;

/**
 *
 * @author diegoa.torres
 */
public class IDException extends Exception {

    public IDException(){
        
        super("THIS CREDIT CARD DOESN'T EXIST");
    }
}
