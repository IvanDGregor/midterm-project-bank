package com.ironhack.midtermprojectbank.model.users;

import java.time.LocalDateTime;

public class AccountHolder {

    private String name;
    private LocalDateTime dateOfBirth;
    private Adress primaryAdress;
    private Adress mailingAdress;

    public AccountHolder(String name, LocalDateTime dateOfBirth, Adress primaryAdress, Adress mailingAdress) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.primaryAdress = primaryAdress;
        this.mailingAdress = mailingAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Adress getPrimaryAdress() {
        return primaryAdress;
    }

    public void setPrimaryAdress(Adress primaryAdress) {
        this.primaryAdress = primaryAdress;
    }

    public Adress getMailingAdress() {
        return mailingAdress;
    }

    public void setMailingAdress(Adress mailingAdress) {
        this.mailingAdress = mailingAdress;
    }
}
