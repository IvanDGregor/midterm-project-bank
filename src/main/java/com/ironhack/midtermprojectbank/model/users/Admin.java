package com.ironhack.midtermprojectbank.model.users;

import com.ironhack.midtermprojectbank.model.accounts.Account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
public class Admin extends User{

    public Admin(String name, String password) {
        super(name, password);
    }

    public Admin() {
    }
}
