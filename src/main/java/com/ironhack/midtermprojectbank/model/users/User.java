package com.ironhack.midtermprojectbank.model.users;

import com.ironhack.midtermprojectbank.model.accounts.Account;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    protected String name;
    protected String password;


    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
