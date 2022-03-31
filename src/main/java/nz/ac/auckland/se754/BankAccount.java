package nz.ac.auckland.se754;


public class BankAccount {

    private double balance;
    private int transactionLimit;
    private int numberTransactions;

    /**
     * Default constructor
     */
    public BankAccount() {
        balance = 0.0;
        transactionLimit = 10;

    }

    public double getBalance() {
        return balance;
    }


    public int getTransactionLimit() {
        return transactionLimit;
    }

    public int getNumberTransactions() {
        return numberTransactions;
    }


    /**
     * Add the given amount to the balance
     *
     * @param amount
     */
    public void deposit(double amount) {

        if (numberTransactions >= transactionLimit) {
            throw new LimitTransactionException();
        }

        balance = balance + amount;
        numberTransactions++;

    }

    /**
     * Subtract the given amount from balance
     *
     * @param amount
     */
    public void withdraw(double amount) {

        if (numberTransactions >= transactionLimit) {
            throw new LimitTransactionException();
        }

        if (amount > balance) {
            throw new BalanceNotEnoughException();
        }

        balance = balance - amount;
        numberTransactions++;
    }


}