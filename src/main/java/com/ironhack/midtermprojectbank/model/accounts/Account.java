package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;
import com.ironhack.midtermprojectbank.model.users.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    protected Long id;
    @Embedded
    protected Money balance;
    @ManyToOne
//    @JoinColumn(name = "primaryOwner_id")
    protected AccountHolder primaryOwner;
    @ManyToOne
//    @JoinColumn(name = "secondaryOwner_id", insertable = false, updatable = false)
    protected AccountHolder secondaryOwner;
    protected BigDecimal penaltyFee;

    public Account(){}

    public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
