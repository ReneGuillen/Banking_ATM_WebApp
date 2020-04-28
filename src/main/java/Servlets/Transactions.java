package simpleservlet;

import java.text.DecimalFormat;

public class Transactions {
    private double balance = 0.00;
    private DecimalFormat limitDecimal = new DecimalFormat("0.00");

    public Transactions(){
    }

    public void setBalance(double value){
        balance = value;
    }
    public void deposit(double value){
        balance += value;
    }

    public void withdraw(double value){
            balance -= value;
    }

    public String getBalance(){
        return limitDecimal.format(balance);
    }

    public void applyLoan(double amount, double score){
            balance += amount;
    }

    public boolean noBalance(double value){
        return balance == 0 || value > balance;
    }
}
