package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.enums.Status;
import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;

@Entity
//@PrimaryKeyJoinColumn(name="id")
public class Savings extends StudentChecking{

    private BigDecimal minimumBalance;

    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, String secretKey, Status status, BigDecimal minimumBalance) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, secretKey, status);
        this.minimumBalance = minimumBalance;
    }

    public Savings() {
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
