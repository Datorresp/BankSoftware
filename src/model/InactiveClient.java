package model;

public class InactiveClient extends Client {
    
    private String causeOfInactivity;

    public InactiveClient(String causeOfInactivity, String name, String id, String phone, String address, boolean disabled, boolean pregnant, int gender, int age) {
        super(name, id, phone, address, disabled, pregnant, gender, age);
        this.causeOfInactivity = causeOfInactivity;
    }

    public String getCauseOfInactivity() {
        return causeOfInactivity;
    }

    public void setCauseOfInactivity(String causeOfInactivity) {
        this.causeOfInactivity = causeOfInactivity;
    }
    

}