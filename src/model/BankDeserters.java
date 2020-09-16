package model;

import java.util.Date;

public class BankDeserters extends Client {

    private Date departureDate;
    private String reason;

    public BankDeserters(String name, String id, Date departureDate, String reason) {
        super(name, id);
        this.departureDate = departureDate;
        this.reason = reason;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
