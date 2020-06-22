package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.enums.Status;
import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;

import java.math.BigDecimal;

public class Checking extends StudentChecking{

    protected Money minimumBalance;
    protected BigDecimal monthlyMaintenanceFee;

    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, String secretKey, Status status, Money minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, secretKey, status);
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
