package com.ironhack.midtermprojectbank.exception;

public class IllegalMinimumBalance extends RuntimeException{
    public IllegalMinimumBalance(){super();}
    public IllegalMinimumBalance(String message){super(message);}
}
