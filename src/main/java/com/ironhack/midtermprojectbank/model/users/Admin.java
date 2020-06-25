package com.ironhack.midtermprojectbank.model.users;

import javax.persistence.Entity;

@Entity
public class Admin extends User{

    public Admin(String name, String password) {
        super(name, password);
    }

    public Admin() {
    }
}
