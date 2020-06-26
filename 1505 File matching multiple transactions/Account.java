class Account {
    private int accNum;
    private String firstName;
    private String lastName;
    private double balance;

    Account() {
        this.accNum = 0;
        this.firstName = "";
        this.lastName = "";
        this.balance = 0.0;
    }

    Account(int accountNumber, String firstName, String lastName, double balance) {
        this.accNum = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    void setAccountNumber(int accountNumber) {
        this.accNum = accountNumber;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    int getAccountNumber() {
        return accNum;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    double getBalance() {
        return balance;
    }

    void combine(TransactionRecord transactionRecord){
        balance -= transactionRecord.getTransactionAmount();
    }
}
