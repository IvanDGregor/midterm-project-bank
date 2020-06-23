package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;
import org.bson.codecs.ObjectIdGenerator;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;

@Entity
//@PrimaryKeyJoinColumn(name="id")
public class CreditCard extends Account {

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
    }

    public CreditCard() {
    }
}
