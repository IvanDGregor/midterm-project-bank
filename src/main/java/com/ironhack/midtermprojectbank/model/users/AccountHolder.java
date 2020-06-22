package com.ironhack.midtermprojectbank.model.users;


import com.ironhack.midtermprojectbank.model.address.Address;

import java.time.LocalDateTime;

public class AccountHolder extends User{

    private LocalDateTime dateOfBirth;
    private Address primaryAdress;
    private Address mailingAdress;

    public AccountHolder(String name, String password, LocalDateTime dateOfBirth, Address primaryAdress, Address mailingAdress) {
        super(name, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAdress = primaryAdress;
        this.mailingAdress = mailingAdress;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAdress() {
        return primaryAdress;
    }

    public void setPrimaryAdress(Address primaryAdress) {
        this.primaryAdress = primaryAdress;
    }

    public Address getMailingAdress() {
        return mailingAdress;
    }

    public void setMailingAdress(Address mailingAdress) {
        this.mailingAdress = mailingAdress;
    }
}
