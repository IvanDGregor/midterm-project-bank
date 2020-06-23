package com.ironhack.midtermprojectbank.exception;

import com.ironhack.midtermprojectbank.model.accounts.Savings;

public class IllegalInterestRateException extends RuntimeException{
    public IllegalInterestRateException(){super();}
    public IllegalInterestRateException(String message) {super(message  );}
}
