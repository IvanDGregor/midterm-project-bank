package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.enums.Status;
import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;

@Entity
//@PrimaryKeyJoinColumn(name="id")
public class StudentChecking extends Account{

    private String secretKey;
    private Status status;

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, String secretKey, Status status) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.status = status;
    }

    public StudentChecking() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
