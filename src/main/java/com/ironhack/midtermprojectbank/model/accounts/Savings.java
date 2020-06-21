package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.enums.Status;

import java.math.BigDecimal;

public class Savings extends Checking{

    private BigDecimal interestRate;

    public Savings(Money balance, String secretKey, String primaryOwner, String secundaryOwner, BigDecimal penaltyFee, Status status, BigDecimal interestRate) {
        super(balance, secretKey, primaryOwner, secundaryOwner, penaltyFee, status);
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
