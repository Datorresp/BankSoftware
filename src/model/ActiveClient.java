package model;

public class ActiveClient extends Client{

    private BankAccount account;

    public ActiveClient(BankAccount account, String name, String id, String phone, String address) {
        super(name, id, phone, address);
        this.account = account;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
    
    public void openABankAccount(BankAccount newBA){
        
        setAccount(newBA);
    }

}
