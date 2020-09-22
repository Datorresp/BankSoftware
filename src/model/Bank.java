package model;

import java.util.ArrayList;

import dataStructure.Queue;

public class Bank {
    private Queue<Client> line1;
    private Queue<Client> line2;

    private ArrayList<CurrentClients> current;

    private ArrayList<BankDeserters> deserters;

    public Bank() {
        line1 = new Queue<>();
        line2 = new Queue<>();
        current = new ArrayList<>();
        deserters = new ArrayList<>();
    }
}
