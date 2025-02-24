package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.enums.Status;
import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class StudentChecking extends Account{

    private String secretKey;
    @Enumerated(EnumType.STRING)
    private Status status;

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,  String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.status = Status.ACTIVE;
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
