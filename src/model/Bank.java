package model;

import java.util.ArrayList;

public class Bank {
    private Line<Client> line1;
    private Line<Client> line2;

    private ArrayList<CurrentClients> current;

    private ArrayList<BankDeserters> deserters;

    public Bank() {
        line1 = new Line<>();
        line2 = new Line<>();
        current = new ArrayList<>();
        deserters = new ArrayList<>();
    }
}
