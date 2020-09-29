package model;

public class InactiveClient extends Client {
    
    private String causeOfInactivity;

    public InactiveClient(String causeOfInactivity, String name, String id, String phone, String address) {
        super(name, id, phone, address);
        this.causeOfInactivity = causeOfInactivity;
    }

    public String getCauseOfInactivity() {
        return causeOfInactivity;
    }

    public void setCauseOfInactivity(String causeOfInactivity) {
        this.causeOfInactivity = causeOfInactivity;
    }
    

}