
class TransactionRecord {
    private int accountNumber;
    private double transactionAmount;

    TransactionRecord(int accountNumber, double transactionAmount){
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
    }

    TransactionRecord(){
        this.accountNumber = 0;
        this.transactionAmount = 0.0;
    }

    void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    int getAccountNumber() {
        return accountNumber;
    }
    double getTransactionAmount() {
        return transactionAmount;
    }
}
