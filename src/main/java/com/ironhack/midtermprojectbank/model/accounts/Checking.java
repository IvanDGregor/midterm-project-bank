package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.enums.Status;

import java.math.BigDecimal;

public class Checking {

    protected Money balance;
    protected String secretKey;
    protected String primaryOwner;
    protected String secundaryOwner;
    private Money minimumBalance;
    protected BigDecimal penaltyFee;
    private String monthlyMaintanceFee;
    protected Status status;

    public Checking() {
    }

    public Checking(Money balance, String secretKey, String primaryOwner, String secundaryOwner, BigDecimal penaltyFee, Status status) {
        this.balance = balance;
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner;
        this.secundaryOwner = secundaryOwner;
        this.penaltyFee = penaltyFee;
        this.status = status;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public String getSecundaryOwner() {
        return secundaryOwner;
    }

    public void setSecundaryOwner(String secundaryOwner) {
        this.secundaryOwner = secundaryOwner;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public String getMonthlyMaintanceFee() {
        return monthlyMaintanceFee;
    }

    public void setMonthlyMaintanceFee(String monthlyMaintanceFee) {
        this.monthlyMaintanceFee = monthlyMaintanceFee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
