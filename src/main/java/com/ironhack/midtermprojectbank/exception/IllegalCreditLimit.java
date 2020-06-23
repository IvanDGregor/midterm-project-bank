package com.ironhack.midtermprojectbank.exception;

public class IllegalCreditLimit extends RuntimeException{
    public IllegalCreditLimit (){super();}
    public IllegalCreditLimit(String message){super(message);}
}
