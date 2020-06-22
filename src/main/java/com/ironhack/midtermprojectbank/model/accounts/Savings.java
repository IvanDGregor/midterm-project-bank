package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.enums.Status;
import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;

import java.math.BigDecimal;

public class Savings extends StudentChecking{

    private Money minimumBalance;

    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, String secretKey, Status status, Money minimumBalance) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, secretKey, status);
        this.minimumBalance = minimumBalance;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
