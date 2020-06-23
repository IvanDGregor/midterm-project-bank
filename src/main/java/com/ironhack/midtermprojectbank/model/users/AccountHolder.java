package com.ironhack.midtermprojectbank.model.users;


import com.ironhack.midtermprojectbank.model.accounts.Account;
import com.ironhack.midtermprojectbank.model.address.Address;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class AccountHolder extends User{

    private LocalDateTime dateOfBirth;
    @Embedded
    private Address primaryAdress;
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "street_mailing_address")),
            @AttributeOverride(name = "number", column = @Column(name = "number_mailing_address")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_mailing_address")),
            @AttributeOverride(name = "city", column = @Column(name = "city_mailing_address")),
            @AttributeOverride(name = "country", column = @Column(name = "country_mailing_address"))
    })
    private Address mailingAdress;

    @OneToMany(mappedBy = "primaryOwner")
    protected List<Account> accountListPrimaryOwner;
    @OneToMany(mappedBy = "secondaryOwner")
    protected List<Account> accountListSecondaryOwner;

    public AccountHolder(String name, String password, LocalDateTime dateOfBirth, Address primaryAdress, Address mailingAdress) {
        super(name, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAdress = primaryAdress;
        this.mailingAdress = mailingAdress;
    }

    public AccountHolder() {
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
