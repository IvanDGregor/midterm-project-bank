package com.ironhack.midtermprojectbank.dto;

import java.math.BigDecimal;

public class CreditCardPostDTO {
    private BigDecimal balance;
    private Long idPrimaryOwner;
    private Long idSecondaryOwner;
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCardPostDTO(BigDecimal balance, Long idPrimaryOwner, Long idSecondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        this.balance = balance;
        this.idPrimaryOwner = idPrimaryOwner;
        this.idSecondaryOwner = idSecondaryOwner;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getIdPrimaryOwner() {
        return idPrimaryOwner;
    }

    public void setIdPrimaryOwner(Long idPrimaryOwner) {
        this.idPrimaryOwner = idPrimaryOwner;
    }

    public Long getIdSecondaryOwner() {
        return idSecondaryOwner;
    }

    public void setIdSecondaryOwner(Long idSecondaryOwner) {
        this.idSecondaryOwner = idSecondaryOwner;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
