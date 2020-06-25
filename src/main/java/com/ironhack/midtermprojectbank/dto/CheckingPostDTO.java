package com.ironhack.midtermprojectbank.dto;

import java.math.BigDecimal;

public class CheckingPostDTO {
    private BigDecimal balance;
    private Long idPrimaryOwner;
    private Long idSecondaryOwner;
    private String secretKey;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;

    public CheckingPostDTO(BigDecimal balance, Long idPrimaryOwner, Long idSecondaryOwner, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        this.balance = balance;
        this.idPrimaryOwner = idPrimaryOwner;
        this.idSecondaryOwner = idSecondaryOwner;
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
