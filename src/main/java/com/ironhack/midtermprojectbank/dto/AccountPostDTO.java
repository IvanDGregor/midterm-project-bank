package com.ironhack.midtermprojectbank.dto;

import java.math.BigDecimal;

public class AccountPostDTO {
    private Long idAccountReceiver;
    private Long idOwnerReceiver;
    private BigDecimal amount;

    public AccountPostDTO(Long idAccountReceiver, Long idOwnerReceiver, BigDecimal amount) {
        this.idAccountReceiver = idAccountReceiver;
        this.idOwnerReceiver = idOwnerReceiver;
        this.amount = amount;
    }

    public Long getIdAccountReceiver() {
        return idAccountReceiver;
    }

    public void setIdAccountReceiver(Long idAccountReceiver) {
        this.idAccountReceiver = idAccountReceiver;
    }

    public Long getIdOwnerReceiver() {
        return idOwnerReceiver;
    }

    public void setIdOwnerReceiver(Long idOwnerReceiver) {
        this.idOwnerReceiver = idOwnerReceiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
