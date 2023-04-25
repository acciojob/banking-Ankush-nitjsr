package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    public static int minBalance = 0;
    private int numberOfWithdraws;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public int getNumberOfWithdraws() {
        return numberOfWithdraws;
    }

    public void setNumberOfWithdraws(int numberOfWithdraws) {
        this.numberOfWithdraws = numberOfWithdraws;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, minBalance);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
        this.numberOfWithdraws = 0;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        if (numberOfWithdraws > maxWithdrawalLimit){
            throw new Exception("Maximum Withdraws Limit Exceed");
        }

        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (amount > super.getBalance()) {
            throw new Exception("Insufficient Balance");
        }
        //Update Balance after withdrawal of amount
        super.setBalance(super.getBalance()-amount);
        numberOfWithdraws++;
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double simpleInterest = super.getBalance() * rate * years;
        return simpleInterest + super.getBalance();
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = super.getBalance() * Math.pow(1 + rate/times, times*years);
        return compoundInterest;
    }

}
