package model;

/**
 *
 * @author diegoa.torres
 */
public class Card {

    public static final int DEBIT = 1;
    public static final int CREDIT = 2;
    
    private int type, id;
    private long amount;
    private boolean Payed;
    private String divise;

    public Card(int type, long amount, boolean Payed, int id, String divise) {
        this.type = type;
        this.amount = amount;
        this.Payed = Payed;
        this.id =  id;
        this.divise = divise;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isPayed() {
        return Payed;
    }

    public void setPayed(boolean Payed) {
        this.Payed = Payed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDivise() {
        return divise;
    }

    public void setDivise(String divise) {
        this.divise = divise;
    }
    
    
    
}
