package model;

import java.util.ArrayList;

import dataStructure.Queue;

public class Bank {
    private Queue<Client> queue1;
    private Queue<Client> queue2;

    private ArrayList<CurrentClients> current;

    private ArrayList<BankDeserters> deserters;

    public Bank() {
        queue1 = new Queue<>();
        queue2 = new Queue<>();
        current = new ArrayList<>();
        deserters = new ArrayList<>();
    }
}
