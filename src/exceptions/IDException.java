package exceptions;

/**
 *
 * @author diegoa.torres
 */
public class IDException extends Exception {

    public IDException(String object){
        
        super("THIS " + object +"  DOESN'T EXIST");
    }

    @Override
    public String toString() {
        return "IDException";
    }
}
