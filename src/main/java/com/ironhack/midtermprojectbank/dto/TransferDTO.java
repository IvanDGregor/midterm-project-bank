package com.ironhack.midtermprojectbank.dto;

import java.math.BigDecimal;

public class TransferDTO {
    private Long idAccountOrigin;
    private BigDecimal amountToTranfer;
    private BigDecimal balanceAccountOrigin;
    private Long idAccountToTransfer;

    public TransferDTO(Long idAccountOrigin, BigDecimal amountToTranfer, BigDecimal balanceAccountOrigin, Long idAccountToTransfer) {
        this.idAccountOrigin = idAccountOrigin;
        this.amountToTranfer = amountToTranfer;
        this.balanceAccountOrigin = balanceAccountOrigin;
        this.idAccountToTransfer = idAccountToTransfer;
    }

    public Long getIdAccountOrigin() {
        return idAccountOrigin;
    }

    public void setIdAccountOrigin(Long idAccountOrigin) {
        this.idAccountOrigin = idAccountOrigin;
    }

    public BigDecimal getAmountToTranfer() {
        return amountToTranfer;
    }

    public void setAmountToTranfer(BigDecimal amountToTranfer) {
        this.amountToTranfer = amountToTranfer;
    }

    public BigDecimal getBalanceAccountOrigin() {
        return balanceAccountOrigin;
    }

    public void setBalanceAccountOrigin(BigDecimal balanceAccountOrigin) {
        this.balanceAccountOrigin = balanceAccountOrigin;
    }

    public Long getIdAccountToTransfer() {
        return idAccountToTransfer;
    }

    public void setIdAccountToTransfer(Long idAccountToTransfer) {
        this.idAccountToTransfer = idAccountToTransfer;
    }
}
