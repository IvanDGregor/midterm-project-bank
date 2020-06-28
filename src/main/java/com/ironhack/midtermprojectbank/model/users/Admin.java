package com.ironhack.midtermprojectbank.model.users;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Admin extends User{

    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin() {
    }
}
