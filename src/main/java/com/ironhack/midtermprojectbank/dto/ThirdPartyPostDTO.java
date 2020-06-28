package com.ironhack.midtermprojectbank.dto;

import java.math.BigDecimal;

public class ThirdPartyPostDTO {
    private BigDecimal amount;
    private Long idAccount;
    private String secretKey;

    public ThirdPartyPostDTO(BigDecimal amount, Long idAccount, String secretKey) {
        this.amount = amount;
        this.idAccount = idAccount;
        this.secretKey = secretKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
