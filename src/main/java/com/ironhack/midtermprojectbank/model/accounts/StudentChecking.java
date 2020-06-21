package com.ironhack.midtermprojectbank.model.accounts;

import com.ironhack.midtermprojectbank.enums.Status;

import java.math.BigDecimal;

public class StudentChecking extends Checking{


    public StudentChecking(Money balance, String secretKey, String primaryOwner, String secundaryOwner, BigDecimal penaltyFee, Status status) {
        super(balance, secretKey, primaryOwner, secundaryOwner, penaltyFee, status);
    }
}
