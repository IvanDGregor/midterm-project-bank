package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;
import com.ironhack.midtermprojectbank.model.users.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    protected Long id;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "currency"))

    })
    protected Money balance;
    @ManyToOne
    protected AccountHolder primaryOwner;
    @ManyToOne
    protected AccountHolder secondaryOwner;
    protected BigDecimal penaltyFee;
    protected LocalDateTime dateCreationAccount;
    protected LocalDateTime dateInterest;

    public Account(){}

    public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.dateCreationAccount = LocalDateTime.now();
        this.dateInterest = LocalDateTime.now();
        this.penaltyFee = new BigDecimal("40");
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

    public LocalDateTime getDateCreationAccount() {
        return dateCreationAccount;
    }

    public void setDateCreationAccount(LocalDateTime dateCreationAccount) {
        this.dateCreationAccount = dateCreationAccount;
    }

    public LocalDateTime getDateInterest() {
        return dateInterest;
    }

    public void setDateInterest(LocalDateTime dateInterest) {
        this.dateInterest = dateInterest;
    }
}
