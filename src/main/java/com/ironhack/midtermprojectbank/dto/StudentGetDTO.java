package com.ironhack.midtermprojectbank.dto;

import java.math.BigDecimal;
import java.util.Currency;

public class StudentGetDTO {

    private BigDecimal balance;
    private Currency currency;

    public StudentGetDTO(BigDecimal balance, Currency currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
